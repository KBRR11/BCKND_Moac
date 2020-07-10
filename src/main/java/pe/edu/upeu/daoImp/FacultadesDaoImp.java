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
import pe.edu.upeu.dao.FacultadesDao;
import pe.edu.upeu.entity.Facultades;

@Repository
public class FacultadesDaoImp implements FacultadesDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	
	@Override
	public int create(Facultades fac) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_FACULTADES.PR_CREAR_FACULTADES(?,?)",fac.getNom_facultad(),fac.getAcronimo());
	}

	@Override
	public int update(Facultades fac) {
		// TODO Auto-generated method stub
		System.out.println(fac.toString());
		return jdbcTemplate.update("call PKG_CRUD_FACULTADES.PR_ACTUALIZAR_FACULTADES(?,?,?)",fac.getNom_facultad(),fac.getAcronimo(),fac.getIdfacultad());
	}

	@Override
	public int delete(int idfac) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_FACULTADES.PR_ELIMINAR_FACULTADES(?)",idfac);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_FACULTADES").withCatalogName("PKG_CRUD_FACULTADES")
				.declareParameters(new SqlOutParameter("FACULTAD",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDFACULTAD", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDFACULTAD", id);
		return  simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_FACULTADES")
				.withCatalogName("PGK_CRUD_FACULTADES")
				.declareParameters(new SqlOutParameter("LIST_FACULTADES", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

}
