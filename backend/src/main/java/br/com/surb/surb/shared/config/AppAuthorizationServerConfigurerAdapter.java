package br.com.surb.surb.shared.config;

import br.com.surb.surb.modules.user.useCases.AppUserDetailsService.AppUserDetailsService;
import br.com.surb.surb.shared.components.AppJwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AppAuthorizationServerConfigurerAdapter extends AuthorizationServerConfigurerAdapter {

  @Value("${security.oauth2.client.client-id}")
  private String clientId;

  @Value("${security.oauth2.client.client-secret}")
  private String clientSecret;

  @Value("${jwt.duration}")
  private Integer jwtDuration;

  private final BCryptPasswordEncoder passwordEncoder;
  private final JwtAccessTokenConverter accessTokenConverter;
  private final JwtTokenStore tokenStore;
  private final AuthenticationManager authenticationManager;
  private final AppJwtTokenEnhancer tokenEnhancer;

  private final AppUserDetailsService appUserDetailsService;

  public AppAuthorizationServerConfigurerAdapter(
    BCryptPasswordEncoder passwordEncoder,
    JwtAccessTokenConverter accessTokenConverter,
    JwtTokenStore tokenStore,
    AuthenticationManager authenticationManager,
    AppJwtTokenEnhancer tokenEnhancer,
    AppUserDetailsService appUserDetailsService
  ){
    this.passwordEncoder = passwordEncoder;
    this.accessTokenConverter = accessTokenConverter;
    this.tokenStore = tokenStore;
    this.authenticationManager = authenticationManager;
    this.tokenEnhancer = tokenEnhancer;
    this.appUserDetailsService = appUserDetailsService;
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.inMemory()
      .withClient(clientId)
      .secret(passwordEncoder.encode(clientSecret))
      .scopes("read", "write")
      .authorizedGrantTypes("password", "refresh_token")
      .accessTokenValiditySeconds(jwtDuration)
      .refreshTokenValiditySeconds(jwtDuration);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

    TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
    enhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter, tokenEnhancer));

    endpoints.authenticationManager(authenticationManager)
      .tokenStore(tokenStore)
      .accessTokenConverter(accessTokenConverter)
      .tokenEnhancer(enhancerChain)
      .userDetailsService(appUserDetailsService);
  }
}
