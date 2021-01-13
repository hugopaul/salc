package br.mil.eb.basecmp.salc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
               // .antMatchers("/requisicoes/**").hasAnyRole("SALC","ADMIN", "SOLICITANTES")
              //  .antMatchers("/aprovacao/**").hasAnyRole("SALC", "ADMIN")
             //   .antMatchers("/empenho/**").hasAnyRole("SALC", "ADMIN")
              //  .antMatchers("/fornecedor/**").hasAnyRole("SALC", "ADMIN", "SOLICITANTES")
                .antMatchers("/usuarios/**").permitAll()
                .antMatchers("/requisicoes/**", "/aprovacao/**", "/empenho/**", "/fornecedor/**").authenticated()
                .anyRequest().denyAll();


    }
}
