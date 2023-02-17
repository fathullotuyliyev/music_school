package uzb.dev_2K.music_school.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import uzb.dev_2K.music_school.model.Media;
import uzb.dev_2K.music_school.service.MediaService;

import java.util.List;

/**
 * @project music_school
 * @author: Fathullo To'yliyev on 16/02/2023.
 * Company: Technologic ASBT
 */
@Controller
public class MediaController {

//    @Autowired
//    MediaService mediaService;

    private MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public String getMedia(Model model) {
        List<Media> media = mediaService.getAllMedia();
//        model.addAttribute("media", media);
        return "media";
    }
}
