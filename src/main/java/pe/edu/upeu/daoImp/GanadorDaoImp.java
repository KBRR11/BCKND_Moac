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
import pe.edu.upeu.dao.GanadorDao;
import pe.edu.upeu.entity.Ganador;

@Repository
public class GanadorDaoImp implements GanadorDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Ganador win) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_GANADORES.PR_CREAR_GANADORES(?,?)",
				win.getIdusuario(), win.getIddetalle_convocatoria());
	}

	@Override
	public int update(Ganador win) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_GANADORES.PR_ACTUALIZAR_GANADORES(?,?,?,?)", win.getIdganador(),
				win.getIdusuario(), win.getIddetalle_convocatoria(), win.getEstado());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_GANADORES.PR_ELIMINAR_GANADORES(?)",id);
	}

	@Override
	public Map<String, Object> read(int id_dc, int ide) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_GANADORES").withCatalogName("PKG_CRUD_GANADORES")
				.declareParameters(new SqlOutParameter("P_USUARIO ",OracleTypes.INTEGER,new ColumnMapRowMapper())
						, new SqlParameter("P_IDDETALLE", Types.INTEGER)
						, new SqlParameter("P_IDESCUELA", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDDETALLE", id_dc)
														   .addValue("P_IDESCUELA", ide);
		return  simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll(int id_dc) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_PERSONAS_ID").withCatalogName("PKG_CRUD_PERSONAS")
				.declareParameters(new SqlOutParameter("P_CUR_PERSONAS",OracleTypes.CURSOR,new ColumnMapRowMapper())
						, new SqlParameter("P_IDDETALLE", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDDETALLE", id_dc);
		return  simpleJdbcCall.execute(in);
	}

}
