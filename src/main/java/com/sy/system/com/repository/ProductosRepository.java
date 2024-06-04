package com.sy.system.com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.sy.system.com.models.Producto;

@Repository
public class ProductosRepository implements IProductosRepository{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<Producto> lista() {
	    SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbc)
                .withProcedureName("ObtenerProductos")
                .returningResultSet("productos", new RowMapper<Producto>() {
                    @Override
                    public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Producto producto = new Producto();
                        producto.setIdProducto(rs.getInt("IdProducto"));
                        producto.setCodigoBara(rs.getString("CodigoBara"));
                        producto.setNombre(rs.getString("Nombre"));
                        producto.setMarca(rs.getString("Marca"));
                        producto.setCategoria(rs.getString("Categoria"));
                        producto.setPrecios(rs.getFloat("Precios"));
                       return producto;
                    }
                });
        
	    Map<String, Object> result = jdbcCall.execute();
        @SuppressWarnings("unchecked")
        List<Producto> productos = (List<Producto>) result.get("productos");
        return productos;
	}

	@Override
	public int guardar(Producto producto) {
	    SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbc)
                .withProcedureName("InsertarProductos");
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("codigoBara", producto.getCodigoBara());
        parametros.put("nombre", producto.getNombre());
        parametros.put("marca", producto.getMarca());
        parametros.put("categoria", producto.getCategoria());
        parametros.put("precios", producto.getPrecios());
        
        jdbcCall.execute(parametros);
        return 1; // Asume éxito
	}

	@Override
	public int eliminar(int id) {
		String sqlConsulta = "UPDATE Productos SET IdEstadoRegistro = 0 Where IdProducto = ?";
		return jdbc.update(sqlConsulta, new Object[] {id});		 
	}

	@Override
	public int actualizar(Producto producto) {
	    String sqlConsulta = "UPDATE Productos SET CodigoBara = ?, Nombre =?, Marca=?, Categoria=?, Precios=?"
	    		+ "WHERE IdProducto =? ";
	    return jdbc.update(sqlConsulta, new Object[] {
	        producto.getCodigoBara(),
	        producto.getNombre(),
	        producto.getMarca(),
	        producto.getCategoria(),
	        producto.getPrecios(),
	        producto.getIdProducto()
	    });
	}

}
