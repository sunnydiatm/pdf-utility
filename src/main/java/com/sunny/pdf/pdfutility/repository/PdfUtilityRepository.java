package com.sunny.pdf.pdfutility.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Slf4j
@Repository
public class PdfUtilityRepository {

    public long mergePdf(List<MultipartFile> files) {
        log.info("PdfUtilityRepository::message received for mergePdf Files received of total size:" + files.size());
        return files.size();
    }
}
