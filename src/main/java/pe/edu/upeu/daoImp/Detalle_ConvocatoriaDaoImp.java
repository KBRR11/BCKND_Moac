package pe.edu.upeu.daoImp;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
import pe.edu.upeu.entity.Recursos;
import pe.edu.upeu.entity.Usuarios;

@Repository
public class Detalle_ConvocatoriaDaoImp implements Detalle_ConvocatoriaDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Detalle_Convocatoria detconv) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_DETALLE_CONVOCATORIA.PR_CREAR_DETALLE_CONVOCATORIA(?,?,?,?)",detconv.getIdconvocatoria(),detconv.getIdescuela(),detconv.getIdconvenio(),detconv.getN_vacantes());
	}

	@Override
	public int update(Detalle_Convocatoria detconv) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_DETALLE_CONVOCATORIA.PR_ACTUALIZAR_DETALLE_CONVOCATORIA(?,?,?,?,?)",detconv.getIdescuela(),detconv.getIdconvocatoria(),detconv.getIdconvenio(), detconv.getN_vacantes(), detconv.getIdetalle_convocatoria());
	}
	
	@Override
	public int delete(int iddetconv) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_DETALLE_CONVOCATORIA.PR_ELIMINAR_DETALLE_CONVOCATORIA(?)",iddetconv);
	}

	@Override
	public Map<String, Object> read(int idconv, int tipo, int idep) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_CONVOCATORIA_DETALLE_CONVOCATORIA").withCatalogName("PKG_CRUD_DETALLE_CONVOCATORIA")
				.declareParameters(new SqlOutParameter("FACULTAD",OracleTypes.CURSOR,new ColumnMapRowMapper())
						, new SqlParameter("P_IDCONVOCATORIA", Types.INTEGER)
						, new SqlParameter("P_TIPO", Types.INTEGER)
						, new SqlParameter("P_IDESCUELA", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDCONVOCATORIA", idconv)
												.addValue("P_TIPO", tipo)
												.addValue("P_IDESCUELA", idep); 
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

	@Override
	public int crear_escuela(Detalle_Convocatoria detconv) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_DETALLE_CONVOCATORIA.PR_CREAR_ESCUELA(?,?,?)",detconv.getIdescuela(),detconv.getIdconvocatoria(),detconv.getN_vacantes());
	}
	
	@Override
	public Usuarios listar_us(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		String sql = "SELECT idusuario, idep FROM usuarios WHERE IDUSUARIO=?"; 
		
		Usuarios us = new Usuarios();
		us=jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Usuarios.class));
		return us;
	}
	
	@Override
	public Map<String, Object> vervacante(int idc, int ide) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_VACANTES").withCatalogName("PKG_CRUD_DETALLE_CONVOCATORIA")
				.declareParameters(new SqlOutParameter("VACANTES",OracleTypes.INTEGER),
						new SqlParameter("P_IDCONVOCATORIA", Types.INTEGER),
						new SqlParameter("P_IDESCUELA", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDCONVOCATORIA", idc)
														   .addValue("P_IDESCUELA", ide);
		return simpleJdbcCall.execute(in);
	}
	@Override
	public int actualizar_vacante(int idc, int ide, int n_v) {
		return jdbcTemplate.update("call PKG_CRUD_DETALLE_CONVOCATORIA.PR_ACTULIZAR_VACANTES(?,?,?)",idc,ide,n_v);
	}

}
