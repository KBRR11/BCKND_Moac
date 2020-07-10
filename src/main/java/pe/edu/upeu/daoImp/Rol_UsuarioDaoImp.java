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
import pe.edu.upeu.dao.Rol_UsuarioDao;
import pe.edu.upeu.entity.Rol_Usuario;

@Repository
public class Rol_UsuarioDaoImp implements Rol_UsuarioDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Rol_Usuario ru) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_ROL_USUARIOS.PR_CREAR_ROL_USUARIO(?,?)", 
				ru.getIdusuario(), ru.getIdrol());
	}

	@Override
	public int update(Rol_Usuario ru) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_ROL_USUARIOS.PR_ACTUALIZAR_ROL_USUARIO(?,?)", 
				ru.getIdrol_us(), ru.getIdrol());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_ROL_USUARIOS.PR_ELIMINAR_ROL_USUARIO (?)", id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_CRUD_ROL_USUARIOS")
				.withProcedureName("PR_BUSCAR_ROL_USUARIO")
				.declareParameters(new SqlOutParameter("ROL_USUARIO", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("P_IDUSUARIO", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDUSUARIO", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_LISTAR_ROL_USUARIO")
				.withCatalogName("PKG_CRUD_ROL_USUARIOS")
				.declareParameters(new SqlOutParameter("LIST_ROL_USUARIO", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

}
