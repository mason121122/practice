package com.practice.domain.excel.poi;

import com.practice.common.utils.DateUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author Mark Wang
 * @date 2021/11/4
 */
public class ExcelPoiUtil {

    private static String generateFileNameByDataTotal(int dataTotal){
        String excelFileName="导出数据总记录";
        int recordCount;
        if(dataTotal<=1000){
            excelFileName+="1K条";
        }else if(dataTotal<=10000){
            recordCount=dataTotal/1000;
            excelFileName+=recordCount+"K条";
        }else if(dataTotal<=100000){
            recordCount=dataTotal/10000;
            excelFileName+=recordCount+"W条";
        }else if(dataTotal<=1000000){
            recordCount=dataTotal/10000;
            excelFileName+=recordCount+"W条";
        }
        return excelFileName;
    }

    public  static List<Map<String, Object>> getBigRowsDataMap(int dataTotal) {
        List<Map<String, Object>> dataLists = new ArrayList<>();
        for (int i = 0; i < dataTotal; i++) {
            Map<String, Object> rowData = new LinkedHashMap<>();
            rowData.put("name", "name_" + (i + 1));
            rowData.put("age", RandomUtils.nextInt(22, 100));
            rowData.put("score", RandomUtils.nextDouble(85, 100));
            rowData.put("pass", i / 2 == 0);
            rowData.put("testDate", DateUtils.formatDatetimeStr(new Date()));
            dataLists.add(rowData);
        }
        return dataLists;
    }
    /**
     * 使用POI 3.8 以上版本 SXSSFWorkbook 导出大数据量数据到Excel之中
     */
    public static void exportExcelBySXSSFWorkbook(HttpServletRequest request, HttpServletResponse response, int dataTotal)throws IOException {
        long startTime =System.currentTimeMillis();
        String recordFileName="SXSSF_POI导出Excel_"+generateFileNameByDataTotal(dataTotal);
        // keep 100 rows in memory, exceeding rows will be flushed to disk
        Workbook wb = new SXSSFWorkbook(100);
        Sheet sh = wb.createSheet();
        List<Map<String, Object>> dataList=ExcelPoiUtil.getBigRowsDataMap(dataTotal);
        Row rowHeader = sh.createRow(0);
        String[] headers=new String[]{"姓名","年龄","成绩","是否合格","考试日期"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = rowHeader.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        for(int rownum = 0; rownum < dataList.size(); rownum++){
            Row row = sh.createRow(rownum+1);
            Map<String, Object> cellMap=dataList.get(rownum);
            int cellIndex=0;
            for (Map.Entry<String, Object> m : cellMap.entrySet()) {
                Cell cell = row.createCell(cellIndex);
                cell.setCellValue(m.getValue().toString());
                cellIndex++;
            }
        }
        //文件输出流
        OutputStream os = null;
        String fileName = recordFileName+".xlsx";
        try {
            //重点突出输出到浏览器
            os = response.getOutputStream();
            //解决浏览器兼容问题
            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
                fileName = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
            } else {
                // 对文件名进行编码处理中文问题
                // 处理中文文件名的问题
                fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
                // 处理中文文件名的问题
                fileName= new String(fileName.getBytes("UTF-8"), "GBK");
            }
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            //中文名称需要特殊处理
            response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(recordFileName, "UTF-8")+".xlsx");
            wb.write(os);
        }finally {
            try {
                if(os != null){
                    os.flush();
                    os.close();
                }
            } catch (Exception ignored) {
            }
        }
        long endTime=System.currentTimeMillis();
        String exportRecord="";
        int recordCount;
        if(dataTotal<=1000){
            exportRecord+="1K条";
        }else if(dataTotal<=10000){
            recordCount=dataTotal/1000;
            exportRecord+=recordCount+"K条";
        }else if(dataTotal<=1000000){
            recordCount=dataTotal/10000;
            exportRecord+=recordCount+"W条";
        }
        System.out.println("导出"+exportRecord+" 数据 耗时: "+(endTime-startTime)/1000 +" 秒");
    }
}
