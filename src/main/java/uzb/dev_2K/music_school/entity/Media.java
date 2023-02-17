package uzb.dev_2K.music_school.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @project music_school
 * @author: Fathullo To'yliyev on 16/02/2023.
 * Company: Technologic ASBT
 */
@Entity
@Table(name = "media")
@Data
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;//fayl nomi
    private String filepath;//fayl yo'li
    private String mimetype;
}
