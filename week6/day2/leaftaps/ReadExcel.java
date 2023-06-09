package assignments.week6.day2.leaftaps;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {

	@Test
	public static String[][] readExcel(String filename) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./data/leads/" + filename + ".xlsx");
		XSSFSheet sheet = wb.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rows][cols];
		for (int i = 1; i <= rows; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cols; j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();
			}
		}
		wb.close();
		return data;
	}

}
