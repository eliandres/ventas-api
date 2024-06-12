package com.sy.system.com.security;

import lombok.Data;

@Data
public class AuthCredentials {

	private String usuario;
	private String contrasena;

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
