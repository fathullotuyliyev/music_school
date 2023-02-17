package uzb.dev_2K.music_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzb.dev_2K.music_school.entity.Announcement;

/**
 * @project music_school
 * @author: Fathullo To'yliyev on 16/02/2023.
 * Company: Technologic ASBT
 */
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
