package com_SkillRray_genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.mysql.cj.jdbc.Driver;
/**
 * Contains resuable methods to read the data from externalresources
 * @author Bharani
 *
 */
public class FileUtilies {
public static Connection con;
	/**
	 * Used to read the data from property file
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getpropertyData(String key) throws FileNotFoundException, IOException {
		Properties p=new Properties();
		p.load(new FileInputStream(AutoConstant.propertyfilePath));
		return p.getProperty(key);
		
		}
	/**
	 * Get the connection to database
	 * @return
	 * @throws SQLException
	 */
	
	public static Connection getDataDb() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		return con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wsa01","root",
				"root");
	}
	/**
	 * To execute the query
	 * @param query
	 * @param column
	 * @param Expecteddata
	 * @return
	 * @throws SQLException
	 */
	public static String queryExecution(String query,int column,String Expecteddata) throws SQLException {
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			if(result.getString(column).equals(Expecteddata)) {
				break;
			}
			else
			{
				Reporter.log("Data not found",true);
			}
		}
		return Expecteddata;
	
	}
	/**
	 * Close the database connection
	 * @throws SQLException
	 */
	public static void closedb() throws SQLException {
		con.close();
	}
	
	/**
	 * To read the data from execl
	 * @param SheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String SheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(AutoConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
	 return wb.getSheet(SheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		
	}
	
	@DataProvider
	public Object[][] readExcelData() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(AutoConstant.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowNum = sh.getLastRowNum();
		short cellNum = sh.getRow(1).getLastCellNum();
		Object obj[][]=new Object[rowNum][cellNum];
		for(int i=0;i<rowNum;i++) {
			for(int j=0;j<cellNum;j++) {
				obj[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(obj[i][j]);
			}
		}
		return obj;
	}

}
