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
import pe.edu.upeu.dao.PersonasDao;
import pe.edu.upeu.entity.Personas;

@Repository
public class PersonasDaoImp implements PersonasDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Personas per) {
		return jdbcTemplate.update("call PKG_CRUD_PERSONAS.PR_CREAR_PERSONAS(?,?,?,?,?,?,?)",
				per.getNombres(),per.getApellidos(),per.getT_documento(), per.getN_documento(), per.getCorreo(), per.getTelefono(),per.getDireccion());
	}
	@Override
	public int update(Personas per) {
		return jdbcTemplate.update("call PKG_CRUD_PERSONAS.PR_ACTUALIZAR_PERSONAS(?,?,?,?,?,?,?,?)",
				per.getIdpersona(),per.getNombres(),per.getApellidos(),per.getT_documento(), per.getN_documento(), per.getCorreo(), per.getTelefono(),per.getDireccion());
	}
	@Override
	public int delete(int id) {
		return jdbcTemplate.update("call PKG_CRUD_PERSONAS.PR_ELIMINAR_PERSONAS(?)",id);
	}
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_PERSONAS_ID").withCatalogName("PKG_CRUD_PERSONAS")
				.declareParameters(new SqlOutParameter("P_CUR_PERSONAS",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDPERSONA", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDPERSONA", id);
		return  simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_PERSONAS")
				.withCatalogName("PKG_CRUD_personas")
				.declareParameters(new SqlOutParameter("P_CURSOR", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	@Override
	public Map<String, Object> findDocumento(String documento) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_DOCUMENTO").withCatalogName("PKG_CRUD_PERSONAS")
				.declareParameters(new SqlOutParameter("P_CUR_PERSONAS",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_N_DOCUMENTO", Types.VARCHAR));
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_N_DOCUMENTO", documento);
		return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> findAPELLIDOS(String apellido) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_APELLIDO").withCatalogName("PKG_CRUD_PERSONAS")
				.declareParameters(new SqlOutParameter("P_CUR_PERSONAS",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_APELLIDOS", Types.VARCHAR));
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_APELLIDOS", apellido);
		return simpleJdbcCall.execute(in);
	}
}
