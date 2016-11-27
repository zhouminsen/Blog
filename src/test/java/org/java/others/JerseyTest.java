package org.java.others;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class JerseyTest {
	
	/**
	 * 发送图片
	 * @throws IOException
	 */
	@Test
	public void put() throws IOException {
		// 创建Client对象 注意是 jersey 中的 Client com.sun.jersey.api.client.Client;
		Client client = new Client();
		// 服务器地址
		String url = "http://localhost:8080/imageServer/file/qqqqq.jpg";
		WebResource wr = client.resource(url);
		// 要传输的文件地址
		String path = "E:/develop/工具模板/文件测试/IMG_20111216_200859.jpg";
		// 输入流 读图片到内存中
		byte[] readFileToByteArray = FileUtils.readFileToByteArray(new File(
				path));
		// 向服务器发送文件
		wr.put(String.class, readFileToByteArray);
		System.out.println("发送完毕");
	}
}
