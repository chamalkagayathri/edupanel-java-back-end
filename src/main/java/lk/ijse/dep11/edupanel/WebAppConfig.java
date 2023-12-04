package lk.ijse.dep11.edupanel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan
@EnableWebMvc
@Configuration
public class WebAppConfig {

    @Bean //new
    public StandardServletMultipartResolver multipartResolver(){   //spring boot wldi danna oni na //spring wldi danna oni
        return new StandardServletMultipartResolver();   ///meka dnmoth thma TO Object ekkt convert kr gnn plwn wenne
    }

//    @Bean //legacy
//    public CommonsMultipartResolver multipartResolver(){
//        return new CommonsMultipartResolver();
//    }
}
