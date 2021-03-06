package com.mypet.web.person;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	public Person findByUseridAndPasswd(String userid, String passwd);
	public Person findByUserid(String userid);
	public List<Person> findByRole(String role);
	
	
	@Query(value="SELECT * FROM PERSON GROUP BY HAK" ,nativeQuery = true)
	public List<Person> findGroupByHak();
	@Query(value="SELECT MAX(P.SCORE), P.* FROM PERSON P GROUP BY HAK HAVING ROLE LIKE 'STUDENT'",nativeQuery = true)
	public List<Person> findScore();
	
}
