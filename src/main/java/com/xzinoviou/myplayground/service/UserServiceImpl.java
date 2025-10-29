package com.xzinoviou.myplayground.service;

import com.xzinoviou.myplayground.exception.PlaygroundAppException;
import com.xzinoviou.myplayground.mapper.UserMapper;
import com.xzinoviou.myplayground.model.dto.UserDto;
import com.xzinoviou.myplayground.model.input.UserCreateInput;
import com.xzinoviou.myplayground.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Xenofon Zinoviou
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto getById(long id) {
        var user = userRepository.findById(id).orElseThrow(() -> new PlaygroundAppException("Fail to find user with id: " + id));
        return userMapper.mapToDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(userMapper::mapToDto).toList();
    }

    @Override
    public Long create(UserCreateInput input) {
        try {
            var user = userMapper.mapToEntity(input);
            return userRepository.save(user).getId();
        } catch (RuntimeException e) {
            throw new PlaygroundAppException("Failed to create user");
        }
    }

    @Override
    public UserDto update(UserCreateInput input) {
        try {
            var user = userMapper.mapToEntity(input);
            var updatedUser = userRepository.save(user);
            return userMapper.mapToDto(updatedUser);
        } catch (RuntimeException e) {
            throw new PlaygroundAppException("Failed to update user with id: " + input.getId());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new PlaygroundAppException("Failed to delete user with id: " + id);
        }
    }
}
