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

import pe.edu.upeu.dao.OpcionDao;
import pe.edu.upeu.entity.Opcion;

import oracle.jdbc.OracleTypes;

@Repository
public class OpcionDaoImp implements OpcionDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Opcion o) {
		// TODO Auto-generated method stub
		System.out.println(o.toString());
		return jdbcTemplate.update("call PKG_CRUD_OPCIONES.PR_CREAR_OPCIONES(?,?,?,?,null)",o.getNombre(),o.getDescripcion(),o.getEnlace(),o.getIcono());
	}

	@Override
	public int update(Opcion o) {
		// TODO Auto-generated method stub
		System.out.println(o.toString());
		return jdbcTemplate.update("call PKG_CRUD_OPCIONES.PR_ACTUALIZAR_OPCIONES(?,?,?,?,?)",o.getNombre(),o.getDescripcion(),o.getEnlace(),o.getIcono(),o.getEstado());
	}

	@Override
	public int delete(int o) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_OPCIONES.PR_ELIMINAR_OPCIONES(?)",o);
	}

	@Override
	public Map<String, Object> read(int idopcion) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_OPCIONES").withCatalogName("PKG_CRUD_OPCIONES")
				.declareParameters(new SqlOutParameter("OPCION",OracleTypes
						.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDOPCION",Types.INTEGER));
				SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDOPCION", idopcion);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_LISTAR_OPCIONES").withCatalogName("PKG_CRUD_OPCIONES")
				.declareParameters(new SqlOutParameter("LIST_OPCION", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

}
