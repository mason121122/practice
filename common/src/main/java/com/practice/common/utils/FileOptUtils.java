package com.practice.common.utils;

import com.practice.model.enums.ResultEnum;
import com.practice.common.exception.BusinessException;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author Mark Wang
 * @date 2021/9/30
 * 文件导入导出工具类
 */
@Slf4j
public class FileOptUtils {

    /**
     * 导出CSV文件
     *
     * @param head
     * @param dataList
     * @param fileName
     * @param response
     */
    public static void exportCSV(List<String> head, List<List<String>> dataList, String fileName,
                                 HttpServletResponse response) {
        try {
            String csvEncoding = "UTF-8";
            // 设置响应
            response.setCharacterEncoding(csvEncoding);
            response.setContentType("text/csv; charset=" + csvEncoding);
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "max-age=30");

            fileName = URLEncoder.encode(fileName + ".csv", csvEncoding);// 通用
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

            @Cleanup ByteArrayOutputStream out = new ByteArrayOutputStream();
            @Cleanup BufferedWriter buffCvsWriter = new BufferedWriter(new OutputStreamWriter(out, csvEncoding));
            buffCvsWriter.write(new String(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF}));
            // 写入文件头部
            writeRow(head, buffCvsWriter);
            // 写入文件内容
            for (List<String> row : dataList) {
                writeRow(row, buffCvsWriter);
            }
            buffCvsWriter.flush();

            FileCopyUtils.copy(out.toByteArray(), response.getOutputStream());
        } catch (Exception e) {
            log.error("【FileOptUtils->exportCSV，导出CSV文件异常，异常原因={}.】", e.getMessage(), e);
            throw new BusinessException("导出CSV文件失败");
        }
    }

    /**
     * 写一行数据方法
     *
     * @param row
     * @param writer
     * @throws IOException
     */
    private static void writeRow(List<String> row, BufferedWriter writer) throws IOException {
        writer.write(StringUtils.join(row, ','));
        writer.newLine();
    }

    /**
     * 文件名校验
     *
     * @param fileName
     */
    public static void checkFileName(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            throw new BusinessException(ResultEnum.FILE_NAME_EMPTY_ERROR);
        }
        // 获取文件后缀名
        String fileSuffix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        if (!StringUtils.equals(fileSuffix, ".csv")) {
            throw new BusinessException(ResultEnum.FILE_SUFFIX_NAME_ERROR);
        }
    }

    /**
     * 文件行数校验
     *
     * @param count
     */
    public static void checkFileCount(int count) {
        if (count == 0) {
            throw new BusinessException(ResultEnum.FILE_CONTENT_EMPTY_ERROR);
        } else if (count > 2000) {
            throw new BusinessException(ResultEnum.FILE_COUNT_MAX_LIMIT_ERROR);
        }
    }

}
