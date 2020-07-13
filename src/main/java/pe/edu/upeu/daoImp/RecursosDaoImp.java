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
import pe.edu.upeu.dao.RecurosoDao;
import pe.edu.upeu.entity.Recursos;

@Repository
public class RecursosDaoImp implements RecurosoDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Recursos rec) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_REQUISITOS.PR_CREAR_REQUISITOS(?,?)");
	}

	@Override
	public int update(Recursos rec) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_REQUISITOS.PR_ACTUALIZAR_REQUISITOS(?,?,?)");
	}

	@Override
	public int delete(int idreq) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_REQUISITOS.PR_ELIMINAR_REQUISITOS(?)",idreq);
	}

	@Override
	public Map<String, Object> read(int idreq) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_REQUISITOS ").withCatalogName("PKG_CRUD_REQUISITOS")
				.declareParameters(new SqlOutParameter("REQUISITO",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDREQUISITOS", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDREQUISITOS", idreq);
		return  simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_REQUISITOS")
				.withCatalogName("PKG_CRUD_REQUISITOS")
				.declareParameters(new SqlOutParameter("LIST_REQUISITO", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
}
