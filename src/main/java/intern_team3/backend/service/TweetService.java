package intern_team3.backend.service;

import intern_team3.backend.domain.Tweet;
import intern_team3.backend.domain.TweetRepository;
import intern_team3.backend.domain.UserRepository;
import intern_team3.backend.dto.TweetGetResponseDto;
import intern_team3.backend.dto.TweetRequestDto;
import intern_team3.backend.service.Error.CustomException;
import intern_team3.backend.service.Error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service

public class TweetService {
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    //게시글 생성
    @Transactional
    public Long createTweet(TweetRequestDto tweetRequestDto) {
        if (tweetRequestDto.getContents().isEmpty()) {
            throw new CustomException(ErrorCode.CANNOT_EMPTY_CONTENT);
        }

        Tweet tweet = tweetRequestDto.toEntity(userRepository);
        tweetRepository.save(tweet);
        return tweet.getTweet_id();

    }

    //게시글 조회
    public List<TweetGetResponseDto> findAll() {

        return tweetRepository.findTweetCustomResponse();
    }

    @Transactional
    public TweetGetResponseDto findById(Long tweetId) {
        Tweet entity = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new CustomException(ErrorCode.PAGE_NOT_FOUND));
        TweetGetResponseDto tweetGetResponseDto = new TweetGetResponseDto(entity);

        return tweetGetResponseDto;
    }

    //게시글 삭제
    @Transactional
    public void deleteById(Long tweetId) {
        tweetRepository.delete(
                tweetRepository.findById(tweetId)
                        .orElseThrow(() -> new CustomException(ErrorCode.PAGE_NOT_FOUND))
        );

    }


}