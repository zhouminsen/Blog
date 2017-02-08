package org.java.util.file;

import java.io.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class DownloadUtil {

    /**
     * @param filePath   要下载的文件路径
     * @param returnName 返回的文件名
     * @param response   HttpServletResponse
     * @param delFlag    是否删除文件
     */
    protected void download(String filePath, String returnName, HttpServletResponse response, boolean delFlag) {
        this.prototypeDownload(new File(filePath), returnName, response, delFlag);
    }


    /**
     * @param file       要下载的文件
     * @param returnName 返回的文件名
     * @param response   HttpServletResponse
     * @param delFlag    是否删除文件
     */
    protected void download(File file, String returnName, HttpServletResponse response, boolean delFlag) {
        this.prototypeDownload(file, returnName, response, delFlag);
    }

    /**
     * @param file       要下载的文件
     * @param returnName 返回的文件名
     * @param response   HttpServletResponse
     * @param delFlag    是否删除源文件
     */
    public void prototypeDownload(File file, String returnName, HttpServletResponse response, boolean delFlag) {
        // 下载文件
        FileInputStream inputStream = null;
        ServletOutputStream outputStream = null;
        if (!file.exists()) return;
        //将文件读入响应流
        try {
            inputStream = new FileInputStream(file);
            prototypeDownload(inputStream, returnName, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (delFlag) {
            file.delete();
        }
    }

    /**
     * @param returnName 返回的文件名
     * @param response   HttpServletResponse
     */
    public void prototypeDownload(InputStream is, String returnName, HttpServletResponse response) {
        // 下载文件
        ServletOutputStream outputStream = null;
        try {
            //设置响应类型	PDF文件为"application/pdf"，WORD文件为："application/msword"， EXCEL文件为："application/vnd.ms-excel"。
            response.setContentType("application/octet-stream;charset=utf-8");

            //设置响应的文件名称,并转换成中文编码
            //returnName = URLEncoder.encode(returnName,"UTF-8");
            returnName = response.encodeURL(new String(returnName.getBytes(), "iso8859-1"));    //保存的文件名,必须和页面编码一致,否则乱码

            //attachment作为附件下载；inline客户端机器有安装匹配程序，则直接打开；注意改变配置，清除缓存，否则可能不能看到效果
            response.addHeader("Content-Disposition", "attachment;filename=" + returnName);

            //将文件读入响应流
            outputStream = response.getOutputStream();
            int length = 1024;
            int readLength = 0;
            byte buf[] = new byte[1024];
            readLength = is.read(buf, 0, length);
            while (readLength != -1) {
                outputStream.write(buf, 0, readLength);
                readLength = is.read(buf, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * by tony 2013-10-17
     *
     * @param byteArrayOutputStream 将文件内容写入ByteArrayOutputStream
     * @param response              HttpServletResponse	写入response
     * @param returnName            返回的文件名
     */
    public void download(ByteArrayOutputStream byteArrayOutputStream, HttpServletResponse response, String returnName) throws IOException {
        response.setContentType("application/octet-stream;charset=utf-8");
        returnName = response.encodeURL(new String(returnName.getBytes(), "iso8859-1"));            //保存的文件名,必须和页面编码一致,否则乱码
        response.addHeader("Content-Disposition", "attachment;filename=" + returnName);
        response.setContentLength(byteArrayOutputStream.size());
        ServletOutputStream outputstream = response.getOutputStream();    //取得输出流
        byteArrayOutputStream.writeTo(outputstream);                    //写到输出流
        byteArrayOutputStream.close();                                    //关闭
        outputstream.flush();                                            //刷数据
    }
}
