package com.example.demo;

import com.example.demo.model.JsonReader;
import com.example.demo.model.Wineries;
import com.example.demo.service.WineriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@ServletComponentScan
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public CommandLineRunner run(WineriesService wineriesService) {
        return args -> {
            try {
                JsonReader jsonReader = new JsonReader();
                Resource resource = resourceLoader.getResource("classpath:wineries.json");
                try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
                    List<Wineries> wineries = jsonReader.readWineryData(reader);
                    wineriesService.saveWineriesData(wineries);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
