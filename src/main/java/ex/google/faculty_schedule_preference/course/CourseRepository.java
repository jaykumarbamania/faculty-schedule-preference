package ex.google.faculty_schedule_preference.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> getCoursesByDepartment(@Param("id") long id);
    
    // exact-match search
    @Query("SELECT c FROM Course c WHERE c.department.name = :name")
    List<Course> getCoursesByDepartment(@Param("name") String name);

    @Query(value = "SELECT * FROM courses WHERE MATCH(name,prefix) AGAINST(:term IN BOOLEAN MODE);", nativeQuery = true)
    // @Query(value = "SELECT * FROM courses WHERE MATCH(name,prefix)
    // AGAINST(':searchText*' IN BOOLEAN MODE);", nativeQuery = true)
    List<Course> getCoursesBySearchText(@Param("term") String searchText);

    @Query(value = "SELECT * FROM courses WHERE term_id = :term", nativeQuery = true)
    List<Course> getCoursesByTerm(@Param("term") String term);

    @Query(value = "SELECT * FROM courses WHERE type = :type ", nativeQuery = true)
    List<Course> getCoursesByType(@Param("type") String type);
    
    @Query("SELECT c FROM Course c WHERE c.enrollmentBased = 1")
    List<Course> Query1();
    
    @Query("SELECT c FROM Course c WHERE c.enrollmentBased = 0")
    List<Course> Query2();
    
    @Query("SELECT c FROM Course c WHERE c.type = 3")
    List<Course> Query3();
    
    @Query("SELECT c FROM Course c WHERE c.type = 1")
    List<Course> Query4();
    
    @Query("SELECT c FROM Course c WHERE c.type = 2")
    List<Course> Query5();
}