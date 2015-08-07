package br.com.testkiller.model;

import org.json.JSONObject;

public class UsuarioFacebook {

	private Long id; 
	private String firstName; 
	private Integer timezone; 
	private String email; 
	private Boolean verified;	
	private String middleName;	
	private String gender;	
	private String lastName;
	private String link;
	private String locale;	
	private String name;	
	private String updatedTime;
	
	public UsuarioFacebook(JSONObject jsonUsuario){
		
		String[] fields = JSONObject.getNames(jsonUsuario);
		
		for (String field : fields) {
			if (field.equals("id")) {
				id = jsonUsuario.getLong("id");
				continue;
			}
			if (field.equals("first_name")) {
				firstName = jsonUsuario.getString("first_name");
				continue;
			}
			if (field.equals("timezone")) {
				timezone = jsonUsuario.getInt("timezone");
				continue;
			}
			if (field.equals("email")) {
				email = jsonUsuario.getString("email");
				continue;
			}
			if (field.equals("verified")) {
				verified = jsonUsuario.getBoolean("verified");
				continue;
			}
			if (field.equals("middle_name")) {
				middleName = jsonUsuario.getString("middle_name");
			}
			if (field.equals("gender")) {
				gender = jsonUsuario.getString("gender");
				continue;
			}
			if (field.equals("last_name")) {
				lastName = jsonUsuario.getString("last_name");
				continue;
			}
			if (field.equals("link")) {
				link = jsonUsuario.getString("link");
				continue;
			}
			if (field.equals("locale")) {
				locale = jsonUsuario.getString("locale");
				continue;
			}
			if (field.equals("name")) {
				name = jsonUsuario.getString("name");
				continue;
			}
			if (field.equals("updated_time")) {
				updatedTime = jsonUsuario.getString("updated_time");
				continue;
			}
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "UsuarioFacebook [id=" + id + ", firstName=" + firstName
				+ ", timezone=" + timezone + ", email=" + email + ", verified="
				+ verified + ", middleName=" + middleName + ", gender="
				+ gender + ", lastName=" + lastName + ", link=" + link
				+ ", locale=" + locale + ", name=" + name + ", updatedTime="
				+ updatedTime + "]";
	}
	
}
