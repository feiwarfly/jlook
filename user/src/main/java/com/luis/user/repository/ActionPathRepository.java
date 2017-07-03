package com.luis.user.repository;

import com.luis.user.entity.ActionPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by luis on 2017/7/3.
 */
@Repository
public interface ActionPathRepository extends JpaRepository<ActionPath, BigInteger> {

}
