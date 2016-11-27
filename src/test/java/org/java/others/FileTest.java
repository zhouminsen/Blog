package org.java.others;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.java.base.system.SystemConfig;
import org.java.util.file.FileUtil;
import org.junit.Ignore;
import org.junit.Test;

public class FileTest {
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
	 * @throws IOException
	 */
	@Test
	public void mkdirs2() throws IOException {
		String filePath = SystemConfig.getString("backup") + "/log/aaa/xx.txt";
		File file=new File(filePath);
		file.createNewFile();
	}
	
	@Test
	public void delete() {
		//D:\tomcat\apache-tomcat-8.0.26\webapps\Blog\html
		String path="D:\\tomcat\\apache-tomcat-8.0.26\\webapps\\Blog\\html\\blogDetail41.html";
		FileUtil.deleteFile(path);
	}
	
	@Test
	public void newFile() throws IOException {
		FileUtil fileUtil=new FileUtil();
		File file=fileUtil.createNewFile("d:/ee", "haha.txt");
		System.out.println(file.getName());
		System.out.println(FileUtil.getNameWithoutExtension(file.getPath()));
	}
	
	@Test
	public void getFileBytes() {
		byte[] bs=FileUtil.getFileBytes(new File("C:\\Users\\Administrator\\Desktop\\sqlserver.sql"));
		System.out.println(bs.length);
	}
	
}
