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
import pe.edu.upeu.dao.ConveniosDao;
import pe.edu.upeu.entity.Convenios;

@Repository
public class ConveniosDaoImp implements ConveniosDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Convenios c) {
		return jdbcTemplate.update("call PKG_CRUD_CONVENIOS.PR_CREAR_CONVENIOS(?,?,?,?)",c.getNom_c_ep(),c.getEstado(),c.getIduniversidad(),c.getInformacion());
	}
	@Override
	public int update(Convenios c) {
		System.out.println(c.toString());
		return jdbcTemplate.update("call PKG_CRUD_CONVENIOS.PR_ACTUALIZAR_CONVENIOS(?,?,?,?,?)",c.getNom_c_ep(),c.getEstado(),c.getIduniversidad(),c.getInformacion(),c.getIdconvenio());
	}
	@Override
	public int delete(int idc) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_CONVENIOS.PR_ELIMINAR_CONVENIOS(?)",idc);
	}
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_CONVENIOS").withCatalogName("PKG_CRUD_CONVENIOS")
				.declareParameters(new SqlOutParameter("CONVENIOS",OracleTypes.CURSOR,new ColumnMapRowMapper()), new SqlParameter("P_IDCONVENIO", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDCONVENIO", id);
		return  simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_CONVENIOS")
				.withCatalogName("PKG_CRUD_CONVENIOS")
				.declareParameters(new SqlOutParameter("LIST_CONVENIOS", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	@Override
	public Map<String, Object> validador(int idconvenio, int idusuarui) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_VALIDAR").withCatalogName("PKG_CRUD_CONVENIOS")
				.declareParameters(new SqlOutParameter("RESPUESTA",OracleTypes.VARCHAR),
						new SqlParameter("P_IDCONVENIO", Types.INTEGER),
						new SqlParameter("P_IDUSUARIO", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDCONVENIO", idconvenio)
														   .addValue("P_IDUSUARIO", idusuarui);
		return  simpleJdbcCall.execute(in);
	}
}
