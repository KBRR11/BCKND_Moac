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
import pe.edu.upeu.dao.ConvocatoriaDao;
import pe.edu.upeu.entity.Convocatoria;

@Repository
public class ConvocatoriaDaoImp implements ConvocatoriaDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Convocatoria conv) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_CONVOCATORIAS.PR_CREAR_CONVOCATORIAS(?,?,?,?)",conv.getNom_convocatoria(),conv.getInfo_convocatoria(),conv.getN_vancates(),conv.getCiclo_academico());
	}

	@Override
	public int update(Convocatoria conv) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_CONVOCATORIAS.PR_ACTUALIZAR_CONVOCATORIAS(?,?,?,?,?)",conv.getNom_convocatoria(),conv.getInfo_convocatoria(),conv.getN_vancates(),conv.getCiclo_academico(),conv.getIdconvocatoria());
	}

	@Override
	public int delete(int idconv) {
		// TODO Auto-generated method stub
		System.out.println(idconv);
		return jdbcTemplate.update("call PKG_CRUD_CONVOCATORIAS.PR_ELIMINAR_CONVOCATORIAS(?)",idconv);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_CONVOCATORIAS").withCatalogName("PKG_CRUD_CONVOCATORIAS")
				.declareParameters(new SqlOutParameter("CONVOCATORIA",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDCONVOCATORIA", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDCONVOCATORIA", id);
		return  simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_CONVOCATORIAS")
				.withCatalogName("PKG_CRUD_CONVOCATORIAS")
				.declareParameters(new SqlOutParameter("LIST_CONVOCATORIA", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

}
