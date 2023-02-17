package uzb.dev_2K.music_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import uzb.dev_2K.music_school.service.MediaStorageService;

import java.io.IOException;

/**
 * @project music_school
 * @author: Fathullo To'yliyev on 16/02/2023.
 * Company: Technologic ASBT
 */
@Controller
@RequestMapping("/admin/media")
public class MediaUploadController {

//    @Autowired
//    MediaStorageService mediaStorageService;

    private MediaStorageService mediaStorageService;

    public MediaUploadController(MediaStorageService mediaStorageService) {
        this.mediaStorageService = mediaStorageService;
    }

    //fayllarni qo'lda kiritish
    @PostMapping
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        mediaStorageService.store(file);
        return "redirect:/admin/media";
    }

}
