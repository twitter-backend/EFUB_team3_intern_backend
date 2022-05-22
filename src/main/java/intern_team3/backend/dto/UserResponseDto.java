package intern_team3.backend.dto;

import intern_team3.backend.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long userId;
    private String nickname;
    private String twitterId;

    public UserResponseDto(User user) {
        this.userId= user.getUser_id();
        this.nickname= user.getNickname();
        this.twitterId=user.getTwitter_id();
    }
}