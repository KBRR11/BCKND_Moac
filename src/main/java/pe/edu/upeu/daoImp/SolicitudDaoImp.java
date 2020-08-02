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
import pe.edu.upeu.dao.SolicitudDao;
import pe.edu.upeu.entity.Solicitud;

@Repository
public class SolicitudDaoImp implements SolicitudDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Solicitud o) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_SOLICITUDES.PR_CREAR_SOLICITUD(?,?,?,?)",o.getIdusuario(),o.getIdconvocatoria(),o.getIdconvenio(),o.getTipo());
	}

	@Override
	public Map<String, Object> read(int idsolicitud) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_SOLICITUD").withCatalogName("PKG_CRUD_SOLICITUDES")
				.declareParameters(new SqlOutParameter("SOLICITUDES",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDREQUISITOS", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDSOLICITUD", idsolicitud);
		return  simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_SOLICITUDES")
				.withCatalogName("PKG_CRUD_SOLICITUDES")
				.declareParameters(new SqlOutParameter("LIST_REQUISITO", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	

}
