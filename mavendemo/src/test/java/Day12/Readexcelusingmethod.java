package Day12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.mongodb.diagnostics.logging.Logger;

public class Readexcelusingmethod {
	static XSSFWorkbook wb;

	@Test
	public void excelread() {

		try {

			wb = new XSSFWorkbook(
					new FileInputStream(new File(System.getProperty("user.dir") + "/Testdata/logins.xlsx")));
			FileOutputStream fos = new FileOutputStream(
					new File(System.getProperty("user.dir") + "/Testdata/logins.xlsx"));

			String data = Readexcelusingmethod.getcelldata("QA", 2, 1);
			if(data.equalsIgnoreCase("dinesh")) {
				wb.getSheet("QA").getRow(2).getCell(1).setCellValue("PASS");
			}else
			{
				wb.getSheet("QA").getRow(2).getCell(1).setCellValue("FAIL");
			}
			wb.write(fos);
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

	public static String getcelldata(String sheetname, int row, int column) {
		String data = null;
		XSSFCell cell = wb.getSheet("QA").getRow(2).getCell(1);
		if (cell.getCellTypeEnum() == CellType.STRING) {
			data = cell.getStringCellValue();
		}
		if (cell.getCellTypeEnum() == CellType.NUMERIC) {
			data = String.valueOf((int) cell.getNumericCellValue());
		}
		if (cell.getCellTypeEnum() == CellType.BLANK) {
			data = "";
			System.out.println("no data found");
		}
		return data;
	}
}
