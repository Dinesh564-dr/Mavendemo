package Day12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Readconfigfile2 {
	@Test
	public void excelread() {

		try {
			FileInputStream fis = new FileInputStream(
					new File(System.getProperty("user.dir") + "/Testdata/logins.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			String data = wb.getSheet("QA").getRow(0).getCell(0).getStringCellValue();

			System.out.println(data);
			wb.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("fie not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sheet not found");
		}
	}
}
