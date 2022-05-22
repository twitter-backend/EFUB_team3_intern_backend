package intern_team3.backend.domain;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name= "user")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long user_id;

    @Column(length=50, nullable=false)
    private String nickname;

    @Column(length=50, nullable=false)
    private String twitter_id;

    @Builder
    public User(String nickname, String twitter_id) {
        this.nickname=nickname;
        this.twitter_id=twitter_id;
    }

    public void updateProfile(String nickname, String twitter_id) {
        this.nickname=nickname;
        this.twitter_id=twitter_id;
    }
}