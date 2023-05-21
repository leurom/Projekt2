package ch.zhaw.projekt2.projekt2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ai.djl.ModelException;
import ai.djl.modality.Classifications;
import ai.djl.translate.TranslateException;

import java.io.IOException;

@Controller
public class Project2Controller {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload.");
            return "index";
        }

        try {
            Classifications classifications = ImageClassification.predict(file);
            model.addAttribute("classifications", classifications);
        } catch (IOException | ModelException | TranslateException e) {
            model.addAttribute("message", "Error occurred during image classification: " + e.getMessage());
        }

        return "result";
    }
}
