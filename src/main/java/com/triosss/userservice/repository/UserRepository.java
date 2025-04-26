package com.triosss.userservice.repository;

import com.triosss.userservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer > {

    User findByContactNo(String contactNo);
    User deleteByContactNo(String contactNo);
}
