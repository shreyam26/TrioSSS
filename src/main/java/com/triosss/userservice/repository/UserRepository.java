package com.triosss.userservice.repository;

import com.triosss.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByContactNo(String contactNo);

    @Query(value = "delete from USER where u.contactNo = :contactNo",nativeQuery = true)
    void deleteByContactNo(@Param(value = "contactNo") String contactNo);



}
