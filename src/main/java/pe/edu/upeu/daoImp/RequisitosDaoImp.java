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
import pe.edu.upeu.dao.RequisitosDao;
import pe.edu.upeu.entity.Requisitos;

@Repository
public class RequisitosDaoImp implements RequisitosDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Requisitos req) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_REQUISITOS.PR_CREAR_REQUISITOS(?)",req.getNombre());
	}

	@Override
	public int update(Requisitos req) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_REQUISITOS.PR_ACTUALIZAR_REQUISITOS(?,?)",req.getNombre(),req.getIdrequisito());
	}

	@Override
	public int delete(int idreq) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_REQUISITOS.PR_ELIMINAR_REQUISITOCONVENIO(?)",idreq);
	}

	@Override
	public Map<String, Object> read(int idreq) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_REQUISITOS").withCatalogName("PKG_CRUD_REQUISITOS")
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
	
	@Override
	public Map<String, Object> readConvenios(int idconve, int ide) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_REQCONVE").withCatalogName("PKG_CRUD_REQUISITOS")
				.declareParameters(new SqlOutParameter("REQCONVE",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDREQUICONV", Types.INTEGER),new SqlParameter("P_ESTADO", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDREQUICONV", idconve).addValue("P_ESTADO", ide);
		return  simpleJdbcCall.execute(in);
	}
	
	@Override
	public Map<String, Object> readConvenios2(int idconve, int ide) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_REQCONVE2").withCatalogName("PKG_CRUD_REQUISITOS")
				.declareParameters(new SqlOutParameter("REQCONVE",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDREQUICONV", Types.INTEGER),new SqlParameter("P_ESTADO", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDREQUICONV", idconve).addValue("P_ESTADO", ide);
		return  simpleJdbcCall.execute(in);
	}
}
