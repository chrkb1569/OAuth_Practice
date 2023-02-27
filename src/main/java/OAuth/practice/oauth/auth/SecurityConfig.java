package OAuth.practice.oauth.auth;

import OAuth.practice.oauth.service.OAuth2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final OAuth2Service oAuth2Service;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .logout().disable()
                .formLogin().disable()

                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()

                .and()
                .oauth2Login()
                .defaultSuccessUrl("/oauth/loginInfo", true)
                .userInfoEndpoint()
                .userService(oAuth2Service)

                .and()
                .and().build();

    }
}
