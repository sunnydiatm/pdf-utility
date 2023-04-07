package com.sunny.pdf.pdfutility.service;

import com.sunny.pdf.pdfutility.repository.PdfUtilityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
public class PdfUtilityService {

    @Autowired
    PdfUtilityRepository repository;

    public long mergePdf(List<MultipartFile> files) {
        log.info("PdfUtilityService::message received for mergePdf => " + files);
        return repository.mergePdf(files);
    }
}
