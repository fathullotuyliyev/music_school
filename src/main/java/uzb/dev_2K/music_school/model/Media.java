package uzb.dev_2K.music_school.model;

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
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String url;

    public Media() {
    }

    public Media(String name, String url) {
        this.name = name;
        this.url = url;
    }

}
