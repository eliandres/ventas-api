package com.sy.system.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sy.system.com.models.Usuarios;
import com.sy.system.com.service.UsuarioService;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuarios usuarios = usuarioService.CargaUsuario(username);
		if (usuarios == null) {
			throw new UsernameNotFoundException("Usuario no encontrado: " + username);
		}

		return new UserDetailsImpl(usuarios);
	}
}
