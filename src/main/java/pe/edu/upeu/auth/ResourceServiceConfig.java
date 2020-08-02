package pe.edu.upeu.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/personas/add").permitAll()
		.antMatchers(HttpMethod.POST, "/api/add_student").permitAll()
		.antMatchers(HttpMethod.POST, "/api/add_teacher").permitAll()
		.antMatchers(HttpMethod.GET, "/api/facultades").permitAll()
		.antMatchers(HttpMethod.GET, "/api/fac_ep/{id}").permitAll()
        .antMatchers(HttpMethod.GET, "/api/userfoto/{id}").permitAll()
        .antMatchers(HttpMethod.POST, "/upload/**").permitAll()
        .antMatchers(HttpMethod.POST, "/api/subirfoto").permitAll()
		.antMatchers(HttpMethod.GET, "/upload/**").permitAll()
		.antMatchers(HttpMethod.POST, "/api/requisito/create").permitAll()
		.antMatchers(HttpMethod.GET, "/api/solicitud_requisitos/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api/solicitud_requisitos/update").permitAll()
		.antMatchers(HttpMethod.GET, "/api/requisitoVer/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api/solicitud_requisitos/create").permitAll()
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
		
	}
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
