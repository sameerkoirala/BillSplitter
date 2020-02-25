package com.test.BillSpliter.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import com.test.BillSpliter.Component.PdfGenerator;
import com.test.BillSpliter.Component.SplittingBills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


@Controller
public class FileDownloadController  {

    @Autowired
    private  SplittingBills splittingBills;

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> fiieDownload(HttpServletRequest request, HttpServletResponse response) {

        PdfGenerator pdfGenerator = new PdfGenerator();
        ByteArrayInputStream bis = pdfGenerator.writeToFile(splittingBills.getBillingDetailsList(),splittingBills.getSettlementList());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=settlement.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }


}

