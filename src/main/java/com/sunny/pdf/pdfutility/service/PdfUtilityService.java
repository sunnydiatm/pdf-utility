package com.sunny.pdf.pdfutility.service;

import com.sunny.pdf.pdfutility.repository.PdfUtilityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class PdfUtilityService {

    @Autowired
    PdfUtilityRepository repository;

    @Autowired
    ReadConfig config;

    @Autowired
    ReadConfig2 config2;

    public long mergePdf(List<MultipartFile> files) {
        log.info("PdfUtilityService::message received for mergePdf => " + files);
        return repository.mergePdf(files);
    }

    public Map<String, List<String>> hasMap() {
        log.info("hashMap::message received for hashMap => " );
        System.out.printf("config map::" + config.getChannels());
        return config.getChannels();
    }

    public List<String> hasMap2() {
        log.info("hashMap2::message received for hashMap2 => " );
        System.out.printf("config map2::" + config2.getChannels());
        return config2.getChannels();
    }
}
