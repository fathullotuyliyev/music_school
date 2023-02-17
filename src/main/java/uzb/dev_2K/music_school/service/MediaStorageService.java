package uzb.dev_2K.music_school.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uzb.dev_2K.music_school.model.Media;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @project music_school
 * @author: Fathullo To'yliyev on 16/02/2023.
 * Company: Technologic ASBT
 */
@Service
public class MediaStorageService {
    private final MediaService mediaService;

    public MediaStorageService(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    public void store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Media media = new Media(fileName, "/uploads/" + fileName);
//        mediaService.saveMedia(media);

        Path uploadDir = Paths.get("uploads");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadDir.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
