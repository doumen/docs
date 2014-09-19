package excel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

@Stateless
public class ExcelExporter {
	
	public <T> HSSFWorkbook createHSSFWorkbook(List<T> totalBarras,
			Method getLabelMethod, Method getDataMethod,String labelTitle,String dataTitle,String sheetName) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		HSSFWorkbook hSSFWorkbook = new HSSFWorkbook();
		HSSFSheet sheet = hSSFWorkbook.createSheet(sheetName);
		
		int rownum = 0;
		int cellnum = 0;
		
		Row row1 = sheet.createRow(rownum++);
		Cell cell1 = row1.createCell(cellnum++);
		cell1.setCellValue(labelTitle);
		Cell cell2 = row1.createCell(cellnum++);
		cell2.setCellValue(dataTitle);
		
		for(T t : totalBarras){
				String label = (String) getLabelMethod.invoke(t);
				Number data = (Number) getDataMethod.invoke(t);
				cellnum = 0;
				Row row = sheet.createRow(rownum++);
				row.createCell(cellnum++).setCellValue(label);
				row.createCell(cellnum++).setCellValue(data.doubleValue());
				
			for(int i=0;i<cellnum;i++)
				sheet.autoSizeColumn(i,true);
		}
		return hSSFWorkbook;
	}

	public void writeJFreeChartOnHSSFWorkbook(JFreeChart barChart,
			HSSFWorkbook workbook,String sheetName,int chartWidth,int chartHeight,int chartColumn,int chartRow) throws IOException {
		
		ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
		ChartUtilities.writeChartAsPNG(chart_out, barChart, chartWidth, chartHeight);
		/*
		 * We can now read the byte data from output stream and stamp the chart
		 * to Excel worksheet
		 */
		int my_picture_id = workbook.addPicture(chart_out.toByteArray(),
				Workbook.PICTURE_TYPE_PNG);
		/* we close the output stream as we don't need this anymore */
		chart_out.close();
		/* Create the drawing container */
		
		HSSFSheet sheet = workbook.getSheet(sheetName);
				
		if(sheet == null)
			workbook.createSheet(sheetName);
			
		HSSFPatriarch drawing = sheet.createDrawingPatriarch();
		/* Create an anchor point */
		ClientAnchor my_anchor = new HSSFClientAnchor();
		/* Define top left corner, and we can resize picture suitable from there */
		my_anchor.setCol1(chartColumn);
		my_anchor.setRow1(chartRow);
		/* Invoke createPicture and pass the anchor point and ID */
		HSSFPicture my_picture = drawing
				.createPicture(my_anchor, my_picture_id);
		/* Call resize method, which resizes the image */
		my_picture.resize();
		
	}
}
