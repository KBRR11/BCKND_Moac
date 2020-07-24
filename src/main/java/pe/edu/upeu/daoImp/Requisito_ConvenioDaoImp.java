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
import pe.edu.upeu.dao.Requisito_ConvenioDao;
import pe.edu.upeu.entity.Requisito_Convenio;

@Repository
public class Requisito_ConvenioDaoImp implements Requisito_ConvenioDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Requisito_Convenio rc) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_REQUISITOCONVENIO.PR_CREAR_REQUISITOCONVENIO(?,?)",rc.getIdrequisito(),rc.getIdconvenio());
	}

	@Override
	public int update(Requisito_Convenio rc) { 
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_REQUISITOCONVENIO.PR_ACTUALIZAR_REQUISITOCONVENIO(?,?)",rc.getIdconvenio(),rc.getIdrequisito_convenio());
	}

	@Override
	public Map<String, Object> read(int idco, int idre) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_SEARCH_REQUISITOCONVENIO").withCatalogName("PKG_CRUD_REQUISITOCONVENIO")
				.declareParameters(new SqlOutParameter("REQ_CONVENIO",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDCONVENIO", Types.INTEGER),new SqlParameter("P_IDREQUISITO", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDCONVENIO", idco).addValue("P_IDREQUISITO", idre);
		return  simpleJdbcCall.execute(in);
	}

}
