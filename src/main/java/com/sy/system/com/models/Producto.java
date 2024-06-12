package com.sy.system.com.models;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	@Id
	@Column(value = "idProducto")
	int idProducto;
	String codigoBara;
	String nombre;
	String marca;
	String categoria;
	float precios;
	boolean idEstadoRegistro;
	int idUsuarioCreacion;
	String fechaCreacion;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigoBara() {
		return codigoBara;
	}

	public void setCodigoBara(String codigoBara) {
		this.codigoBara = codigoBara;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public float getPrecios() {
		return precios;
	}

	public void setPrecios(float precios) {
		this.precios = precios;
	}

	public boolean isIdEstadoRegistro() {
		return idEstadoRegistro;
	}

	public void setIdEstadoRegistro(boolean idEstadoRegistro) {
		this.idEstadoRegistro = idEstadoRegistro;
	}

	public int getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}

	public void setIdUsuarioCreacion(int idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
