package br.com.testkiller.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.testkiller.business.LoginFacebook;

@Controller
public class LoginFacebookController {
	
	@Autowired
	private LoginFacebook loginFacebook;

	@RequestMapping("/loginfb")
	public String logarComFacebook(){
		return "redirect:"+loginFacebook.getLoginRedirectURL();
	}
	
	@RequestMapping("/loginfbresponse")
	public String logarComFacebook(String code) throws MalformedURLException, IOException{
		
		loginFacebook.obterUsuarioFacebook(code);
		
		return "redirect:/";
	}
	
	
	
}