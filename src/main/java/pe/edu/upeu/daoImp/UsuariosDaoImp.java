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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import oracle.jdbc.OracleTypes;
import pe.edu.upeu.dao.UsuariosDao;
import pe.edu.upeu.entity.Recursos;
import pe.edu.upeu.entity.Usuarios;

@Repository
public class UsuariosDaoImp implements UsuariosDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create_estudiante(Usuarios users) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_CREAR_POST_ESTUDIANTE(?,?,?,?,?,?,?)",
			users.getCodigo(),users.getUsuario(),new BCryptPasswordEncoder().encode((users.getPassword())),users.getSede(),
			users.getIdep(), users.getCiclo(),users.getN_documento());
	}

	@Override
	public int create_docente(Usuarios users) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_CREAR_POST_DOCENTE(?,?,?,?,?,?)",
				users.getCodigo(),users.getUsuario(),new BCryptPasswordEncoder().encode((users.getPassword())),users.getSede(),
				users.getIdep(), users.getN_documento());
	}

	@Override
	public int create_user_especial(Usuarios users) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_CREAR_USER_ESPECIAL(?,?,?,?,?,?,?,?)",
				users.getCodigo(),users.getUsuario(),new BCryptPasswordEncoder().encode((users.getPassword())),users.getSede(),
				users.getTipo(),users.getIdep(), users.getN_documento(),users.getN_documento());
	}

	@Override
	public Map<String, Object> readAll_Active() {////// LISTA TODOS LOS ACTIVOS ESTUDIANTES y DOCENTES
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_USUARIOS_ACTIVOS")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("P_CURSOR", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAll_Pending_Est() {////////////// LISTAR USUARIOS ESTUDIANTES PENDIENTES
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_USUARIOS_PENDIENTES_EST")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("P_CURSOR_EST_PEN", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	
	@Override
	public Map<String, Object> readAll_Pending_Doc() {////////////// LISTAR USUARIOS DOCENTES PENDIENTES
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_USUARIOS_PENDIENTES_DOC")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("P_CURSOR_DOC_PEN", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAll_Students() {////////////// LISTAR USUARIOS ESTUDIANTES ACTIVOS
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_USUARIOS_ESTUDIANTES")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("P_CURSOR_EST_ACT", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAll_Teachers() {///////////// LISTAR USUARIOS DOCENTES ACTIVOS
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_USUARIOS_DOCENTES")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("P_CURSOR_DOC_ACT", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public int update_nomUser(Usuarios usuario) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_ACTUALIZAR_USUARIO(?,?)", usuario.getIdusuario(),
				usuario.getUsuario());
	}

	@Override
	public int update_password(Usuarios password) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_ACTUALIZAR_PASSWORD(?,?)", password.getIdusuario(),
			new BCryptPasswordEncoder().encode(password.getPassword()));
	}

	@Override
	public int update_sede(Usuarios sede) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_ACTUALIZAR_SEDE(?,?)", sede.getIdusuario(),
				sede.getSede());
	}
	
	@Override
	public int update_ciclo(Usuarios ciclo) {
		// TODO Auto-generated method stub
				return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_ACTUALIZAR_CICLO(?,?)", ciclo.getIdusuario(),
						ciclo.getCiclo());
	}

	@Override
	public int desactivar_user(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_DESACTIVAR_USUARIO(?)", id);
	}

	@Override
	public int activar_user(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_ACTIVAR_USUARIO(?)",id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_ELIMINAR_USUARIOS(?)",id);
	}


	@Override
	public Map<String, Object> contadorUsers_Active() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_CONTADOR_USUARIOS_ACTIVOS")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("P_CURSOR", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> contadorUsers_Pending() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_CONTADOR_USUARIOS_PENDIENTES")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("P_CURSOR", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public int update_colores(Usuarios colores) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_ACTUALIZAR_COLOR(?,?,?)",
				colores.getIdusuario(),colores.getColor_fondo(),colores.getColor_menu());
	}
	
	@Override
	public Map<String, Object> contadorEstudents_Active() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_CONTADOR_ESTUDENTS_ACTIVOS")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("P_CURSOR_EST_ACT", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	
	@Override
	public Map<String, Object> contadorTeachers_Active() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_CONTADOR_TEACHERS_ACTIVOS")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("P_CURSOR_TEACH_ACT", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	
	@Override
	public Map<String, Object> contadorEstudents_Pending() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_CONTADOR_ESTUDENTS_PENDIENTES")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("P_CURSOR_EST_PEN", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	
	@Override
	public Map<String, Object> contadorTeachers_Pending() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_CONTADOR_TEACHERS_PENDIENTES")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("P_CURSOR_TEACH_PEN", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios validarUsuario(String username) { /////////// VALIDACION PARA QUE SOLO SE LOGUEEN USUARIOS CON ESTADO ACTIVO
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM USUARIOS WHERE USUARIO = ? and estado=1";
		Usuarios user = new Usuarios();
		user = (Usuarios)jdbcTemplate.queryForObject(SQL, new Object[]{username}, BeanPropertyRowMapper.newInstance(Usuarios.class));
		return user;
	}

	@Override
	public Map<String, Object> datosUsuario(String username) {///////////// JAMAS TOCAR -- SIRVE PARA LOGIN
		// TODO Auto-generated method stub
		String SQL = "SELECT p.idpersona , u.idusuario, u.usuario, p.nombres , p.apellidos , r.detalle as rol, r.nombre as nom_rol ,cu.color_fondo, cu.color_menu \r\n" + 
				"FROM personas p, usuarios u , roles r, rol_usuarios ru , config_usuario cu where p.idpersona = u. idpersona and r.idrol=ru.idrol and u.idusuario=ru.idusuario and u.idusuario=cu.idusuario and u.usuario = ?";
		Map<String, Object> map= jdbcTemplate.queryForMap(SQL, username);
		
		return map;
	}

	@Override
	public int create_user(Usuarios users) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_CREAR_USER(?,?,?,?,?,?,?,?,?)",
				users.getCodigo(),users.getUsuario(),new BCryptPasswordEncoder().encode((users.getPassword())),users.getSede(),
				users.getTipo(),users.getIdep(), users.getCiclo(), users.getIdrol(), users.getN_documento());
	}

	@Override
	public int update_user(Usuarios users) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call PKG_CRUD_USUARIOS.PR_MODIFICAR_USER(?,?,?,?,?,?,?,?,?)",
				users.getIdusuario(),users.getCodigo(),users.getUsuario(),new BCryptPasswordEncoder().encode((users.getPassword())),users.getSede(),
				users.getTipo(),users.getIdep(), users.getCiclo(), users.getIdrol());
	}

	@Override
	public Map<String, Object> listarTodo() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PR_LISTAR_USER")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("LIST_USER", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> listar(int id) {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_LISTAR_USER_COMPLETO")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("LIST_USER", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("P_IDUSUARIO", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDUSUARIO", id);
		return simpleJdbcCall.execute(in);
	}
	@Override
	public Usuarios listar_foto(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT idusuario,usuario,sede,foto FROM USUARIOS WHERE IDUSUARIO=?";
		
		Usuarios us = new Usuarios();
		us=jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Usuarios.class));
		us.toString();
		System.out.println(us);
		return us;
	}

	@Override
	public Map<String, Object> listar_datosPersona(int id) {//////// NO TOCAR --- KENY
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_LISTAR_USER_ID")
				.withCatalogName("PKG_CRUD_USUARIOS")
				.declareParameters(new SqlOutParameter("LIST_USER", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("P_IDUSUARIO", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("P_IDUSUARIO", id);
		return simpleJdbcCall.execute(in);
	}

}
