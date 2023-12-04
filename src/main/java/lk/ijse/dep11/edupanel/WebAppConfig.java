package lk.ijse.dep11.edupanel;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.io.InputStream;

@ComponentScan
@EnableWebMvc
@Configuration
public class WebAppConfig {

    @Bean
    public Bucket defaultBucket() throws IOException {
        InputStream serviceAccount =getClass().getResourceAsStream("/edupanel-1342f-firebase-adminsdk-vmjen-8c3c72ac41.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("edupanel-1342f.appspot.com")
                .build();

        FirebaseApp.initializeApp(options);
        return StorageClient.getInstance().bucket();

    }

    @Bean //new
    public StandardServletMultipartResolver multipartResolver(){   //spring boot wldi danna oni na //spring wldi danna oni
        return new StandardServletMultipartResolver();   ///meka dnmoth thma TO Object ekkt convert kr gnn plwn wenne
    }

//    @Bean //legacy
//    public CommonsMultipartResolver multipartResolver(){
//        return new CommonsMultipartResolver();
//    }
}
