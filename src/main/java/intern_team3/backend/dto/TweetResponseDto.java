package intern_team3.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TweetResponseDto {
    Long tweetId;
    String message;

    public TweetResponseDto(Long tweetId, String message) {
        this.tweetId = tweetId;
        this.message= message;
    }
}
