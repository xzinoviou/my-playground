package com.xzinoviou.myplayground.service;

import com.xzinoviou.myplayground.model.dto.UserDto;
import com.xzinoviou.myplayground.model.input.UserCreateInput;

import java.util.List;

/**
 * @author : Xenofon Zinoviou
 */
public interface UserService {

    UserDto getById(long id);

    List<UserDto> getAll();

    Long create(UserCreateInput input);

    UserDto update(UserCreateInput input);

    void delete(Long id);
}
