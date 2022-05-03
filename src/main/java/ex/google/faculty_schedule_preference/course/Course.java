package ex.google.faculty_schedule_preference.course;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import ex.google.faculty_schedule_preference.department.Department;
import ex.google.faculty_schedule_preference.term.Term;

@Entity(name = "Course")
@Table(name = "courses", uniqueConstraints = {
        @UniqueConstraint(name = "course_number_unique", columnNames = "number") })
public class Course {
	
	@Transient
    static Map<Integer, String> weekDays = Map.of(1, "Sun", 2, "Mon", 3, "Tue", 4, "Wed", 5, "Thu", 6, "Fri", 7,
            "Sat");
    @Transient
    static Map<Integer, String> classType = Map.of(1, "Online", 2, "In-person", 3, "Hybrid");

    @Transient
    static Map<Integer, String> statusEnum = Map.of(1, "open", 2, "under review", 3, "closed");
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    // Example: 490, 491L
    @Column(name = "number", nullable = false, columnDefinition = "TEXT")
    private String number;
    
    @Column(name = "prefix", nullable = false, columnDefinition = "TEXT")
    private String prefix;

    @Column(name = "unit", nullable = false)
    private double unit;

    @Column(name = "k_factor", nullable = true)
    private String k_factor;
    

    @Column(name = "type", nullable = false)
    private int type;

    @Column(name = "enrollmentBased", nullable = false)
    private Boolean enrollmentBased;
    
    
    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "end_time", nullable = false)
    private String endTime;

    @OneToOne(fetch = FetchType.LAZY)
    private Department department;
    
    @Column(name = "status", nullable = false)
    private int status;
    
    @Column(name = "weekSchedule", nullable = false)
    private String weekSchedule;

    @OneToOne(fetch = FetchType.LAZY)
    private Term term;

    public Course() {
    }

    public Course(String name, String number, double unit) {
        this.name = name;
        this.number = number;
        this.unit = unit;
    }

    public Course(String name, String description, String number, double unit) {
        this.name = name;
        this.description = description;
        this.number = number;
        this.unit = unit;
    }

    public Course(String name, String description, String number, double unit,
                    String k_factor, Boolean enrollmentBased,  Department department, Term term) {
        this.name = name;
        this.description = description;
        this.number = number;
        this.unit = unit;
        this.k_factor = k_factor;
        this.enrollmentBased = enrollmentBased;
        this.department = department;
        this.term = term;        
    }
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }
    
    public String getK_factor(){
        return k_factor;
    }

    public void setK_factor(String k_factor){
        this.k_factor = k_factor;
    }

    public Boolean getEnrollmentBased(){
        return enrollmentBased;
    }

    public void setEnrollmentBased(Boolean enrollmentBased){
        this.enrollmentBased = enrollmentBased;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }
    
    public String getWeekSchedule() {
        return weekSchedule;
    }

    public void setWeekSchedule(String weekSchedule) {
        this.weekSchedule = weekSchedule;
    }

    public String getHumanClassType() {
        return this.classType.get(this.type);
    }

    public String getHumanStatus() {
        return this.statusEnum.get(this.type);
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}