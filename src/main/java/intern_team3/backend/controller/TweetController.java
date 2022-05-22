package intern_team3.backend.controller;

import intern_team3.backend.dto.TweetGetResponseDto;
import intern_team3.backend.dto.TweetRequestDto;
import intern_team3.backend.dto.TweetResponseDto;
import intern_team3.backend.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tweets")
public class TweetController {
    private final TweetService tweetService;


    @GetMapping("")
    public List<TweetGetResponseDto> findAll() {
        return tweetService.findAll();
    }


    @PostMapping("")
    public ResponseEntity<TweetResponseDto> createTweet(@RequestBody TweetRequestDto tweetRequestDto) {
        Long tweetId= tweetService.createTweet(tweetRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tweetId)
                .toUri();

        TweetResponseDto tweetCreateResponseDto = new TweetResponseDto(tweetId, "SUCCESS");

        return ResponseEntity.created(location).body(tweetCreateResponseDto);
    }


    @DeleteMapping("/{tweetId}")
    public ResponseEntity<TweetResponseDto> deleteTweetById(@PathVariable Long tweetId) {
        tweetService.deleteById(tweetId);
        TweetResponseDto tweetDeleteResponseDto = new TweetResponseDto(tweetId, "success");

        return ResponseEntity.ok().body(tweetDeleteResponseDto);
    }
}