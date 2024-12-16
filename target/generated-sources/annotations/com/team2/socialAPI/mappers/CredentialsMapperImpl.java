package com.team2.socialAPI.mappers;

import com.team2.socialAPI.dtos.CredentialsDto;
import com.team2.socialAPI.entities.Credentials;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-25T13:44:59-0500",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class CredentialsMapperImpl implements CredentialsMapper {

    @Override
    public CredentialsDto entityToDto(Credentials credentials) {
        if ( credentials == null ) {
            return null;
        }

        CredentialsDto credentialsDto = new CredentialsDto();

        credentialsDto.setUsername( credentials.getUsername() );
        credentialsDto.setPassword( credentials.getPassword() );

        return credentialsDto;
    }

    @Override
    public Credentials dtoToEntity(CredentialsDto dto) {
        if ( dto == null ) {
            return null;
        }

        Credentials credentials = new Credentials();

        credentials.setUsername( dto.getUsername() );
        credentials.setPassword( dto.getPassword() );

        return credentials;
    }
}
