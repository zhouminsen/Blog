package org.zjw.blog.base.cxf.imageServer.interceptor;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class AddHeaderInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	private String userId;
	
	public AddHeaderInterceptor(String userId) {
		super(Phase.PREPARE_SEND); // 准备发送SOAP消息的时候调用拦截器
		this.userId=userId;
	}

	public void handleMessage(SoapMessage message) throws Fault {
		List<Header> headerList = message.getHeaders();
		Document doc = DOMUtils.createDocument();
		Element ele = doc.createElement("authHeader");
		Element uElement = doc.createElement("userId");
		uElement.setTextContent(userId);
		ele.appendChild(uElement);
		headerList.add(new Header(new QName("java1234"), ele));
	}
}
