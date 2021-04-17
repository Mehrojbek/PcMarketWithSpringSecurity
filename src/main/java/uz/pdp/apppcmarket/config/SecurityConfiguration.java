package uz.pdp.apppcmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("SUPER_ADMIN").authorities("READ","READ_ALL","DELETE","ADD","EDIT","TEAM")
                .and()
                .withUser("moderator").password(passwordEncoder().encode("moderator")).roles("MODERATOR").authorities("READ","READ_ALL","ADD","EDIT")
                .and()
                .withUser("operator").password(passwordEncoder().encode("operator")).roles("OPERATOR").authorities("READ","READ_ALL");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //FOR ANONIM CUSTOMER
                .antMatchers(HttpMethod.GET,"/api/product/**").permitAll()
                //FOR ORDER     ORDERGA OPERATOR VA MODERATOR HAM ISHLOV BERA OLISHI UCHUN
                .antMatchers("/api/order/**").hasAuthority("READ")
                //FOR TEAM
                .antMatchers("/api/team/**").hasAuthority("TEAM")
                //FOR ALL
                .antMatchers(HttpMethod.GET,"/api/**").hasAnyAuthority("READ","READ_ALL")
                .antMatchers(HttpMethod.DELETE,"/api/**").hasAuthority("DELETE")
                .antMatchers(HttpMethod.PUT,"/api/**").hasAuthority("EDIT")
                .antMatchers(HttpMethod.POST,"/api/**").hasAuthority("ADD")

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}


//SAYTGA TASHRIF BUYURGAN ANONIM MIJOZ UCHUN
//                .antMatchers(HttpMethod.GET,"/api/product/**").permitAll()
//FOR ORDER
//                .antMatchers("/api/order/**").hasAnyRole("SUPER_ADMIN","MODERATOR","OPERATOR")
//FOR PARTNER
//                .antMatchers("/api/partner/**").hasAnyRole("SUPER_ADMIN","MODERATOR")
//FOR TEAM
//                .antMatchers("/api/team/**").hasRole("SUPER_ADMIN")
//FOR ALL

//                .antMatchers(HttpMethod.GET,"/api/**").hasAnyAuthority("READ","READ_ALL")
//                .antMatchers(HttpMethod.DELETE,"/api/**").hasAuthority("DELETE")
//                .antMatchers(HttpMethod.PUT,"/api/**").hasAnyRole("SUPER_ADMIN","MODERATOR")