package com.team2.socialAPI.mappers;

import com.team2.socialAPI.dtos.TweetRequestDto;
import com.team2.socialAPI.dtos.TweetResponseDto;
import com.team2.socialAPI.entities.Tweet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-25T13:44:59-0500",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class TweetMapperImpl implements TweetMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public TweetResponseDto entityToDto(Tweet tweet) {
        if ( tweet == null ) {
            return null;
        }

        TweetResponseDto tweetResponseDto = new TweetResponseDto();

        tweetResponseDto.setId( tweet.getId() );
        tweetResponseDto.setAuthor( userMapper.entityToDto( tweet.getAuthor() ) );
        tweetResponseDto.setPosted( tweet.getPosted() );
        tweetResponseDto.setContent( tweet.getContent() );
        tweetResponseDto.setInReplyTo( entityToDto( tweet.getInReplyTo() ) );
        tweetResponseDto.setRepostOf( entityToDto( tweet.getRepostOf() ) );

        return tweetResponseDto;
    }

    @Override
    public Tweet responseDtoToEntity(TweetResponseDto tweetResponseDto) {
        if ( tweetResponseDto == null ) {
            return null;
        }

        Tweet tweet = new Tweet();

        tweet.setId( tweetResponseDto.getId() );
        tweet.setAuthor( userMapper.responseDtoToEntity( tweetResponseDto.getAuthor() ) );
        tweet.setPosted( tweetResponseDto.getPosted() );
        tweet.setContent( tweetResponseDto.getContent() );
        tweet.setInReplyTo( responseDtoToEntity( tweetResponseDto.getInReplyTo() ) );
        tweet.setRepostOf( responseDtoToEntity( tweetResponseDto.getRepostOf() ) );

        return tweet;
    }

    @Override
    public Tweet requestDtoToEntity(TweetRequestDto tweetRequestDto) {
        if ( tweetRequestDto == null ) {
            return null;
        }

        Tweet tweet = new Tweet();

        tweet.setContent( tweetRequestDto.getContent() );

        return tweet;
    }

    @Override
    public List<TweetResponseDto> entitiesToDtos(List<Tweet> tweets) {
        if ( tweets == null ) {
            return null;
        }

        List<TweetResponseDto> list = new ArrayList<TweetResponseDto>( tweets.size() );
        for ( Tweet tweet : tweets ) {
            list.add( entityToDto( tweet ) );
        }

        return list;
    }
}
