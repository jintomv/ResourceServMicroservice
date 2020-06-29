package com.security.ResourceServer.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.security.ResourceServer.v1.Entity.UserEntity;

/**
 * 
 * Repository for carried out crud operations of user Entity
 *
 */
@Repository(value="UserRepository")
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	/**
	 * Method that fetches userdetails according the requested {id}
	 * @param entity
	 * @return
	 */
	UserEntity findUserByid(Long id);

}
