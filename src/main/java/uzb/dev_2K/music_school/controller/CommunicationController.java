package uzb.dev_2K.music_school.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @project music_school
 * @author: Fathullo To'yliyev on 16/02/2023.
 * Company: Technologic ASBT
 */
@Controller
public class CommunicationController {

    @GetMapping("/communication")
    public String communication(Model model) {
        return "communication";
    }
}
