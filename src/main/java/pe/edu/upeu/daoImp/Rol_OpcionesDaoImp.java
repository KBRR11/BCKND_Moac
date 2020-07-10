package pe.edu.upeu.daoImp;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import pe.edu.upeu.dao.Rol_OpcionesDao;
import pe.edu.upeu.entity.Rol_Opciones;

@Repository
public class Rol_OpcionesDaoImp implements Rol_OpcionesDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Rol_Opciones RO) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_ROL_OPCIONES.pr_crear_rol_opciones(?,?)",RO.getIdrol(),RO.getIdopcion());
	}

	@Override
	public int update(Rol_Opciones RO) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_ROL_OPCIONES.pr_actualizar_rol_opciones(?,?,?)",RO.getIdrol(),RO.getIdopcion(),RO.getIdrol_opcion());
	}

	@Override
	public int delete(int idRO) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_ROL_OPCIONES.pr_eliminar_rol_opciones(?)",idRO);
	}

	@Override
	public Map<String, Object> readByRol(int idorl) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("pr_buscarporrol_rol_opciones").withCatalogName("PKG_CRUD_ROL_OPCIONES")
				.declareParameters(new SqlOutParameter("list_rol_opciones",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("p_rol_opciones", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("p_rol_opciones", idorl);
		return  simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("pr_listar_rol_opciones")
				.withCatalogName("PKG_CRUD_ROL_OPCIONES")
				.declareParameters(new SqlOutParameter("list_rol_opciones", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

}
