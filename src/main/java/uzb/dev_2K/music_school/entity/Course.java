package uzb.dev_2K.music_school.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @project music_school
 * @author: Fathullo To'yliyev on 16/02/2023.
 * Company: Technologic ASBT
 */
@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

}
