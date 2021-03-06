package writeExcelinJava;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDemo {

	public static void main(String[] args) {
		//crear un workbook en blancl
        XSSFWorkbook workbook = new XSSFWorkbook(); 
         
        //crear una hoja de excel
        XSSFSheet sheet = workbook.createSheet("Ejercicio");
          
        //datos que vamos a escribir (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"NAME", "LASTNAME", "EMAIL", "PASSWORD", "COMPANY", "ADDRESS", "CITY", "ZIP_CODE", "MOBILE_PHONE"});
        data.put("2", new Object[]  {"Mariana", "Vives", "marianaV@hexaware.com", "abc123def", "Hexaware Technologies", "Paseo del Abedul 123", "Zapopan", "45123", "3324943509"});
        data.put("3", new Object[] {"Sandra", "Silva", "sandraS@hexaware.com", "a1b2c3", "Hexaware Technologies", "Calle Paseo del Sol 45", "Saltillo", "55065", "9882346789"});
        data.put("4", new Object[] {"James", "Williamson", "jamesWill@oracle.com", "987zyx", "Oracle", "Campanas del Mirador 34", "Monterrey", "76832", "4578352810"});
          
        //iterar los datos y escribir sobre la hoja de excel
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //escribir el workbook en los archivos del sistema
            FileOutputStream out = new FileOutputStream(new File("escribirArchivosExcelConJava.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("escribirArchivosExcelConJava.xlsx guardado exitosamente en el disco.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}

}
