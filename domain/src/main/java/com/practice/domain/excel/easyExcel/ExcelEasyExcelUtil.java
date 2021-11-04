package com.practice.domain.excel.easyExcel;


import com.alibaba.excel.EasyExcel;
import com.practice.common.utils.DateUtils;
import com.practice.model.bo.DownloadData;
import org.apache.commons.lang3.RandomUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Mark Wang
 * @date 2021/11/4
 */
public class ExcelEasyExcelUtil {

    public static List<DownloadData> getBigRowsDataMap(int dataTotal){
        List<DownloadData> dataLists= new ArrayList<DownloadData>();
        for(int i=0;i<dataTotal;i++){
            DownloadData dataObj = new DownloadData();
            dataObj.setName("name_"+(i+1));
            dataObj.setAge(RandomUtils.nextInt(22,100));
            dataObj.setScore(RandomUtils.nextDouble(85,100));
            dataObj.setPass(i / 2 == 0);
            dataObj.setTestDate(DateUtils.parseDatetimeString(new Date().toString(),"yyyy-MM-dd HH:mm:ss"));
            dataLists.add(dataObj);
        }
        return dataLists;
    }

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

    public static void exportExcelByEasyExcel(HttpServletRequest request, HttpServletResponse response, int dataTotal) throws IOException {
        long startTime=System.currentTimeMillis();
        String recordFileName="EasyExcel导出Excel_"+generateFileNameByDataTotal(dataTotal);
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode(recordFileName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("EasyExcel导出").doWrite(getBigRowsDataMap(dataTotal));
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
        System.out.println("EasyExcel导出"+exportRecord+" 数据 耗时: "+(endTime-startTime)/1000 +" 秒");
    }
}
