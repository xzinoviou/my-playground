package com.xzinoviou.myplayground.service

import com.xzinoviou.myplayground.exception.PlaygroundAppException
import com.xzinoviou.myplayground.mapper.UserMapper
import com.xzinoviou.myplayground.model.input.UserCreateInput
import com.xzinoviou.myplayground.repository.UserRepository
import org.mapstruct.factory.Mappers
import spock.lang.Specification

import java.time.OffsetDateTime

/**
 * @author : Xenofon Zinoviou
 */
class UserServiceImplSpec extends Specification {

    private UserService testClass
    private UserRepository userRepository
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class)

    void setup() {
        userRepository = Mock()
        testClass = new UserServiceImpl(userRepository, userMapper)
    }

    void cleanup() {
        testClass = null
    }


    def "Delete successfully a user"() {
        given: "The user id"
        def id = 3

        when: "the delete user operation is called"
        testClass.delete(id)

        then: "nothing is returned"
        1 * userRepository.deleteById(userId -> { userId == id })
    }

    def "Fail to create a user with invalid role"() {
        given: "An input for a new user with an invalid role"
        def input = new UserCreateInput(firstName: "Mike", lastName: "Rogers", role: "invalid", registrationDate: OffsetDateTime.now().toString())

        when: "The create operation is called"
        testClass.create(input)

        then: "An error is returned"
        def ex = thrown(PlaygroundAppException.class)
        ex.message == "Failed to create user"
        0 * userRepository.save(_)
    }
}
