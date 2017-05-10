package lib.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

// TODO: Do we need this class at all?

class XLUpdater
{
	private Sheet				worksheet	= null;
	private Workbook			workbook	= null;
	private String				fileName;
	// private WorkbookSettings wbs = new WorkbookSettings();
	private final static Logger	logger		= LogManager.getLogger(XLUpdater.class.getName());

	XLUpdater(String filePath)
	{
		String ext = FilenameUtils.getExtension(filePath);
		fileName = filePath;
		if (ext.equalsIgnoreCase("xls"))
		{
			try
			{
				workbook = Workbook.getWorkbook(new File(filePath));
			}
			catch (IOException e)
			{
				logger.fatal("IOException while reading Excel File " + filePath, e);
				Assert.fail("IO Exception while reading Excel file " + filePath, e);
			}
			catch (BiffException e)
			{
				logger.fatal("BiffException while reading Excel File " + filePath, e);
				Assert.fail("XLS Process Exception while reading Excel file " + filePath, e);
			}
		}
	}

	// Modifying Excel Sheet
	private void excelUtilityUpdate(String sheet, String columnName, String accountNo, int index)
	{
		String ext = FilenameUtils.getExtension(fileName);
		logger.info("File Extension is " + ext);
		try
		{
			workbook = Workbook.getWorkbook(new File(fileName));
		}
		catch (IOException e)
		{
			logger.fatal("IOException while reading Excel File " + fileName, e);
			Assert.fail("IO Exception while reading Excel file " + fileName, e);
		}
		catch (BiffException e)
		{
			logger.fatal("BiffException while reading Excel File " + fileName, e);
			Assert.fail("XLS Process Exception while reading Excel file " + fileName, e);
		}

		try
		{
			WritableWorkbook wwbCopy = Workbook.createWorkbook(new File(fileName), workbook);
			WritableSheet sheetToEdit = wwbCopy.getSheet(sheet);
			WritableCell cell;
			Label l = new Label(getColNumber(sheet, columnName), index, accountNo);
			cell = l;
			sheetToEdit.addCell(cell);
			wwbCopy.close();
		}
		catch (IOException e)
		{
			logger.fatal("IOException while creating workbook " + workbook + " in Excel File " + fileName, e);
			Assert.fail("IO Exception while creating workbook " + workbook + " in Excel File " + fileName, e);
		}
		catch (WriteException e)
		{
			logger.fatal("XLS Write Exception while writing into workbook " + workbook + " in Excel File " + fileName, e);
			Assert.fail("XLS Write Exception while writing into workbook " + workbook + " in Excel File " + fileName, e);
		}
		workbook.close();
	}

	private void excelUtilityListUpdate(String sheet, HashMap<String, String[][]> data)
	{
		for (String clmn : data.keySet())
		{
			for (int cnt = 0; cnt < data.get(clmn)[0].length; cnt++)
			{
				excelUtilityUpdate(sheet, clmn, data.get(clmn)[1][cnt], Integer.parseInt(data.get(clmn)[0][cnt]));
			}
		}
	}

	// Modifying CSV
	private void csvUtilityUpdate(String columnName, String accountNo, int index)
	{
		try
		{
			FileInputStream fstream = new FileInputStream(fileName);
			@SuppressWarnings("resource") BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			HashMap<String, String[]> hm = new HashMap<String, String[]>();

			int cnt = 0;
			while ((strLine = br.readLine()) != null)
			{
				hm.put("Line" + cnt, strLine.trim().split(","));
				cnt++;
			}
			for (int j = 0; j < hm.get("Line" + index).length; j++)
			{
				String colName = hm.get("Line0")[j];
				if (colName.endsWith("\"")) colName = colName.substring(1, colName.length() - 1);
				if (colName.equals(columnName))
				{
					hm.get("Line" + index)[j] = accountNo;
				}
			}
			modifyCSV(hm);
		}
		catch (FileNotFoundException e)
		{
			assert false : "File not found " + fileName;
		}
		catch (IOException e)
		{
			assert false : "IO exception while reading from " + fileName;
		}
	}

	private void csvUtilityListUpdate(HashMap<String, String[][]> data)
	{
		for (String clmn : data.keySet())
		{
			for (int cnt = 0; cnt < data.get(clmn)[0].length; cnt++)
			{
				csvUtilityUpdate(clmn, data.get(clmn)[1][cnt], Integer.parseInt(data.get(clmn)[0][cnt]));
			}
		}
	}

	void update(String sheet, HashMap<String, String[][]> data)
	{
		String ext = FilenameUtils.getExtension(fileName);
		if (ext.equalsIgnoreCase("xls"))
		{
			excelUtilityListUpdate(sheet, data);
		}
		if (ext.equalsIgnoreCase("csv"))
		{
			csvUtilityListUpdate(data);
		}
	}

	private void modifyCSV(HashMap<String, String[]> data) throws FileNotFoundException
	{
		String csvData = "";
		PrintWriter writer = new PrintWriter(fileName);

		for (int i = 0; i < data.size(); i++)
		{
			for (int j = 0; j < data.get("Line" + i).length; j++)
			{
				csvData = csvData + data.get("Line" + i)[j] + ",";
			}
			csvData = csvData.substring(0, csvData.length() - 1);
			writer.println(csvData);
			csvData = "";
		}
		writer.close();
	}

	// Get the Column number when you know the row value
	int getColNumber(String sheetName, String valueInColumn)
	{
		worksheet = workbook.getSheet(sheetName);
		int totalCols = worksheet.getColumns();
		for (int colNumber = 0; colNumber < totalCols; colNumber++)
		{
			if (worksheet.getCell(colNumber, 0).getContents().equals(valueInColumn)) return colNumber;
		}
		return -1;
	}

	Sheet getWorksheet()
	{
		return worksheet;
	}

	void setWorksheet(Sheet worksheet)
	{
		this.worksheet = worksheet;
	}

	Workbook getWorkbook()
	{
		return workbook;
	}

	void setWorkbook(Workbook workbook)
	{
		this.workbook = workbook;
	}

}