package com.springboot.myfirstwebapp.login;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // name을 session에 넣음 이 값을 사용하려는 모든 controller에 넣어줘야함
public class LoginController {

	private AuthenticationService authenticationService;

	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

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
		if (authenticationService.autehticate(name, password)) {
			model.put("name", name);
			return "welcome";
		}

		model.put("errorMessage", "Invalid Credentials");
		return "login";
	}

}
