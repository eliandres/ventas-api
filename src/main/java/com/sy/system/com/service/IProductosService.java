package com.sy.system.com.service;

import java.util.List;

import com.sy.system.com.models.Producto;

public interface IProductosService {
	
	public List<Producto> lista();
	public int guardar(Producto producto);
	public int actualizar(Producto producto);
	public int eliminar(int id);
}
