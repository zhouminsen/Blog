package org.java.File;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.java.base.common.test.BaseTest;
import org.java.base.system.SystemConfig;
import org.java.base.system.UserConstant;
import org.java.util.FTPUtil;
import org.java.util.file.DownloadUtil;
import org.java.util.file.FileUtil;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

public class FileTest extends BaseTest {

    @Resource
    private FTPUtil ftpUtil;

    @Test
    public void mkdirs() throws IOException {
        String filePath = SystemConfig.getString("backup") + "/log/logLogin";
        File file = new File(filePath, "周家伟" + ".xls");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
    }

    /**
     * 如果该文件没有父目录的话创建会报错
     *
     * @throws IOException
     */
    @Test
    public void mkdirs2() throws IOException {
        String filePath = SystemConfig.getString("backup") + "/log/aaa/xx.txt";
        File file = new File(filePath);
        file.createNewFile();
    }

    @Test
    public void delete() {
        //D:\tomcat\apache-tomcat-8.0.26\webapps\Blog\html
        String path = "D:\\tomcat\\apache-tomcat-8.0.26\\webapps\\Blog\\html\\blogDetail41.html";
        FileUtil.deleteFile(path);
    }

    @Test
    public void newFile() throws IOException {
        FileUtil fileUtil = new FileUtil();
        File file = fileUtil.createNewFile("d:/ee", "haha.txt");
        System.out.println(file.getName());
        System.out.println(FileUtil.getNameWithoutExtension(file.getPath()));
    }

    @Test
    public void getFileBytes() {
        byte[] bs = FileUtil.getFileBytes(new File("C:\\Users\\Administrator\\Desktop\\sqlserver.sql"));
        System.out.println(bs.length);
    }

    @Test
    public void downloadImage() throws IOException {
        FTPClient ftp = new FTPClient();
        ftp.connect(ftpUtil.getFtpHost(), ftpUtil.getFtpPort());
        if (!ftp.login(ftpUtil.getFtpUserName(), ftpUtil.getFtpPassword())) {
            ftp.disconnect();
            System.err.println("FTP server refused connection.");
            System.exit(1);
        }

        ftp.enterLocalPassiveMode();
        //路径是相对路径
        InputStream is = ftp.retrieveFileStream(new String("/home/ftpuser/image/zjw/20170120172315.jpg".getBytes("UTF-8"), "ISO-8859-1"));
        OutputStream os = new FileOutputStream("C:\\Users\\zhoum\\Desktop\\bb.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        is.close();
        os.close();
        ftp.logout();
        if (ftp.isConnected()) {
            ftp.disconnect();
        }
    }

}
