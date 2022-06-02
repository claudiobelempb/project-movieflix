package br.com.surb.surb.shared.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class AppResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {

  private final Environment environment;
  private final JwtTokenStore tokenStore;

  public AppResourceServerConfigurerAdapter(Environment environment, JwtTokenStore tokenStore){
    this.environment = environment;
    this.tokenStore = tokenStore;
  }

  private static final String[] PERMISSION_PUBLIC = {
    "oauth/token",
    "/h2-console/**",
  };

  private static final String[] PERMISSION_GET = {
    "/api/products/**",
    "/api/categories/**",
    "/api/movies/**",
    "/api/scores/**",
    "/api/departments/**",
    "/api/employees/**",
    "/api/roles/**",
  };

  private static final String[] PERMISSION_POST = {
    "/api/products",
    "/api/categories",
    "/api/movies/**",
    "/api/scores/**",
    "/api/departments/**",
    "/api/employees/**",
    "/api/roles/**",
  };

  private static final String[] PERMISSION_PUT = {
    "/api/products/**",
    "/api/categories/**",
    "/api/movies/**",
    "/api/scores/**",
    "/api/departments/**",
    "/api/employees/**",
    "/api/roles/**",
  };

  private static final String[] PERMISSION_DELETE = {
    "/api/products/**",
    "/api/categories/**",
    "/api/movies/**",
    "/api/scores/**",
    "/api/departments/**",
    "/api/employees/**",
    "/api/roles/**",
  };

  private static final String[] PERMISSION_PATCH = {
    "/api/products/status/**",
    "/api/categories/status/**",
    "/api/movies/status/**",
    "/api/scores/status/**",
    "/api/departments/status/**",
    "/api/employees/status/**",
    "/api/roles/status/**",
  };

  private static final String[] USER_OR_ADMIN = {
    "/api/user/notifications"
  };

  private static final String[] PERMISSION_ADMIN = {
    "/api/users/**",
    "/api/notifications"
  };

//  private static final String[] ADMIN = {
//    "/api/users/notifications",
//    "/api/users/status"
//  };

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.tokenStore(tokenStore);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {

    // H2
    if(Arrays.asList(environment.getActiveProfiles()).contains("test")){
      http.headers().frameOptions().disable();
    }
    //"OPERATOR", "STUDENT", "INSTRUCTOR",
    http.authorizeRequests()
      .antMatchers(PERMISSION_PUBLIC).permitAll()
//      .antMatchers(HttpMethod.GET, USER_OR_ADMIN).permitAll()
//      .antMatchers(OPERATOR_OR_ADMIN).hasAnyRole("OPERATOR", "ADMIN")
      .antMatchers(HttpMethod.GET, PERMISSION_GET).permitAll()
      .antMatchers(HttpMethod.POST, PERMISSION_POST).hasAnyRole("ADMIN")
      .antMatchers(HttpMethod.PUT, PERMISSION_PUT).hasAnyRole("ADMIN")
      .antMatchers(HttpMethod.DELETE, PERMISSION_DELETE).hasAnyRole("ADMIN")
      .antMatchers(HttpMethod.PATCH, PERMISSION_PATCH).hasAnyRole("ADMIN")
      .antMatchers(PERMISSION_ADMIN).hasRole("ADMIN")
//      .anyRequest().hasAnyRole("ADMIN")
      .anyRequest().authenticated();

    http.cors().configurationSource(corsConfigurationSource());

  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.setAllowedOriginPatterns(Arrays.asList("*"));
    corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH"));
    corsConfig.setAllowCredentials(true);
    corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);
    return source;
  }

  @Bean
  public FilterRegistrationBean<CorsFilter> corsFilter() {
    FilterRegistrationBean<CorsFilter> bean
      = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return bean;
  }
}
