package com.test.BillSpliter.config;


import com.test.BillSpliter.Services.UserDetailsServices;
import com.test.BillSpliter.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServices userDetailServices;

    @Autowired
    AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/Login","/signup","/public/**","/css/*").permitAll()
                .antMatchers( "/registeruser").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/Login")
                .defaultSuccessUrl("/home",true)
                .permitAll().successHandler(authenticationSuccessHandler)
                .and()
                .logout()
                .logoutSuccessUrl("/Login")
                .permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       //auth.userDetailsService(userDetailServices);
        auth.authenticationProvider(authProvider());
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
       // return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailServices);
        authProvider.setPasswordEncoder(getPasswordEncoder());
        return authProvider;
    }
}
