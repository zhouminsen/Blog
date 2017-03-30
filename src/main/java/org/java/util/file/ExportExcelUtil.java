package org.java.util.file;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;










import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.java.base.system.SystemConfig;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * excel下载工具类
 * @author Administrator
 *
 */
public class ExportExcelUtil {
	/************************************jxl操作excel******************************************************/
	
	/**
	 * 功能提示用户选择路径,根据传入的数据生成excel写入到用户选择的路径中
	 * @param response 响应对象
	 * @param brow 眉显示
	 * @param titleRow 标题行创建所需
	 * @param bodyRow 主体部分创建所需
	 * @param tail 尾显示(后面有重载的方法,可以不传)
	 * @throws Exception 
	 */
	//总结:可以设置默认的行高,和列宽(后面的指定行,指定列设置的行高和列宽会覆盖默认设置)
	//总结:每一行都可以单独通过 表对象.setRowView设置行高
	//总结:每一列都可以单独通过 表对象.setColumnView设置列宽
	//总结:创建单元格时的4个参数,列索引>行索引>内容>单元格样式
	public static void createExcel(HttpServletResponse response,
			String brow,String[] titleRow,List<String[]> bodyRow,String tail) throws Exception{
		try {
			//输出流
			OutputStream out = response.getOutputStream();
			//重置输出流
			response.reset();
			//设置响应类型
			response.setContentType("application/vnd.ms-excel");
			//设置响应标题>这里浏览器会提示用户选择下载文件需要存放的路径>
			//后续生成的文件在输出流关闭后>action返回detailExcel进result指定响应内容为excel>自动写入该excel到该用户指定的路径中
			response.setHeader("Content-disposition", "attachment; fileName=" + new String((brow+".xls").getBytes(), "iso8859-1"));
			//response.setHeader("Content-disposition", "attachment; fileName=" + URLEncoder.encode(brow,"utf-8")+".xls");(不可用)

			//基于输出流建立excel文件
			WritableWorkbook wbook = Workbook.createWorkbook(out); 
			//创建名为导出"导出数据"索引为0的表
			WritableSheet wsheet = wbook.createSheet("导出数据", 0);
			
			//字体>定义格式、字体大小、粗体、(false)是否斜体、有无下划线、字体颜色(适合做眉,标题行的字体样式)
			WritableFont font = new WritableFont(
					 WritableFont.ARIAL, 14,
	        	     WritableFont.BOLD, false,
	        	     UnderlineStyle.NO_UNDERLINE,
	        	     jxl.format.Colour.BLACK); 
			
			//主题字号
			WritableFont bodyFont = new WritableFont(
					WritableFont.ARIAL, 12,
					WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE,
					 jxl.format.Colour.BLACK); 
			
			//眉单元格样式
	        WritableCellFormat browStyle = new WritableCellFormat(font);
	        //标题单元格样式
	        WritableCellFormat titleStyle = new WritableCellFormat(font);
	        //主体单元格样式(主体采用默认字体样式),奇数,偶数行
	        WritableCellFormat bodyStyle = new WritableCellFormat(bodyFont);
	        
	        //尾单元格样式
	        WritableCellFormat tailStyle = new WritableCellFormat(font);
	        
	        //单元格对齐方式(居中对齐)
	        browStyle.setAlignment(jxl.format.Alignment.CENTRE); 
	        titleStyle.setAlignment(jxl.format.Alignment.CENTRE);
	        bodyStyle.setAlignment(jxl.format.Alignment.CENTRE); 
	        tailStyle.setAlignment(jxl.format.Alignment.CENTRE); 
	        
	        //单元格边框(上下左右全部细线)
	        browStyle.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN); 
	        titleStyle.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN); 
	        bodyStyle.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN); 
	        tailStyle.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN); 
	        
	        //设置颜色
	        browStyle.setBackground(Colour.RED);
	        
	        //工作薄设置默认列宽
	        wsheet.getSettings().setDefaultColumnWidth(22);
	       //工作薄设置默认行高
	        wsheet.getSettings().setDefaultRowHeight(300);
	        //如果需要单独设置某列的列宽>如下设置,第一个参数为列索引,第二个为列宽
	       /* wsheet.setColumnView(0, 20);
	        wsheet.setColumnView(1, 10);
	        wsheet.setColumnView(2, 20);*/
	        
	        /*********************************开始画*************************************/
	        /*********************创建眉(第一行)(单独指定行高)***********************/
	        //行索引从0开始
			int rowIndex = 0;
			//设置第一行(眉)的行高
			wsheet.setRowView(0, 500);
			
			wsheet.addCell(new Label(0, 0, brow,browStyle));
			//前两个参数确定坐上角,后两个确定右下角
			wsheet.mergeCells(0, 0, titleRow.length-1 , 0);
			//游标走到下一行
			rowIndex++;
			
			/*********************创建标题行(第二行)(单独指定行高)***********************/
			//设置第二行(标题行)的行高
			wsheet.setRowView(rowIndex, 380);
			//创建标题行
			for (int i = 0; i < titleRow.length; i++) {
				if(titleRow[i].equals("流失原因")){
					 wsheet.setColumnView(i, 40);
				}
				wsheet.addCell(new Label(i, rowIndex, titleRow[i],titleStyle));
			}
			//游标走到下一行
			rowIndex++;
			
			/*********************创建主体部分(采用默认行高)***********************/
			//创建主体部分
			//分析1:外循环确定总创建的行数
			for (int i = 0; i < bodyRow.size(); i++) {
				
				String[] row=bodyRow.get(i);
				//分析2:内循环 根据循环到的数组具体创建每一行
				for (int j = 0; j < row.length; j++) {
					wsheet.addCell(new Label(j, rowIndex, row[j],bodyStyle));
				}
				//每创建一行
				//游标走到下一行
				rowIndex++;
			}
			/*********************创建尾(如果尾不为空)***********************/
			if (tail!=null&&!tail.equals("")) {
				
				wsheet.addCell(new Label(0, rowIndex, tail,tailStyle));
				//前两个参数确定坐上角,后两个确定右下角
				wsheet.mergeCells(0, rowIndex, titleRow.length-1 , rowIndex);
			}
			/*********************************画完*************************************/
			//输出以及关闭
			wbook.write();
			if (wbook != null) {
				//关闭的时候可能会异常
				wbook.close();
			}
			out.close();
		} catch (Exception e) {
			throw new Exception("导出excel异常");
		}
	}
	/**
	 * @param response 响应对象
	 * @param brow 眉显示
	 * @param titleRow 标题行创建所需(其长度就是总列数>眉和尾合并单元格时往右的偏移量)
	 * @param bodyRow 主体部分创建所需
	 * @throws Exception 
	 */
	public static void createExcel(HttpServletResponse response,
			String brow,String[] titleRow,List<String[]> bodyRow) throws Exception{
		createExcel(response, brow, titleRow, bodyRow, null);
	}
	
	/**
	 * 不要response  直接写入到指定文件中
	 * @param out	输出流
	 * @param brow  页眉
	 * @param titleRow	标题栏
	 * @param bodyRow	主体内容
	 * @param tail	尾部标题
	 * @throws Exception
	 */
	public static void createExcel(OutputStream out, String brow,String[] titleRow,List<String[]> bodyRow,String tail) throws Exception {
		try {
			// 基于输出流建立excel文件
			WritableWorkbook wbook = Workbook.createWorkbook(out);
			// 创建名为导出"导出数据"索引为0的表
			WritableSheet wsheet = wbook.createSheet("导出数据", 0);

			// 字体>定义格式、字体大小、粗体、(false)是否斜体、有无下划线、字体颜色(适合做眉,标题行的字体样式)
			WritableFont font = new WritableFont(WritableFont.ARIAL, 14,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.BLACK);

			// 主题字号
			WritableFont bodyFont = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.BLACK);

			// 眉单元格样式
			WritableCellFormat browStyle = new WritableCellFormat(font);
			// 标题单元格样式
			WritableCellFormat titleStyle = new WritableCellFormat(font);
			// 主体单元格样式(主体采用默认字体样式),奇数,偶数行
			WritableCellFormat bodyStyle = new WritableCellFormat(bodyFont);

			// 尾单元格样式
			WritableCellFormat tailStyle = new WritableCellFormat(font);

			// 单元格对齐方式(居中对齐)
			browStyle.setAlignment(jxl.format.Alignment.CENTRE);
			titleStyle.setAlignment(jxl.format.Alignment.CENTRE);
			bodyStyle.setAlignment(jxl.format.Alignment.CENTRE);
			tailStyle.setAlignment(jxl.format.Alignment.CENTRE);

			// 单元格边框(上下左右全部细线)
			browStyle.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);
			titleStyle.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);
			bodyStyle.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);
			tailStyle.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);

			// 设置颜色
			browStyle.setBackground(Colour.RED);

			// 工作薄设置默认列宽
			wsheet.getSettings().setDefaultColumnWidth(22);
			// 工作薄设置默认行高
			wsheet.getSettings().setDefaultRowHeight(300);
			// 如果需要单独设置某列的列宽>如下设置,第一个参数为列索引,第二个为列宽
			/*
			 * wsheet.setColumnView(0, 20); wsheet.setColumnView(1, 10);
			 * wsheet.setColumnView(2, 20);
			 */

			/********************************* 开始画 *************************************/
			/********************* 创建眉(第一行)(单独指定行高) ***********************/
			// 行索引从0开始
			int rowIndex = 0;
			// 设置第一行(眉)的行高
			wsheet.setRowView(0, 500);

			wsheet.addCell(new Label(0, 0, brow, browStyle));
			// 前两个参数确定坐上角,后两个确定右下角
			wsheet.mergeCells(0, 0, titleRow.length - 1, 0);
			// 游标走到下一行
			rowIndex++;

			/********************* 创建标题行(第二行)(单独指定行高) ***********************/
			// 设置第二行(标题行)的行高
			wsheet.setRowView(rowIndex, 380);
			// 创建标题行
			for (int i = 0; i < titleRow.length; i++) {
				if (titleRow[i].equals("流失原因")) {
					wsheet.setColumnView(i, 40);
				}
				wsheet.addCell(new Label(i, rowIndex, titleRow[i], titleStyle));
			}
			// 游标走到下一行
			rowIndex++;

			/********************* 创建主体部分(采用默认行高) ***********************/
			// 创建主体部分
			// 分析1:外循环确定总创建的行数
			for (int i = 0; i < bodyRow.size(); i++) {

				String[] row = bodyRow.get(i);
				// 分析2:内循环 根据循环到的数组具体创建每一行
				for (int j = 0; j < row.length; j++) {
					wsheet.addCell(new Label(j, rowIndex, row[j], bodyStyle));
				}
				// 每创建一行
				// 游标走到下一行
				rowIndex++;
			}
			/********************* 创建尾(如果尾不为空) ***********************/
			if (tail != null && !tail.equals("")) {

				wsheet.addCell(new Label(0, rowIndex, tail, tailStyle));
				// 前两个参数确定坐上角,后两个确定右下角
				wsheet.mergeCells(0, rowIndex, titleRow.length - 1, rowIndex);
			}
			/********************************* 画完 *************************************/
			// 输出以及关闭
			wbook.write();
			if (wbook != null) {
				// 关闭的时候可能会异常
				wbook.close();
			}
		} catch (Exception e) {
			throw new Exception("导出excel异常");
		}
		out.close();
	}
	
	
