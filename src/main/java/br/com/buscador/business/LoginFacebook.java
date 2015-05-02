package br.com.buscador.business;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.buscador.controller.HomeController;
import br.com.buscador.model.UsuarioFacebook;
@Component
public class LoginFacebook {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    private static final String client_secret = "24f552b781e681e0afe2c7c8c01190f2";
    private static final String client_id = "959396717438199"; 
    private static final String redirect_uri = "http://localhost:8080/buscador/loginfbresponse";

    public void obterUsuarioFacebook(String code)
			throws MalformedURLException, IOException {
    	logger.info("Obtendo o usuário do Facebook.");
 
		String retorno = readURL(new URL(LoginFacebook.getAuthURL(code)));
 
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
				+ client_id + "&display=page&redirect_uri=" + redirect_uri
				+ "&scope=email";
	}

	 public static String getAuthURL(String authCode) {
         return "https://graph.facebook.com/oauth/access_token?"+
                 "client_id=" + client_id +
                 "&redirect_uri=" + redirect_uri + 
                 "&client_secret=" + client_secret + 
                 "&code=" + authCode;
     }
//	public String getAuthURL(String authCode) {
//		return "https://graph.facebook.com/oauth/access_token?client_id="
//				+ client_id + "&redirect_uri=" + redirect_uri
//				+ "&client_secret=" + client_secret + "&code=" + authCode;
//	}

}
