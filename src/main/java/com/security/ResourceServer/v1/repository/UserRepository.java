package com.security.ResourceServer.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.ResourceServer.v1.Entity.UserEntity;

/**
 * 
 * Repository for carried out crud operations of user Entity
 * 
 * @author jinto varghese
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
	
	/**
	 * Method that fetches userdetails according the requested {userName}
	 * @param userName
	 * @return
	 */
	//UserEntity findByUserName(String userName);
	/**
	 * Method returns users that have firstname and lastname according to
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	
	List<UserEntity> findByFirstnameAndLastname(String firstName, String lastName);
}
