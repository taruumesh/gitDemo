package org.techhub.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.techhub.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Modifying
	@Transactional
	@Query("update Employee emp set emp.name=:ename, emp.address=:eaddress where emp.id=:eid")
	int updateEmployee(@Param("eid") int eid,@Param("ename") String ename,@Param("eaddress") String eaddress);

}
