package by.teachmeskills.lesson39.entity;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class UserId implements Serializable {
    @Id
    private Long id;
    @Id
    private LocalDateTime createdAt;
}
