package com.br.wifeed.conf;

import com.br.wifeed.Controller.MikrotikController;
import com.br.wifeed.Controller.UsuarioController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackageClasses ={MikrotikController.class, UsuarioController.class})
public class AppWebConfig {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/views");
        resolver.setSuffix(".html");

        return resolver;
    }
}
