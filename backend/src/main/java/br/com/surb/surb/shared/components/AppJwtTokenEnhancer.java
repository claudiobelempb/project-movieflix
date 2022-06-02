package br.com.surb.surb.shared.components;

import br.com.surb.surb.modules.user.infra.jpa.entities.User;
import br.com.surb.surb.modules.user.infra.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AppJwtTokenEnhancer implements TokenEnhancer {

  @Autowired
  private UserRepository userRepository;

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
    User user = userRepository.findByEmail(authentication.getName());
    Map<String, Object> addInfoToken = new HashMap<>();
    addInfoToken.put("userFistName", user.getFirstName());
    addInfoToken.put("userId", user.getId());

    DefaultOAuth2AccessToken inforTokenUser = (DefaultOAuth2AccessToken) accessToken;
    inforTokenUser.setAdditionalInformation(addInfoToken);
    return accessToken;
  }
}
