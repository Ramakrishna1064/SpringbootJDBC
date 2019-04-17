package com.example.demo.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.EmployeeRecord;

@Repository
public interface QueryRepository1 extends JpaRepository<EmployeeRecord, Integer> {

	// Using @Query
	@Query("select e from EmployeeRecord e where e.id = ?1 AND e.name = ?2")
	EmployeeRecord findUserId(int id, String name);

	// Using Like Operator
	@Query("select e from EmployeeRecord e where e.name like %?1")
	EmployeeRecord findByLikeOperator(String name);

	// Native Query
	@Query(value="select * from employee  where id = ?1 AND name = ?2", nativeQuery = true)
	EmployeeRecord findUserName(int id, String name);
	

	@Modifying
	@Transactional
	@Query("update EmployeeRecord e set e.name = ?1 where e.email = ?2")
	int updateUser(String name,String email);
	
	@Modifying
	@Transactional
	@Query("delete from EmployeeRecord e where e.id = ?1")
	int deleteUser(int id);
	
}
