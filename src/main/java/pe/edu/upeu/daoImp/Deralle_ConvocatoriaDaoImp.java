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
import pe.edu.upeu.dao.Detalle_ConvocatoriaDao;
import pe.edu.upeu.entity.Detalle_Convocatoria;

@Repository
public class Deralle_ConvocatoriaDaoImp implements Detalle_ConvocatoriaDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Detalle_Convocatoria detconv) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_DETALLE_CONVOCATORIA.PR_CREAR_DETALLE_CONVOCATORIA(?,?,?,?,?)",detconv.getHasta(),detconv.getIdconvocatoria(),detconv.getIdescuela(),detconv.getDesde(),detconv.getNombre());
	}

	@Override
	public int update(Detalle_Convocatoria detconv) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_DETALLE_CONVOCATORIA.PR_ACTUALIZAR_DETALLE_CONVOCATORIA(?,?,?,?,?,?)",detconv.getHasta(),detconv.getIdescuela(),detconv.getIdconvocatoria(),detconv.getIdetalle_convocatoria(),detconv.getDesde(),detconv.getNombre());
	}

	@Override
	public int delete(int iddetconv) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_DETALLE_CONVOCATORIA.PR_ELIMINAR_DETALLE_CONVOCATORIA(?)",iddetconv);
	}

	@Override
	public Map<String, Object> read(int idconv) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_CONVOCATORIA_DETALLE_CONVOCATORIA").withCatalogName("PKG_CRUD_DETALLE_CONVOCATORIA")
				.declareParameters(new SqlOutParameter("FACULTAD",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("p_IDCONVOCATORIA", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("p_IDCONVOCATORIA", idconv);
		return  simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAlumnoByIdconv(int idconv) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_ALUMNO_CONVOCATORIAS").withCatalogName("PKG_CRUD_DETALLE_CONVOCATORIA")
				.declareParameters(new SqlOutParameter("CONVOCATORIA",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDCONVOCATORIA", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDCONVOCATORIA", idconv);
		return  simpleJdbcCall.execute(in);
	}

}
