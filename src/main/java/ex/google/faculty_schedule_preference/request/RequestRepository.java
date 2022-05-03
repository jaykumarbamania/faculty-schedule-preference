package ex.google.faculty_schedule_preference.request;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RequestRepository extends JpaRepository<Request, Long> {
	
    @Query(value = "SELECT * FROM requests WHERE course_id = :id", nativeQuery = true)
    List<Request> getRequestByCourses(@Param("id") long course);
}