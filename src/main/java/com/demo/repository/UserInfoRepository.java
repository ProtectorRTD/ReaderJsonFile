package com.demo.repository;

import com.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserInfoRepository extends JpaRepository<User, Integer>
{
    @Modifying
    @Query(value = "delete from user_info u where u.email= ?1", nativeQuery = true)
    void removeByEmail(String email);
    @Modifying
    @Query(value = "delete from user_info u where u.ip_address= ?1", nativeQuery = true)
    void removeByIp_address(String ip_address);
}
