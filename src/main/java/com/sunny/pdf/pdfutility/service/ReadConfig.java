package com.sunny.pdf.pdfutility.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@ConfigurationProperties("try")
public class ReadConfig {

   private Map<String, List<String>> channels = new HashMap<>();

   public Map<String, List<String>> getChannels() {
       return channels;
   }

    @PostConstruct
    public void mapping() {
        System.out.printf("channels => " + channels);
    }
}
