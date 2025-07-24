// 5. AI-Driven Resume Screening System

// Abstract class for Job Roles
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}

// Concrete Job Role types
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private String candidateName;
    private T desiredRole;
    private List<String> skills;
    private double score; // Simulated screening score

    public Resume(String candidateName, T desiredRole, List<String> skills) {
        this.candidateName = candidateName;
        this.desiredRole = desiredRole;
        this.skills = skills;
        this.score = 0.0; // Initialize score
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getDesiredRole() {
        return desiredRole;
    }

    public List<String> getSkills() {
        return skills;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Resume for " + candidateName + " (Role: " + desiredRole.getRoleName() + ", Score: " + String.format("%.2f", score) + ")";
    }
}

class ResumeScreeningSystem {

    // Generic method to process a single resume
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("\nProcessing resume for: " + resume.getCandidateName() + " (" + resume.getDesiredRole().getRoleName() + ")");
        double calculatedScore = 0;
        // Simple scoring logic based on skills
        for (String skill : resume.getSkills()) {
            if (skill.contains("Java") || skill.contains("Python") || skill.contains("SQL")) {
                calculatedScore += 10;
            }
            if (skill.contains("Machine Learning") || skill.contains("Data Analysis")) {
                calculatedScore += 15;
            }
            if (skill.contains("Product Strategy") || skill.contains("Agile")) {
                calculatedScore += 12;
            }
        }
        resume.setScore(calculatedScore);
        System.out.println("  Initial Score: " + resume.getScore());
    }

    // Wildcard method to handle multiple job roles in the screening pipeline
    public static void screenAllResumes(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("\n--- Initiating Batch Resume Screening ---");
        for (Resume<? extends JobRole> resume : resumes) {
            processResume(resume); // Use the generic processResume method
        }
        System.out.println("--- Batch Screening Complete ---");
    }

    public static void main(String[] args) {
        // Create resumes for different job roles
        Resume<SoftwareEngineer> seResume1 = new Resume<>(
            "Alice Smith", new SoftwareEngineer(), Arrays.asList("Java", "Spring Boot", "SQL", "Microservices"));

        Resume<DataScientist> dsResume1 = new Resume<>(
            "Bob Johnson", new DataScientist(), Arrays.asList("Python", "Machine Learning", "R", "Statistics"));

        Resume<ProductManager> pmResume1 = new Resume<>(
            "