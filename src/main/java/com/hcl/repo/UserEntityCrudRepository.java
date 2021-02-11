package com.hcl.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.UserEntity;


@Repository
public interface UserEntityCrudRepository extends CrudRepository<UserEntity,String> {

}
