package component;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.ScatterChartData;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;
/* Line Chart Example in Apache POI */

public class ExcelChartExporterComponent {
	public static void main(String[] args) {
		try {
			// lineCharts();
			// scatterChart();
			jFreeChartExample();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scatterChart() throws Exception {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("Sheet 1");
		final int NUM_OF_ROWS = 3;
		final int NUM_OF_COLUMNS = 10;

		// Create a row and put some cells in it. Rows are 0 based.
		Row row;
		Cell cell;
		for (int rowIndex = 0; rowIndex < NUM_OF_ROWS; rowIndex++) {
			row = sheet.createRow((short) rowIndex);
			for (int colIndex = 0; colIndex < NUM_OF_COLUMNS; colIndex++) {
				cell = row.createCell((short) colIndex);
				cell.setCellValue(colIndex * (rowIndex + 1));
			}
		}
		Drawing drawing = sheet.createDrawingPatriarch();
		ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);

		Chart chart = drawing.createChart(anchor);
		ChartLegend legend = chart.getOrCreateLegend();
		legend.setPosition(LegendPosition.TOP_RIGHT);

		ScatterChartData data = chart.getChartDataFactory()
				.createScatterChartData();

		ValueAxis bottomAxis = chart.getChartAxisFactory().createValueAxis(
				AxisPosition.BOTTOM);
		ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(
				AxisPosition.LEFT);
		leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

		ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet,
				new CellRangeAddress(0, 0, 0, NUM_OF_COLUMNS - 1));
		ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(sheet,
				new CellRangeAddress(1, 1, 0, NUM_OF_COLUMNS - 1));
		ChartDataSource<Number> ys2 = DataSources.fromNumericCellRange(sheet,
				new CellRangeAddress(2, 2, 0, NUM_OF_COLUMNS - 1));

		data.addSerie(xs, ys1);
		data.addSerie(xs, ys2);

		chart.plot(data, bottomAxis, leftAxis);

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(
				"/home/desenv/ooxml-scatter-chart.xlsx");
		wb.write(fileOut);
		fileOut.close();
	}

	public static void lineCharts() throws Exception {
		/* Create a Workbook object that will hold the final chart */
		XSSFWorkbook my_workbook = new XSSFWorkbook();
		/*
		 * Create a worksheet object for the line chart. This worksheet will
		 * contain the chart
		 */
		XSSFSheet my_worksheet = my_workbook.createSheet("LineChart_Example");

		/* Let us now create some test data for the chart */
		/*
		 * Later we can see how to get this test data from a CSV File or SQL
		 * Table
		 */
		/* We use a 4 Row chart input with 5 columns each */
		for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
			/* Add a row that contains the chart data */
			XSSFRow my_row = my_worksheet.createRow((short) rowIndex);
			for (int colIndex = 0; colIndex < 5; colIndex++) {
				/* Define column values for the row that is created */
				XSSFCell cell = my_row.createCell((short) colIndex);
				cell.setCellValue(colIndex * (rowIndex + 1));
			}
		}
		/*
		 * At the end of this step, we have a worksheet with test data, that we
		 * want to write into a chart
		 */
		/* Create a drawing canvas on the worksheet */
		XSSFDrawing xlsx_drawing = my_worksheet.createDrawingPatriarch();
		/* Define anchor points in the worksheet to position the chart */
		XSSFClientAnchor anchor = xlsx_drawing.createAnchor(0, 0, 0, 0, 0, 5,
				10, 15);
		/* Create the chart object based on the anchor point */
		XSSFChart my_line_chart = xlsx_drawing.createChart(anchor);
		/* Define legends for the line chart and set the position of the legend */
		XSSFChartLegend legend = my_line_chart.getOrCreateLegend();
		legend.setPosition(LegendPosition.BOTTOM);
		
