package intern_team3.backend.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tweet")

public class Tweet {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long tweet_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(length = 255, nullable = false)
    private String contents;

    @PrePersist
    public void createDate() {
        this.date = LocalDateTime.now();
    }

    @Builder
    public Tweet(User user, LocalDateTime date, String contents) {
        this.user = user;
        this.date = date;
        this.contents = contents;
    }
}