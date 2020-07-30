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
import pe.edu.upeu.dao.Requisito_SolicitudDao;
import pe.edu.upeu.entity.Solicitud_Requisito;

@Repository
public class Solicitud_RequisitoDaoImp implements Requisito_SolicitudDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Solicitud_Requisito sr) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_REQUISITO_SOLICITUD.PR_CREAR_REQUISITO_SOLICITUD(?,?,?)",sr.getRuta(),sr.getIdsolicitud(),sr.getIdrequisito());
	}

	@Override
	public int delete(int idsr) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_REQUISITO_SOLICITUD.PR_ELIMINAR_REQUISITO_SOLICITU(?)",idsr);
	}

	@Override
	public Map<String, Object> read(int idconvenio,int iduser, int idconvo) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_REQUISITO_SOLICITU").withCatalogName("PKG_CRUD_REQUISITO_SOLICITUD")
				.declareParameters(new SqlOutParameter("REQUISITOS",OracleTypes.CURSOR,new ColumnMapRowMapper())
						, new SqlParameter("P_IDCONVENIO", Types.INTEGER),
						new SqlParameter("P_IDUSUARIO",Types.INTEGER), new SqlParameter("P_IDCONVOCATORIA",Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDCONVENIO", idconvenio)
				.addValue("P_IDUSUARIO", iduser).addValue("P_IDCONVOCATORIA", idconvo);
		return  simpleJdbcCall.execute(in);
	}

}
