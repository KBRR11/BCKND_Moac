package pe.edu.upeu.daoImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.dao.RolesDao;
import pe.edu.upeu.entity.Roles;
@Repository
public class RolesDaoImp implements RolesDao {
	@Autowired
	private JdbcTemplate JdbcTemplate;
	private SimpleJdbcCall SimpleJdbcCall;
	@Override
	public int create(Roles r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Roles r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> readN(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> readE(int estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrantedAuthority> readAllid(int idusuario) {
		// TODO Auto-generated method stub
		List<GrantedAuthority> autores = new ArrayList<>();
		String SQL = "select u.idusuario, r.idrol, r.nombre from roles r, usuarios u, rol_usuarios ru where ru.idrol=r.idrol and ru.idusuario= u.idusuario and u.idusuario=?";
		List<Roles> roles = JdbcTemplate.query(SQL, new Object[]{idusuario}, new BeanPropertyRowMapper<Roles>(Roles.class));		
		for(int i=0;i<roles.size();i++) {
			autores.add(new SimpleGrantedAuthority(roles.get(i).getNombre()));
		}
		return autores;
	}

}
