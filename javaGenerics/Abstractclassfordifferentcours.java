// Abstract class for different course evaluation types
abstract class CourseType {
    private String typeName;

    public CourseType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }
}

// Concrete course evaluation types
class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
}

// Generic Course class
class Course<T extends CourseType> {
    private String courseCode;
    private String courseName;
    private int credits;
    private T evaluationType;

    public Course(String courseCode, String courseName, int credits