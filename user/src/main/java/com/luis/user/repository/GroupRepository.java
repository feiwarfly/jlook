package com.luis.user.repository;

import com.luis.user.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by luis on 2017/7/4.
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, BigInteger> {

}
