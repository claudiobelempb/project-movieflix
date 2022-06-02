package br.com.surb.surb.shared.config;

import br.com.surb.surb.modules.user.useCases.AppUserDetailsService.AppUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

  private final BCryptPasswordEncoder passwordEncoder;
  private final AppUserDetailsService appUserDetailsService;
  private final Environment environment;

  public AppWebSecurityConfigurerAdapter(BCryptPasswordEncoder passwordEncoder, AppUserDetailsService appUserDetailsService,
                                         Environment environment){
    this.passwordEncoder = passwordEncoder;
    this.appUserDetailsService = appUserDetailsService;
    this.environment = environment;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
//    web.ignoring().antMatchers("/**");
    web.ignoring().antMatchers("/actuator/**");
  }

  @Override
  @Bean
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }


}
