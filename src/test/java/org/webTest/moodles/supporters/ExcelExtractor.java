package org.webTest.moodles.supporters;

import java.io.InputStream;
import java.io.FileInputStream;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExtractor {
    private String filePath;
    public ExcelExtractor(final String filepath) {
        this.filePath = filepath;
    }

    public void extractSheet(final String sheetName) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(this.filePath));
        XSSFSheet sheet = wb.getSheet(sheetName);
    }
}
