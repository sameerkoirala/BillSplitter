//package com.test.BillSpliter.controller;
//
//import com.test.BillSpliter.beans.OcrModel;
//import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springframework.web.servlet.view.RedirectView;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Controller
//public class FileUploadController {
//
//    public static File convert(MultipartFile file) throws IOException {
//        File convFile = new File(file.getOriginalFilename());
//        convFile.createNewFile();
//        FileOutputStream fos = new FileOutputStream(convFile);
//        fos.write(file.getBytes());
//        fos.close();
//        return convFile;
//    }
//
//    @GetMapping("/p")
//    public String index() {
//        return "image";
//    }
//
////    @PostMapping("/upload")
////    public RedirectView singleFileUpload(@RequestParam("file") MultipartFile file,
////                                         RedirectAttributes redirectAttributes, Model model) throws IOException, TesseractException {
////
////        byte[] bytes = file.getBytes();
////        Path path = Paths.get("//Users//diwakar//Desktop//" + file.getOriginalFilename());
////        Files.write(path, bytes);
////
////        File convFile = convert(file);
////        Tesseract tesseract = new Tesseract();
////        tesseract.setDatapath("E://DataScience//tessdata");
////        String text = tesseract.doOCR(convFile);
////        redirectAttributes.addFlashAttribute("file", file);
////        redirectAttributes.addFlashAttribute("text", text);
////        return new RedirectView("result");
////    }
//    @PostMapping("/upload")
//    public String upload(@RequestParam("file") MultipartFile image) throws IOException {
//
//        String destinationLanguage = "Nationality Prefix {ENG}";
//        OcrModel request = new OcrModel();
//        request.setDestinationLanguage(destinationLanguage);
//        request.setImage(image);
//
//        ITesseract instance = new Tesseract();
//
//        try {
//
//            BufferedImage in = ImageIO.read(convert(image));
//
//            BufferedImage newImage = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_ARGB);
//
//            Graphics2D g = newImage.createGraphics();
//            g.drawImage(in, 0, 0, null);
//            g.dispose();
//
//            instance.setLanguage(request.getDestinationLanguage());
//            instance.setDatapath("..//tessdata");
//
//            String result = instance.doOCR(newImage);
//
//            return result;
//
//        } catch (TesseractException | IOException e) {
//            System.err.println(e.getMessage());
//            return "Error while reading image";
//        }
//
//    }
//    @RequestMapping("/result")
//    public String result() {
//        return "result";
//    }
//}
