import java.util.ArrayList;
import java.util.List;

// Interface for managing medical records
interface MedicalRecord
{
    void addRecord(String record);
    List<String> viewRecords();
}

// Abstract class for patients
abstract class Patient 
{
    private int patientId;
    private String name;
    private int age;
    private String diagnosis; // Encapsulated sensitive data
    private List<String> medicalHistory = new ArrayList<>(); // Encapsulated

    public Patient(int patientId, String name, int age, String diagnosis)
    {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    // Getters - secure access
    public int getPatientId()
    { 
	return patientId;
    }
    public String getName()
    { 
	return name;
    }
    public int getAge()
    { 
	return age;
    }

    // Getter for diagnosis (read-only)
    public String getDiagnosis()
    { 
	return diagnosis;
    }

    // Getter for history (read-only view)
    protected List<String> getMedicalHistory()
    { 
	return medicalHistory;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateBill();

    // Concrete method to display patient details
    public String getPatientDetails()
    {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Diagnosis: " + diagnosis;
    }
}

// In-patient subclass
class InPatient extends Patient implements MedicalRecord 
{
    private int numberOfDays;
    private double roomChargePerDay;
    private List<String> records = new ArrayList<>();

    public InPatient(int patientId, String name, int age, String diagnosis, int numberOfDays, double roomChargePerDay)
    {
        super(patientId, name, age, diagnosis);
        this.numberOfDays = numberOfDays;
        this.roomChargePerDay = roomChargePerDay;
    }

    public double calculateBill()
    {
        return numberOfDays * roomChargePerDay + 500; // Additional service charge
    }

    public void addRecord(String record)
    {
        records.add(record);
        getMedicalHistory().add(record); // Accessing protected encapsulated data
    }

    public List<String> viewRecords()
    {
        return records;
    }
}

// Out-patient subclass
class OutPatient extends Patient implements MedicalRecord 
{
    private double consultationFee;
    private List<String> records = new ArrayList<>();

    public OutPatient(int patientId, String name, int age, String diagnosis, double consultationFee)
    {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    public double calculateBill()
    {
        return consultationFee;
    }

    public void addRecord(String record)
    {
        records.add(record);
        getMedicalHistory().add(record); // Accessing protected encapsulated data
    }

    public List<String> viewRecords()
    {
        return records;
    }
}

// Main class
public class HospitalManagementSystem 
{
    // Polymorphic method
    public static void processPatient(Patient p)
    {
        System.out.println(p.getPatientDetails());
        System.out.println("Total Bill: ₹" + p.calculateBill());

        if (p instanceof MedicalRecord) 
	{
            MedicalRecord m = (MedicalRecord) p;
            m.addRecord("Initial checkup completed");
            System.out.println("Medical Records: " + m.viewRecords());
        }


    }

    public static void main(String... args)
    {
        Patient in = new InPatient(101, "Rahul Sharma", 45, "Pneumonia", 5, 1500);
        Patient out = new OutPatient(102, "Priya Desai", 30, "Flu", 500);

        processPatient(in);
        processPatient(out);
    }
}
