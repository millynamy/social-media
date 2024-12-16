package com.team2.socialAPI.mappers;

import com.team2.socialAPI.dtos.HashtagDto;
import com.team2.socialAPI.entities.Hashtag;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-25T13:44:59-0500",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class HashtagMapperImpl implements HashtagMapper {

    @Override
    public List<HashtagDto> entitiesToDtos(List<Hashtag> hashtags) {
        if ( hashtags == null ) {
            return null;
        }

        List<HashtagDto> list = new ArrayList<HashtagDto>( hashtags.size() );
        for ( Hashtag hashtag : hashtags ) {
            list.add( hashtagToHashtagDto( hashtag ) );
        }

        return list;
    }

    protected HashtagDto hashtagToHashtagDto(Hashtag hashtag) {
        if ( hashtag == null ) {
            return null;
        }

        HashtagDto hashtagDto = new HashtagDto();

        hashtagDto.setLabel( hashtag.getLabel() );
        hashtagDto.setFirstUsed( hashtag.getFirstUsed() );
        hashtagDto.setLastUsed( hashtag.getLastUsed() );

        return hashtagDto;
    }
}
