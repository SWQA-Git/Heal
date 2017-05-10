----------- Pre-requisite ---------------

Eclipse should be install
 - Download Eclipse for MAC:http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/neon3

Java Development Kit(JDK)
 - Download JDK8 for MAC: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

---------- JARS FILE -----------------------
Selenium-server-standalone
 - Download: http://www.seleniumhq.org/download/

Excel Reader/Write 
 - Download: http://www.java2s.com/Code/Jar/j/Downloadjxljar.htm

Listeners
 -Download: 

Log File
 - Download: http://www.java2s.com/Code/Jar/a/Downloadapachelog4j1215jar.htm
 - Refer doc: Log4j2 set up
 - Online Link: http://syncor.blogspot.in/2013/09/getting-started-with-log4j-2-in-eclipse.html

TestNg
 - Guide Link: http://www.seleniumeasy.com/testng-tutorials/how-to-install-testng-step-by-step

------------ SetUp -------------------

- Add all the jar in "lib" folder
- Import project into elicpse (File -> Import)
- Install TestNG form elicpse 
	- Help -> Install new software
	- Click on Add
	- http://beust.com/eclipse
	- For more details please refer link provide in pre-requisite
- Do the setup of Log4j2 by refering the doc mention in pre-requisite
- Add all the jar file in libraries
	- Right click on project
	- Build Path -> Configure Build Path
	- Java Build Path -> Libraries 
	- Click on Add External Link
	- Open the lib folder of the project and add all the jars

------------ How to Run the test -------------

- Run Single test 
	- Open class under package  "test.patient" (Eg:. HealPatientLoginTest)
	- Right click on test method (Eg:. testSecurityCheckRedirectToLoginPage)
	- RunAs - TestNG Test
- Run a functionality test :
	- Open class under package  "test.patient" (Eg:. HealPatientLoginTest)
	- Right Click -> Run As -> TestNG Test
- Run test Suite : 
	- Right Click on testng.xml file 
	- Run As -> TestNG Suite
	





 

	 