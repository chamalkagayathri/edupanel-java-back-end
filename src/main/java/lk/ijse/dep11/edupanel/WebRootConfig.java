package lk.ijse.dep11.edupanel;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/application.properties")
public class WebRootConfig {

    @Bean
    public HikariDataSource dataSource(Environment env){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(env.getRequiredProperty("spring.datasourse.url"));
        config.setUsername(env.getRequiredProperty("spring.datasourse.username"));
        config.setPassword(env.getRequiredProperty("spring.datasourse.password"));
        config.setDriverClassName(env.getRequiredProperty("spring.datasourse.driver-class-name"));
        config.setMaximumPoolSize(env.getRequiredProperty("spring.datasourse.hikari.maximum-pool-size", Integer.class));
        return new HikariDataSource(config);
    }
}
