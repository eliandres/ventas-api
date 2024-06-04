package com.sy.system.com.repository;
import java.util.List;
import  com.sy.system.com.models.Producto;

public interface IProductosRepository {

	public List<Producto> lista();
	public int guardar(Producto producto);
	public int actualizar(Producto producto);
	public int eliminar(int Id);
	
}
