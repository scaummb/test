package Utils.demo.excelDemoSXSSFdemo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Date: 2019/6/2 15 :37
 *
 * @author moubin.mo
 */

public class testSXSSFWorkbook {
    public static void main(String[] args) throws IOException {
        testWriteLargeData();
    }

    public static void testWriteLargeData() throws IOException {
        long time = System.currentTimeMillis();
//        File file = new File("C:\\Users\\zuolin\\Desktop\\mytemplate.xlsx");
        // 1.创建一个输入流
        FileInputStream inputStream = new FileInputStream("C:\\Users\\zuolin\\Desktop\\mytemplate.xls");
        // 2.创建一个工作book对象
        XSSFWorkbook wb_template = new XSSFWorkbook(inputStream);
        // 3.关闭输入流
        inputStream.close();
        // 4.创建SXSSFWorkbook，它的性能比XSSFWorkbook优化很多
        SXSSFWorkbook wb = new SXSSFWorkbook(wb_template);
        // 5.开启文件压缩(大概意思酱紫)
        wb.setCompressTempFiles(true);
        // 6.创建工作表对象
        SXSSFSheet sh = (SXSSFSheet) wb.getSheetAt(0);
        sh.setRandomAccessWindowSize(100);  // keep 100 rows in memory, exceeding rows will be flushed to disk
        for(int rownum = 4; rownum < 100; rownum++){
            // 7.创建一行对象
            Row row = sh.createRow(rownum);
            for(int cellnum = 0; cellnum < 10; cellnum++){
                // 8.创建一个单元格
                Cell cell = row.createCell(cellnum);
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address);
            }

        }

        FileOutputStream out = new FileOutputStream("C:\\Users\\zuolin\\Desktop\\mytemplate.xls");
        wb.write(out);
        out.close();
        // dispose of temporary files backing this workbook on disk
        wb.dispose();
    }
}
