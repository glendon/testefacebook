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

	/**
	 * Método que chama URL do facebook onde o usuário poderá autorizar a aplicação
	 * a acessar seus recursos privados.
	 * @return
	 */
	@RequestMapping("/loginfb")
	public String logarComFacebook(){
		return "redirect:"+loginFacebook.getLoginRedirectURL();
	}

	/**
	 * Executado quando o Servidor de Autorização fizer o redirect.
	 * @param 
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@RequestMapping("/loginfbresponse")
	public String logarComFacebook(String code) throws MalformedURLException, IOException{
		
		loginFacebook.obterUsuarioFacebook(code);
		
		return "redirect:/";
	}
	
}