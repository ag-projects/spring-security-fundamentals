package com.agharibi.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * There are two steps to configure user authentication in spring security
 * 1) create an instance of AuthenticationManagerBuilder
 * 2) use the above instance to pass it to WebSecurityConfiguration.configure(..) method
 * 3) to accomplish the step above, a securityConfig bean should extend WebSecurityConfigurerAdapter
 *      so it can override the configure(AuthenticationManagerBuilder  builder)
 */
// web security configuration bean
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO set the authentication on the auth param
        auth.inMemoryAuthentication()
            .withUser("alex")
            .password("pass")
            .roles("USER")
            .and()
            .withUser("sara")
            .password("letmein")
            .roles("ADMIN");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
