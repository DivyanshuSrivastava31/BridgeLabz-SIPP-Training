class main {
    public static void main(String[] args) {
        Course c1 = new Course("CS101", "Data Structures", 4);
        Course c2 = new Course("CS102", "AI", 3);

        Undergraduate s1 = new Undergraduate("Alice", 1001);
        Postgraduate s2 = new Postgraduate("Bob", 2002);

        Enrollment e1 = new Enrollment(s1, c1);
        Enrollment e2 = new Enrollment(s2, c2);

        Faculty prof = new Faculty("Dr. Sharma");

        prof.assignGrade(e1, "A");     // Letter grade
        prof.assignGrade(e2, "P");     // Pass grade

        s1.printTranscript();
        s2.printTranscript();
    }
}


interface Graded {
    void assignGrade(Enrollment enrollment, String grade);
}


class Course{
    String courseId;
    String courseName;
    int credits;

    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }
}


class Student {
    protected String name;
    protected int studentId;
    protected String program;
    private double totalPoints = 0;
    private int totalCredits = 0;

    public Student(String name, int studentId, String program) {
        this.name = name;
        this.studentId = studentId;
        this.program = program;
    }

   
    public void addGrade(String grade, int credits) {
        double points = convertGradeToPoints(grade);
        totalPoints += points * credits;
        totalCredits += credits;
    }

    private double convertGradeToPoints(String grade) {
        switch (grade) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
            case "P": return 1.0;
            case "F*": return 0.0;
            default: return 0.0;
        }
    }

    public double getGPA() {
        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }

    public void printTranscript() {
        System.out.println("Transcript for " + name);
        System.out.println("Program: " + program);
        System.out.println("GPA: " + getGPA());
    }
}


class Undergraduate extends Student {
    public Undergraduate(String name, int id) {
        super(name, id, "Undergraduate");
    }
}

class Postgraduate extends Student {
    public Postgraduate(String name, int id) {
        super(name, id, "Postgraduate");
    }
}


class Enrollment {
    Student student;
    Course course;
    String grade; // e.g., A, B, P, F

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void setGrade(String grade) {
        this.grade = grade;
        student.addGrade(grade, course.credits);
    }
}


class Faculty implements Graded {
    String name;

    public Faculty(String name) {
        this.name = name;
    }

    
    public void assignGrade(Enrollment enrollment, String grade) {
        enrollment.setGrade(grade);
        System.out.println("Faculty " + name + " assigned grade " + grade + " to " + enrollment.student.name);
    }
}
