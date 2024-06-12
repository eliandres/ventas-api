package com.sy.system.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.system.com.models.Producto;
import com.sy.system.com.repository.IProductosRepository;

@Service
public class ProductosService implements IProductosService {

	@Autowired
	private IProductosRepository iProductosRepository;

	@Override
	public List<Producto> lista() {
		List<Producto> list;
		try {
			list = iProductosRepository.lista();
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public int guardar(Producto producto) {
		int row;
		try {
			row = iProductosRepository.guardar(producto);
		} catch (Exception e) {
			throw e;
		}
		return row;
	}

	@Override
	public int actualizar(Producto producto) {
		int row;
		try {
			row = iProductosRepository.actualizar(producto);
		} catch (Exception e) {
			throw e;
		}
		return row;
	}

	@Override
	public int eliminar(int id) {
		int row;
		try {
			row = iProductosRepository.eliminar(id);
		} catch (Exception e) {
			throw e;
		}
		return row;
	}

}
