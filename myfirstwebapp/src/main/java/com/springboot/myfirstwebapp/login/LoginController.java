package com.springboot.myfirstwebapp.login;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	// private Logger logger = LoggerFactory.getLogger(getClass());

	// Model을 통해서 jsp에 param을 넣음
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String gotoLoginPage() {
		// logger.debug("request param is {}", name);
		// logger.info("JI want this printed at info level {}", name);
		// model.put("name", name);
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}

}
