package com.sy.system.com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sy.system.com.models.Usuarios;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Usuarios CargaUsuario(String usuario) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("ObtenerUsuario");

		Map<String, Object> params = new HashMap<>();
		params.put("NombreUsuario", usuario);

		Map<String, Object> result = jdbcCall.execute(params);
		if (result.isEmpty()) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> resultSet = (List<Map<String, Object>>) result.get("#result-set-1");
		if (resultSet == null || resultSet.isEmpty()) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}

		Map<String, Object> userRow = resultSet.get(0);

		String password = (String) userRow.get("Contrasena");
		String usuariob = (String) userRow.get("NombreUsuario");
		// String nombrePersonal = (String) userRow.get("NombrePersonal");
		// String correoElectronico = (String) userRow.get("CorreoElectronico");
		String telefono = (String) userRow.get("Telefono");

		return new Usuarios(usuariob, password, telefono);
	}

}
