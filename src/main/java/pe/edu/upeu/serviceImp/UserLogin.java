package pe.edu.upeu.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upeu.dao.RolesDao;
import pe.edu.upeu.dao.UsuariosDao;
import pe.edu.upeu.entity.Usuarios;



@Service("userService")
public class UserLogin implements UserDetailsService {
	@Autowired
	private UsuariosDao usuarioDao;
	@Autowired
	private RolesDao rolDao;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios user = usuarioDao.validarUsuario(username);
		UserDetails details = new User(user.getUsuario(),user.getPassword(),rolDao.readAllid(user.getIdusuario()));
		return details;
	}
}
