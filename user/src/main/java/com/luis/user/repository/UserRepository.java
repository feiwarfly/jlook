package com.luis.user.repository;

import com.luis.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by luis on 2017/7/3.
 */
@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {

}
