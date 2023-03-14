package com.multi.news.config.oauth;



import com.multi.news.services.CustomOauth2UserService;
import com.multi.news.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final CustomOauth2UserService customOauth2UserService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/css/**","/images/**","/js/**")
                .permitAll()
                .antMatchers("api/v1/comment/**")
                .hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOauth2UserService);
        return http.build();
    }
}