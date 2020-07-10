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
import pe.edu.upeu.dao.UniversidadDao;
import pe.edu.upeu.entity.Universidad;

@Repository
public class UniversidadDaoImp implements UniversidadDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Universidad uni) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_UNIVERSIDADES.PR_CREAR_UNIVERSIDADES(?,?)", 
				uni.getNom_universidad(), uni.getPais());
	}

	@Override
	public int update(Universidad uni) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_UNIVERSIDADES.PR_ACTUALIZAR_UNIVERSIDADES(?,?,?)", 
				uni.getNom_universidad(), uni.getPais(), uni.getIduniversidad());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_EP.PR_ELIMINAR_UNIVERSIDADES (?)", id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("PKG_CRUD_UNIVERSIDADES")
				.withProcedureName("PR_BUSCAR_UNIVERSIDADES")
				.declareParameters(new SqlOutParameter("UNIVERSIDAD", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("P_IDUNIVERSIDAD ", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDUNIVERSIDAD", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_LISTAR_UNIVERSIDADES")
				.withCatalogName("PKG_CRUD_UNIVERSIDADES")
				.declareParameters(new SqlOutParameter("LIST_UNIVERSIDADES", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

}
