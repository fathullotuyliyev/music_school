package uzb.dev_2K.music_school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uzb.dev_2K.music_school.model.Media;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project music_school
 * @author: Fathullo To'yliyev on 16/02/2023.
 * Company: Technologic ASBT
 */
@Service
public class MediaService {
    private final String UPLOAD_DIR = "/uploads";
    private final Path uploadPath;

    public MediaService(@Value("${app.upload.dir:${user.home}}") String uploadDir) {
        this.uploadPath = Paths.get(uploadDir + UPLOAD_DIR).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.uploadPath);
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory", e);
        }
    }

    public void uploadMedia(MultipartFile file) {
        try {
            Path filePath = this.uploadPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Could not store file " + file.getOriginalFilename(), e);
        }
    }

    public List<Media> getAllMedia() {
        try {
            return Files.list(uploadPath)
                    .filter(file -> !Files.isDirectory(file))
                    .map(file -> {
                        Media media = new Media();
                        media.setName(file.getFileName().toString());
                        media.setUrl("/uploads/" + file.getFileName().toString());
                        return media;
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Could not get media list", e);
        }
    }
}
