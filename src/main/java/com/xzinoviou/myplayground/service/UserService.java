package com.xzinoviou.myplayground.service;

import com.xzinoviou.myplayground.model.dto.UserDto;
import com.xzinoviou.myplayground.model.entity.User;
import com.xzinoviou.myplayground.model.input.UserCreateInput;

import java.util.List;

/**
 * @author : Xenofon Zinoviou
 */
public interface UserService {
    List<UserDto> getAll();

    UserDto getById(long id);

    Long create(UserCreateInput input);

    UserDto update(UserCreateInput input);

    void delete(Long id);
}
