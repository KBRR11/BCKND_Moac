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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import pe.edu.upeu.dao.EscuelasProfesionalesDao;
import pe.edu.upeu.entity.EscuelasProfesionales;

@Repository
public class EscuelasProfesionasDaoImp implements EscuelasProfesionalesDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public int create(EscuelasProfesionales escuelas) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_EP.PR_CREAR_EP(?,?)", 
				escuelas.getNom_ep(), escuelas.getIdfacultad());
	}

	@Override
	public int update(EscuelasProfesionales escuelas) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_EP.PR_ACTUALIZAR_EP(?,?,?)", 
				escuelas.getIdep(), escuelas.getNom_ep(), escuelas.getIdfacultad());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_EP.PR_ELIMINAR_EP (?)", id);
	}
	
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_CRUD_EP")
				.withProcedureName("PR_BUSCAR_EP")
				.declareParameters(new SqlOutParameter("EP", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("P_IDEP ", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDEP", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_LISTAR_EP")
				.withCatalogName("PKG_CRUD_EP")
				.declareParameters(new SqlOutParameter("LIST_EP", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readEpForFAC(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_CRUD_EP")
				.withProcedureName("PR_BUSCAR_EP_IDFACULTAD")
				.declareParameters(new SqlOutParameter("EP", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("P_IDFACULTAD ", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDFACULTAD", id);
		return simpleJdbcCall.execute(in);
	}


}
