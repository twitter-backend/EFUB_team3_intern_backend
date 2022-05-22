package intern_team3.backend.dto;

import intern_team3.backend.domain.Tweet;
import intern_team3.backend.domain.UserRepository;
import intern_team3.backend.service.Error.CustomException;
import intern_team3.backend.service.Error.ErrorCode;
import intern_team3.backend.service.Error.CustomException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TweetRequestDto {
    private Long userId;
    private LocalDateTime date;
    private String contents;

    @Builder
    public TweetRequestDto(Tweet tweet){
        this.userId= tweet.getUser().getUser_id();
        this.date= tweet.getDate();
        this.contents= tweet.getContents();
    }

    public Tweet toEntity(UserRepository userRepository) {
        return Tweet.builder().user(userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND)))
                .date(date)
                .contents(contents)
                .build();
    }
}