package uzb.dev_2K.music_school.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import uzb.dev_2K.music_school.entity.Announcement;
import uzb.dev_2K.music_school.model.Media;
import uzb.dev_2K.music_school.repository.AnnouncementRepository;
import uzb.dev_2K.music_school.service.MediaService;

import java.util.List;

/**
 * @project music_school
 * @author: Fathullo To'yliyev on 16/02/2023.
 * Company: Technologic ASBT
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

//    @Autowired
//    AnnouncementRepository announcementRepository;//E'lonlar Ombori
//    @Autowired
//    MediaService mediaService;

    private AnnouncementRepository announcementRepository;
    private MediaService mediaService;

    public AdminController(AnnouncementRepository announcementRepository, MediaService mediaService) {
        this.announcementRepository = announcementRepository;
        this.mediaService = mediaService;
    }

    @GetMapping("/announcements")
    public String getAnnouncements(Model model) {
        List<Announcement> announcements = announcementRepository.findAll();
//        model.addAttribute("announcements", announcements);
        return "admin/announcements";
    }

    @GetMapping("/announcements")
    public String addAnnouncement(@RequestParam String title, @RequestParam String content) {
        Announcement announcement = new Announcement();
        announcement.setTitle(title);
        announcement.setContent(content);
        announcementRepository.save(announcement);
        return "redirect:/admin/announcements";
    }

    @GetMapping("/media")
    public String getMedia(Model model) {
        List<Media> media = mediaService.getAllMedia();
//        model.addAttribute("media", media);
        return "admin/media";
    }

    @GetMapping("/media")
    public String addMedia(@RequestParam MultipartFile file) {
        mediaService.uploadMedia(file);
        return "redirect:/admin/media";
    }
}
