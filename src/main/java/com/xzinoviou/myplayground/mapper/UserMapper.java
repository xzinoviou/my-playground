package com.xzinoviou.myplayground.mapper;

import com.xzinoviou.myplayground.model.dto.UserDto;
import com.xzinoviou.myplayground.model.entity.User;
import com.xzinoviou.myplayground.model.enumeration.UserRole;
import com.xzinoviou.myplayground.model.input.UserCreateInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author : Xenofon Zinoviou
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "user", target = "registrationDate", qualifiedByName = "convertFromUtc")
    @Mapping(source = "timeZoneOffset", target = "timeZoneOffset")
    UserDto mapToDto(User user);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "role", target = "role", qualifiedByName = "convertToUserRole")
    @Mapping(source = "registrationDate", target = "registrationDate", qualifiedByName = "mapToUtc")
    @Mapping(source = "registrationDate", target = "timeZoneOffset", qualifiedByName = "getTimeZoneOffset")
    User mapToEntity(UserCreateInput input);


    @Named("convertToUserRole")
    default UserRole convertToUserRole(String input) {
        return UserRole.fromRole(input);
    }

    @Named("getTimeZoneOffset")
    default String getTimeZoneOffset(String offsetDateTimeString) {
        var offset = OffsetDateTime.parse(offsetDateTimeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME).getOffset().toString();

        if (offset.equals("Z")) {
            return "+00:00";
        }
        return offset;
    }

    @Named("convertFromUtc")
    default OffsetDateTime convertFromUtc(User user) {
        return user.getRegistrationDate().withOffsetSameInstant(ZoneOffset.of(user.getTimeZoneOffset()));
    }

    @Named("mapToUtc")
    default OffsetDateTime mapToUtc(String offsetDateTimeString) {
        return OffsetDateTime.parse(offsetDateTimeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME).withOffsetSameInstant(ZoneOffset.UTC);
    }
}
