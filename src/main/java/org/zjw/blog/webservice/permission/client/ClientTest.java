package org.zjw.blog.webservice.permission.client;



import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.zjw.blog.base.cxf.imageServer.interceptor.AddHeaderInterceptor;
import org.zjw.blog.webservice.permission.service.UploadImageService;
import org.zjw.blog.webservice.permission.service.UploadImageServiceImplService;


/**
 * @author Administrator
 *
 */
public class ClientTest {

	public static void main(String[] args) {
		UploadImageServiceImplService service=new UploadImageServiceImplService();
		 UploadImageService uploadImageService=service.getUploadImageServiceImplPort();
		
		org.apache.cxf.endpoint.Client client=ClientProxy.getClient(uploadImageService);
		client.getOutInterceptors().add(new AddHeaderInterceptor("1")); // 添加自定义拦截器
		client.getInInterceptors().add(new LoggingInInterceptor()); // 添加In拦截器 日志拦截器
		client.getOutInterceptors().add(new LoggingOutInterceptor()); // 添加Out拦截器 日志拦截器
		String str = null;
		try {
			str = uploadImageService.getUploadAuth(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("我有没有啊" + str);
		//System.out.println(helloWorld.say("java1234_小锋"));
		
		/*User user=new User();
		user.setUserName("jack");
		user.setPassword("123456");
		List<Role> roleList=helloWorld.getRoleByUser(user);
		for(Role role:roleList){
			System.out.println(role.getId()+","+role.getRoleName());
		}*/
		
	}
}
