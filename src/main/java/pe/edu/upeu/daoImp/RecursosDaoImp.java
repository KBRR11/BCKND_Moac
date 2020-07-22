package pe.edu.upeu.daoImp;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
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
import pe.edu.upeu.dao.RecursosDao;
import pe.edu.upeu.entity.Recursos;

@Repository
public class RecursosDaoImp implements RecursosDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Recursos rec) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_RECURSOS.PR_CREAR_RECURSOS(?,?,?,?)", rec.getTipo(),
				rec.getNom_recurso(), rec.getRuta(), rec.getIdcambio());
	}

	@Override
	public int update(Recursos rec) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_RECURSOS.PR_ACTUALIZAR_RECURSOS(?,?,?,?,?)", rec.getTipo(),
				rec.getNom_recurso(), rec.getIdrecurso(), rec.getIdcambio(), rec.getRuta());
	}

	@Override
	public int delete(int idreq) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_RECURSOS.PR_ELIMINAR_REQUISITOS(?)",idreq);
	}
	
	@Override
	public Recursos read(int id, int tipo) {
		// TODO Auto-generated method stub
		Recursos re = new Recursos();
		List<Recursos> gi = new ArrayList<Recursos>();
		
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_BUSCAR_TIPO").withCatalogName("PKG_CRUD_RECURSOS")
				.declareParameters(new SqlOutParameter("RECURSO",OracleTypes.CURSOR,new ColumnMapRowMapper()), 
						new SqlParameter("P_IDCAMBIO", Types.INTEGER),
						new SqlParameter("P_TIPO", Types.INTEGER)); 
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDCAMBIO", id)
															.addValue("P_TIPO", tipo);
		System.out.println(simpleJdbcCall.execute(in));
		System.out.println(((List)((simpleJdbcCall.execute(in)).get("RECURSO"))).get(0));
		gi = (((List)((simpleJdbcCall.execute(in)).get("RECURSO"))));
		System.out.println(gi);	
		//////////System.out.println(gi.get(0).getNom_recurso());
		re.setNom_recurso("4f7d58a5-cf1a-4ae7-8b13-efa38c7beef5_cu_art.PNG");  
		
		return  re;
		
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_REQUISITOS")
				.withCatalogName("PKG_CRUD_REQUISITOS")
				.declareParameters(new SqlOutParameter("LIST_REQUISITO", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	
	@Override
	public Recursos rec_listarid(int idr) {
		// TODO Auto-generated method stub
		String sql = "SELECT idrecurso,nom_recurso,ruta,tipo, DECODE(tipo,1,idconvocatoria , 2,idconvienio ,3,iduniversidad) idcambio \r\n" + 
				"FROM RECURSOS WHERE idrecurso=?";
		
		Recursos recu = new Recursos();
		recu=jdbcTemplate.queryForObject(sql, new Object[]{idr}, new BeanPropertyRowMapper<>(Recursos.class));
		recu.setIdrecurso(idr);
		System.out.println(" requisito "+idr);
		return recu;
	}

	@Override
	public Recursos listar1(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		String sql = "SELECT idrecurso,nom_recurso,ruta,tipo FROM RECURSOS WHERE IDCONVOCATORIA=?"; 
		
		Recursos recu = new Recursos();
		recu=jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Recursos.class));
		return recu;
	}

	@Override
	public Recursos listar2(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT idrecurso,nom_recurso,ruta,tipo FROM RECURSOS WHERE IDCONVENIO=?";
		
		
		Recursos recu = new Recursos();
		recu=jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Recursos.class));
		recu.toString();
		System.out.println(recu);
		return recu;
	}

	@Override
	public Recursos listar3(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT idrecurso,nom_recurso,ruta,tipo FROM RECURSOS WHERE IDUNIVERSIDAD=?";
		
		Recursos recu = new Recursos();
		recu=jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Recursos.class));
		return recu;
	}
	
	@Override
	public Recursos listar4(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT idrecurso,nom_recurso,ruta,tipo FROM RECURSOS WHERE IDREQUISITO=?";
		
		Recursos recu = new Recursos();
		recu=jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Recursos.class));
		return recu;
	}
	
	
	
}
