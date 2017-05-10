package lib.common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class XLReader
{
	private Workbook			workbook	= null;
	private WorkbookSettings	wbs			= new WorkbookSettings();
	private final static Logger	logger		= LogManager.getLogger(XLReader.class.getName());

	XLReader(String filePath)
	{
		String ext = FilenameUtils.getExtension(filePath);
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

	// Get the row number when you know the Column value
	int getRowNumber(String sheetName, String valueInColumn)
	{
		Sheet worksheet = workbook.getSheet(sheetName);
		if (worksheet == null)
		{
			logger.fatal("Sheet name " + sheetName + " does not exist.");
			Assert.fail("No such sheet " + sheetName);
		}
		int totalRows = worksheet.getRows();
		for (int rowNumber = 0; rowNumber < totalRows; rowNumber++)
			if (worksheet.getCell(0, rowNumber).getContents().equals(valueInColumn)) return rowNumber;
		return -1;
	}

	// Returns the Cell value by taking row and Column values as argument
	String getCellValue(String sheetName, int column, int row)
	{
		return workbook.getSheet(sheetName).getCell(column, row).getContents();
	}

	String getValueFor(String sheetName, String elementName)
	{
		int rowNumber = getRowNumber(sheetName, elementName);
		return rowNumber >= 0 ? getCellValue(sheetName, 1, rowNumber) : null;
	}

	List<String> getValuesFor(String sheetName, String elementName)
	{
		wbs.setSuppressWarnings(true);
		int rowNumber = getRowNumber(sheetName, elementName);
		if (rowNumber < 0) return null;
		Cell[] cells = workbook.getSheet(sheetName).getRow(rowNumber);
		ArrayList<String> retval = new ArrayList<>();
		for (int i = 1; i < cells.length; i++)
		{
			retval.add(cells[i].getContents());
		}
		return retval;
	}

}