/**********************************poi操作excel*********************************************************/
	
	/**
	 * poi创建excel
	 * @param os 输出流
	 * @param sheetName 工作薄名称
	 * @param brow     页眉
	 * @param titleRow 标题行
	 * @param bodyRow  主体内容
	 */
	public static void createExcel(OutputStream os ,String sheetName,String brow,String[] titleRow,List<String[]> bodyRow) {
		try {
			HSSFWorkbook wb = new HSSFWorkbook();//创建工作簿
			HSSFSheet sheet = wb.createSheet(sheetName);//第一个sheet
			HSSFRow rowFirst = sheet.createRow(0);//第一个sheet第一行为标题
			rowFirst.setHeight((short) 500);
			for (int i = 0; i < titleRow.length; i++) {
				sheet.setColumnWidth((short) i, (short) 4000);// 设置列宽
			}
			//写标题了
			for (int i = 0; i < titleRow.length; i++) {
			    //获取第一行的每一个单元格
			    HSSFCell cell = rowFirst.createCell(i);
			    //往单元格里面写入值
			    cell.setCellValue(titleRow[i]);
			}
			for (int i = 0;i < bodyRow.size(); i++) {
				 //获取list里面存在是数据集对象
			    String[] rows = bodyRow.get(i);
			    //创建数据行
			    HSSFRow row = sheet.createRow(i+1);
			    //设置对应单元格的值
			    row.setHeight((short)400);   // 设置每行的高度
			    //"序号","操作人","IP地址","操作时间","操作模块","操作类型","详情"
			    for (int j = 0; j < rows.length; j++) {
				    row.createCell(j).setCellValue(i+1);
					row.createCell(j).setCellValue(rows[j]);
				}
			}
			wb.write(os);
			os.flush();
			os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
