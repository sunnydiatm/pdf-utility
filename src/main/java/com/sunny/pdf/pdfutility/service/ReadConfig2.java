package com.sunny.pdf.pdfutility.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@ConfigurationProperties("channels2")
public class ReadConfig2 {

    @JsonProperty("channels2")
    private List<String> channels2 = new ArrayList<>();

    @JsonProperty("channels2.AFS-IB")
    List<String> channelMap;

    @Value("${test.testing}")
    private String testValue;

    public List<String> getChannels() {
       return channels2;
   }

  /*public List<String> getChannelMap() {
        return channelMap;
   }*/

     @PostConstruct
     public void mapping() {
        System.out.printf("channels2 => " + channels2);
        System.out.printf("channels2Map => " + channelMap);
         System.out.printf("testValue => " + testValue);
    }
}
