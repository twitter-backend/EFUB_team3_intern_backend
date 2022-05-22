package intern_team3.backend.domain;

import intern_team3.backend.dto.TweetGetResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    @Query("SELECT p FROM Tweet p")
    List<TweetGetResponseDto> findTweetCustomResponse();

    @Query("SELECT p FROM Tweet p WHERE p.user=:user")
    List<TweetGetResponseDto> findUserTweetCustomResponse(User user);
}