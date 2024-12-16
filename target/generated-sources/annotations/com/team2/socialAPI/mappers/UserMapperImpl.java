package com.team2.socialAPI.mappers;

import com.team2.socialAPI.dtos.ProfileDto;
import com.team2.socialAPI.dtos.UserRequestDto;
import com.team2.socialAPI.dtos.UserResponseDto;
import com.team2.socialAPI.entities.Credentials;
import com.team2.socialAPI.entities.Profile;
import com.team2.socialAPI.entities.User;
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
public class UserMapperImpl implements UserMapper {

    @Autowired
    private CredentialsMapper credentialsMapper;

    @Override
    public UserResponseDto entityToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setUsername( userCredentialsUsername( user ) );
        userResponseDto.setProfile( profileToProfileDto( user.getProfile() ) );
        userResponseDto.setJoined( user.getJoined() );

        return userResponseDto;
    }

    @Override
    public User responseDtoToEntity(UserResponseDto userResponseDto) {
        if ( userResponseDto == null ) {
            return null;
        }

        User user = new User();

        user.setProfile( profileDtoToProfile( userResponseDto.getProfile() ) );
        user.setJoined( userResponseDto.getJoined() );

        return user;
    }

    @Override
    public User requestDtoToEntity(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setCredentials( credentialsMapper.dtoToEntity( userRequestDto.getCredentials() ) );
        user.setProfile( profileDtoToProfile( userRequestDto.getProfile() ) );

        return user;
    }

    @Override
    public List<UserResponseDto> entitiesToDtos(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<UserResponseDto>( users.size() );
        for ( User user : users ) {
            list.add( entityToDto( user ) );
        }

        return list;
    }

    private String userCredentialsUsername(User user) {
        Credentials credentials = user.getCredentials();
        if ( credentials == null ) {
            return null;
        }
        return credentials.getUsername();
    }

    protected ProfileDto profileToProfileDto(Profile profile) {
        if ( profile == null ) {
            return null;
        }

        ProfileDto profileDto = new ProfileDto();

        profileDto.setFirstName( profile.getFirstName() );
        profileDto.setLastName( profile.getLastName() );
        profileDto.setEmail( profile.getEmail() );
        profileDto.setPhone( profile.getPhone() );

        return profileDto;
    }

    protected Profile profileDtoToProfile(ProfileDto profileDto) {
        if ( profileDto == null ) {
            return null;
        }

        Profile profile = new Profile();

        profile.setFirstName( profileDto.getFirstName() );
        profile.setLastName( profileDto.getLastName() );
        profile.setEmail( profileDto.getEmail() );
        profile.setPhone( profileDto.getPhone() );

        return profile;
    }
}
