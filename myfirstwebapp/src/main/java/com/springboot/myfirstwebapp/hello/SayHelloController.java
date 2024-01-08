package com.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // MVC 모델 중 하나?
public class SayHelloController {

	@RequestMapping("say-hello") // URL mapping
	@ResponseBody // 원래는 return하면 view를 찾는데, 문자열 그대로를 출력
	public String sayHello() {
		return "Hello! What are you learning today?";
	}

	@RequestMapping("say-hello-html") // URL mapping
	@ResponseBody // 원래는 return하면 view를 찾는데, 문자열 그대로를 출력
	public String sayHellHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My first HTML Page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My firt html page with body");
		sb.append("</body>");
		sb.append("</html>");

		return sb.toString();
	}

	@RequestMapping("say-hello-jsp") // URL mapping
	// @ResponseBody // 원래는 return하면 view를 찾는데, 문자열 그대로를 출력 필요없어짐
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	public String sayHelloJsp() {
		return "sayHello";
	}
}
