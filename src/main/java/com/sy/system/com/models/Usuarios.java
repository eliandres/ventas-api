package com.sy.system.com.models;

import lombok.Data;

@Data
public class Usuarios {
	 	
	 	private String Usuario;
	    private String Contrasena;
	    private String Telefono;
	    
	    public Usuarios(String Usuario, String Contrasena, String Telefono) {
	        this.Usuario = Usuario;
	        this.Contrasena = Contrasena;
	        this.Telefono = Telefono;
	    }
	 
		public String getUsuario() {
			return Usuario;
		}
		public void setUsuario(String usuario) {
			Usuario = usuario;
		}

		public String getContrasena() {
			return Contrasena;
		}

		public void setContrasena(String contrasena) {
			Contrasena = contrasena;
		}

		public String getTelefono() {
			return Telefono;
		}

		public void setTelefono(String telefono) {
			Telefono = telefono;
		}
	

	
}
