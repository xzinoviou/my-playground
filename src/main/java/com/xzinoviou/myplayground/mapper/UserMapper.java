package com.xzinoviou.myplayground.mapper;

import com.xzinoviou.myplayground.model.dto.UserDto;
import com.xzinoviou.myplayground.model.entity.User;
import com.xzinoviou.myplayground.model.enumeration.UserRole;
import com.xzinoviou.myplayground.model.input.UserCreateInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

/**
 * @author : Xenofon Zinoviou
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "offsetDateTime", target = "offsetDateTime")
    @Mapping(source = "localDateTime", target = "localDateTime")
    @Mapping(source = "timeZoneOffset", target = "timeZoneOffset")
    UserDto mapToDto(User user);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "role", target = "role", qualifiedByName = "convertToUserRole")
    @Mapping(source = "offsetDateTime", target = "offsetDateTime", qualifiedByName = "getOffsetDateTime")
    @Mapping(source = "offsetDateTime", target = "localDateTime", qualifiedByName = "getLocalDateTime")
    @Mapping(source = "offsetDateTime", target = "timeZoneOffset", qualifiedByName = "getTimeZoneOffset")
    User mapToEntity(UserCreateInput input);


    @Named("convertToUserRole")
    default UserRole convertToUserRole(String input) {
        return UserRole.fromRole(input);
    }

    @Named("getTimeZoneOffset")
    default String getTimeZoneOffset(String offsetDateTimeString) {
        return OffsetDateTime.parse(offsetDateTimeString).getOffset().toString();
    }

    @Named("getOffsetDateTime")
    default OffsetDateTime getOffsetDateTime(String offsetDateTimeString) {
        return OffsetDateTime.parse(offsetDateTimeString);
    }

    @Named("getLocalDateTime")
    default LocalDateTime getLocalDateTime(String offsetDateTimeString) {
        return OffsetDateTime.parse(offsetDateTimeString).toLocalDateTime();
    }
}
