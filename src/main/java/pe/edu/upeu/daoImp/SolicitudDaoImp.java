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
		System.out.println(o.toString());
		return jdbcTemplate.update("call PKG_CRUD_SOLICITUDES.PR_CREAR_SOLICITUD(?,?,?,?)",o.getIdusuario(),o.getIdconvocatoria(),o.getIdconvenio(),o.getTipo());
	}

	@Override
	public Map<String, Object> read(int idsolicitud) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_REQUISITO_SOLICITU").withCatalogName("PKG_CRUD_REQUISITO_SOLICITUD")
				.declareParameters(new SqlOutParameter("REQUISITOS",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("p_IDSOLICITUD", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("p_IDSOLICITUD", idsolicitud);
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

	@Override
	public Map<String, Object> readSolicitud_Convocatoria(int idsolicitud) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_SOLICITUD").withCatalogName("PKG_CRUD_SOLICITUDES")
				.declareParameters(new SqlOutParameter("SOLICITUD",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDUSUARIO", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDUSUARIO", idsolicitud);
		return  simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readConv(int idusuario) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_SOLICITUD_CONVOCATORIA").withCatalogName("PKG_CRUD_SOLICITUDES")
				.declareParameters(new SqlOutParameter("SOLICITUD",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDUSUARIO", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDUSUARIO", idusuario);
		return  simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readSolicitudDetalleCatoria(int idusuario, int idconvocatoria, int iduniversidaduser) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_DETCONV").withCatalogName("PKG_CRUD_SOLICITUDES")
				.declareParameters(new SqlOutParameter("SOLICITUD",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDUSUARIO", Types.INTEGER)
						,new SqlParameter("P_IDCONVOCATORIA", Types.INTEGER),new SqlParameter("P_IDUNIVERSIDAD", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDUSUARIO", idusuario).addValue("P_IDCONVOCATORIA", idconvocatoria).addValue("P_IDUNIVERSIDAD", iduniversidaduser);
		return  simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> read_ConvaActiva(int iduser) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_CONVACTIVAS").withCatalogName("PKG_CRUD_SOLICITUDES")
				.declareParameters(new SqlOutParameter("CONVOCATORIA",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_USUARIO", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_USUARIO", iduser);
		return  simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> listar_uni(int iduser) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_UNI").withCatalogName("PKG_CRUD_SOLICITUDES")
				.declareParameters(new SqlOutParameter("UNIVERSIDADES",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_USUARIO", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_USUARIO", iduser);
		return  simpleJdbcCall.execute(in);
	}

}