		/* Create data for the chart */
		LineChartData data = my_line_chart.getChartDataFactory()
				.createLineChartData();
		/* Define chart AXIS */
		ChartAxis bottomAxis = my_line_chart.getChartAxisFactory()
				.createCategoryAxis(AxisPosition.BOTTOM);
		ValueAxis leftAxis = my_line_chart.getChartAxisFactory()
				.createValueAxis(AxisPosition.LEFT);
		leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
		/* Define Data sources for the chart */
		/* Set the right cell range that contain values for the chart */
		/* Pass the worksheet and cell range address as inputs */
		/*
		 * Cell Range Address is defined as First row, last row, first column,
		 * last column
		 */
		ChartDataSource<Number> xs = DataSources.fromNumericCellRange(
				my_worksheet, new CellRangeAddress(0, 0, 0, 4));
		ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(
				my_worksheet, new CellRangeAddress(1, 1, 0, 4));
		ChartDataSource<Number> ys2 = DataSources.fromNumericCellRange(
				my_worksheet, new CellRangeAddress(2, 2, 0, 4));
		ChartDataSource<Number> ys3 = DataSources.fromNumericCellRange(
				my_worksheet, new CellRangeAddress(3, 3, 0, 4));
		/* Add chart data sources as data to the chart */
		data.addSerie(xs, ys1);
		data.addSerie(xs, ys2);
		data.addSerie(xs, ys3);
		/* Plot the chart with the inputs from data and chart axis */
		my_line_chart.plot(data, new ChartAxis[] { bottomAxis, leftAxis });
		/* Finally define FileOutputStream and write chart information */
		FileOutputStream fileOut = new FileOutputStream(
				"/home/desenv/xlsx-line-chart.xlsx");
		my_workbook.write(fileOut);
		fileOut.close();
	}

	public static void jFreeChartExample() throws Exception {
		/*
		List<Assinante> assinantes = (new AssinanteComponent()).getAssinantes();
		
		HSSFWorkbook my_workbook = new HSSFWorkbook();
		
		HSSFSheet sheet = my_workbook.createSheet("Dados");
		
		
		/* Create Dataset that will take the chart data 
		DefaultCategoryDataset my_bar_chart_dataset = new DefaultCategoryDataset();
		/* We have to load bar chart data now 
		/* Begin by iterating over the worksheet 
		/* Create an Iterator object 
		String chart_label = "a";
		Number chart_data = 0;
		
		int rownum = 0;
		int cellnum = 0;
		
		Row row1 = sheet.createRow(rownum++);
		Cell cell1 = row1.createCell(cellnum++);
		cell1.setCellValue("Assinante");
		Cell cell2 = row1.createCell(cellnum++);
		cell2.setCellValue("Total Doctos");
		
		for (Assinante assinante : assinantes) {
			// Read Rows from Excel document
			// Read cells in Rows and get chart data
			chart_data = assinante.getTotalDoctosArmazenados();
			chart_label = assinante.getNomeFantasia();
			my_bar_chart_dataset.addValue(chart_data.doubleValue(), "Total Doctos",
					chart_label);
			
			cellnum = 0;
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(cellnum++);
			cell.setCellValue(assinante.getNomeFantasia());
			row.createCell(cellnum++).setCellValue(assinante.getTotalDoctosArmazenados());
		}
		sheet.autoSizeColumn(0,true);
		sheet.autoSizeColumn(1,true);

		/* Add data to the data set 
		/*
		 * We don't have grouping in the bar chart, so we put them in fixed
		 * group
		 

		/* Create a logical chart object with the chart data collected 
		JFreeChart BarChartObject = ChartFactory.createBarChart(
				"Gráfico de Interação por Assinante", "Assinantes", "Total de Doctos", my_bar_chart_dataset,
				PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plot = (CategoryPlot) BarChartObject.getPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		/* Dimensions of the bar chart 
		int width = 15*assinantes.size(); /* Width of the chart 
		int height = 480; /* Height of the chart 
		/*
		 * We don't want to create an intermediate file. So, we create a byte
		 * array output stream and byte array input stream And we pass the chart
		 * data directly to input stream through this
		 
		/* Write chart as PNG to Output Stream 
		ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
		ChartUtilities
				.writeChartAsPNG(chart_out, BarChartObject, width, height);
		/*
		 * We can now read the byte data from output stream and stamp the chart
		 * to Excel worksheet
		 
		int my_picture_id = my_workbook.addPicture(chart_out.toByteArray(),
				Workbook.PICTURE_TYPE_PNG);
		/* we close the output stream as we don't need this anymore 
		chart_out.close();
		/* Create the drawing container 
		HSSFPatriarch drawing = sheet.createDrawingPatriarch();
		/* Create an anchor point 
		ClientAnchor my_anchor = new HSSFClientAnchor();
		/* Define top left corner, and we can resize picture suitable from there 
		my_anchor.setCol1(4);
		my_anchor.setRow1(5);
		/* Invoke createPicture and pass the anchor point and ID 
		HSSFPicture my_picture = drawing
				.createPicture(my_anchor, my_picture_id);
		/* Call resize method, which resizes the image 
		my_picture.resize();
		/* Write changes to the workbook 
		
		FileOutputStream out = new FileOutputStream(new File(
				"/home/desenv/barChart.xls"));
		my_workbook.write(out);
		out.close();
		*/
	}

	
}
