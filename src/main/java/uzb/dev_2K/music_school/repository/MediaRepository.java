package uzb.dev_2K.music_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzb.dev_2K.music_school.model.Media;

/**
 * @project music_school
 * @author: Fathullo To'yliyev on 16/02/2023.
 * Company: Technologic ASBT
 */
public interface MediaRepository extends JpaRepository<Media, Long> {
}
