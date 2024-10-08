package com.server.wordwaves.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Configuration
@Slf4j
public class FirebaseConfig {

    @Bean
    FirebaseApp firebaseApp() throws IOException {
        String firebaseCredentials = System.getenv("FIREBASE_CREDENTIALS");

        // Chuyển đổi chuỗi JSON thành InputStream
        ByteArrayInputStream credentialsStream = new ByteArrayInputStream(firebaseCredentials.getBytes());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(credentialsStream))
                .setStorageBucket("petgarden-bda48.appspot.com")
                .build();

        return FirebaseApp.initializeApp(options);

    }
}