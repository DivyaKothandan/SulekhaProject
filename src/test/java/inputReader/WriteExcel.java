package inputReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.formula.functions.DStarRunner.DStarAlgorithmEnum;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ExcelStyleDateFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String xlFilePath;

	public WriteExcel(String xlFilePath) throws IOException {
		this.xlFilePath = xlFilePath;
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}

	public boolean setCellData(String sheetName, String colName, int rowNum, String value) {
		try {
			int col_Num = -1;
			sheet = workbook.getSheet(sheetName);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
					col_Num = i;
				}
			}

			sheet.autoSizeColumn(col_Num);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(col_Num);
			if (cell == null)
				cell = row.createCell(col_Num);
			cell.setCellValue(value);

			fos = new FileOutputStream(xlFilePath);
			workbook.write(fos);
			fos.close();
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}

		return true;

	}
	
	

}
