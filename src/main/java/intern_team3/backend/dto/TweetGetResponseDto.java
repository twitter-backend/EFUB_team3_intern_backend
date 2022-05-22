package intern_team3.backend.dto;

import intern_team3.backend.domain.Tweet;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TweetGetResponseDto {
    private Long tweetId;
    private UserResponseDto user;
    private LocalDateTime date;
    private String contents;

    public TweetGetResponseDto(Tweet tweet)  {
        tweetId = tweet.getTweet_id();
        user = new UserResponseDto(tweet.getUser());
        date = tweet.getDate();
        contents = tweet.getContents();
    }
}