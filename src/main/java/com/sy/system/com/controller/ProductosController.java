/*Desarrollador: Eli Briceño
 *Tema: Productos
 *Fecha: 2024-06-01
 *Ingeniero en sistema 
 */

package com.sy.system.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sy.system.com.service.IProductosService;
import com.sy.system.com.models.Producto;
import com.sy.system.com.models.ServiceResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/productos")
@CrossOrigin("*")
public class ProductosController {

	@Autowired
	private IProductosService iProductoService;

	@GetMapping("/lista")
	public ResponseEntity<List<Producto>> list() {
		var resultado = iProductoService.lista();
		return new ResponseEntity<>(resultado, HttpStatus.OK);
	}

	@PostMapping("/guardar")
	public ResponseEntity<ServiceResponse> guardar(@RequestBody Producto producto) {
		ServiceResponse serviceResponse = new ServiceResponse();
		int resultado = iProductoService.guardar(producto);
		// TODO: process POST request
		if (resultado == 1) {
			serviceResponse.setMessage("El registro fue guardado exitosamente!!!");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<ServiceResponse> actualizar(@RequestBody Producto producto) {
		ServiceResponse serviceResponse = new ServiceResponse();
		int resultado = iProductoService.actualizar(producto);
		// TODO: process POST request
		if (resultado == 1) {
			serviceResponse.setMessage("El registro fue actualizado exitosamente!!!");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}

	@PutMapping("/eliminar/{id}")
	public ResponseEntity<ServiceResponse> eliminar(@PathVariable int id) {
		// TODO: process PUT request
		ServiceResponse serviceResponse = new ServiceResponse();
		int resultado = iProductoService.eliminar(id);
		if (resultado == 1) {
			serviceResponse.setMessage("El registro fue eliminado exitosamente!!!");
		}
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
}
