package br.com.testkiller.business;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import br.com.testkiller.model.UsuarioFacebook;

@Component
public class LoginFacebook {
	
	public void obterUsuarioFacebook(String code)
			throws MalformedURLException, IOException {

		String retorno = readURL(new URL(this.getAuthURL(code)));

		String accessToken = null;
		@SuppressWarnings("unused")
		Integer expires = null;
		String[] pairs = retorno.split("&");
		for (String pair : pairs) {
			String[] kv = pair.split("=");
			if (kv.length != 2) {				
				throw new RuntimeException("Resposta auth inesperada.");				
			} else {
				if (kv[0].equals("access_token")) {
					accessToken = kv[1];
				}
				if (kv[0].equals("expires")) {
					expires = Integer.valueOf(kv[1]);
				}
			}
		}

		JSONObject resp = new JSONObject(readURL(new URL(
				"https://graph.facebook.com/me?access_token=" + accessToken)));

		UsuarioFacebook usuarioFacebook = new UsuarioFacebook(resp);

		System.out.println("Usuario encontrado: ");
		System.out.println(usuarioFacebook.getName());		
		System.out.println(usuarioFacebook.toString());		

	}

	private String readURL(URL url) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream is = url.openStream();
		int r;
		while ((r = is.read()) != -1) {
			baos.write(r);
		}
		return new String(baos.toByteArray());
	}

	public String getLoginRedirectURL() {
		return "https://graph.facebook.com/oauth/authorize?client_id="
				+ DadosDaAppNoFacebook.CLIENT_ID + "&display=page&redirect_uri=" + DadosDaAppNoFacebook.REDIRECT_URI
				+ "&scope=email,publish_actions";
	}

	public String getAuthURL(String authCode) {
		return "https://graph.facebook.com/oauth/access_token?client_id="
				+ DadosDaAppNoFacebook.CLIENT_ID + "&redirect_uri=" + DadosDaAppNoFacebook.REDIRECT_URI
				+ "&client_secret=" + DadosDaAppNoFacebook.CLIENT_SECRET + "&code=" + authCode;
	}

}
