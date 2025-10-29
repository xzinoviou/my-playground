package com.xzinoviou.myplayground.repository;

import com.xzinoviou.myplayground.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Xenofon Zinoviou
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
