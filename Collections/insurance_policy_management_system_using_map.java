import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

// Policy Class
class Policy {
    private String policyNumber; // Unique identifier
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
               "policyNumber='" + policyNumber + '\'' +
               ", policyholderName='" + policyholderName + '\'' +
               ", expiryDate=" + expiryDate +
               ", coverageType='" + coverageType + '\'' +
               ", premiumAmount=" + premiumAmount +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }
}

public class InsurancePolicyManagementSystem {

    // 1. Store Policies in a Map
    private Map<String, Policy> hashMapPolicies;        // HashMap for quick lookups by policy number
    private Map<String, Policy> linkedHashMapPolicies;  // LinkedHashMap to maintain insertion order
    private TreeMap<LocalDate, List<Policy>> treeMapPoliciesByExpiry; // TreeMap to store policies sorted by expiry date

    public InsurancePolicyManagementSystem() {
        this.hashMapPolicies = new HashMap<>();
        this.linkedHashMapPolicies = new LinkedHashMap<>();
        // TreeMap needs a Comparator if the key is not naturally comparable,
        // or if multiple policies can have the same expiry date.
        // Here, we'll store a List of policies for each expiry date to handle duplicates.
        this.treeMapPoliciesByExpiry = new TreeMap<>(); 
    }

    // Method to add a policy to all maps
    public void addPolicy(Policy policy) {
        if (policy == null || policy.getPolicyNumber() == null) {
            System.err.println("Cannot add null policy or policy with null number.");
            return;
        }

        // Add to HashMap
        hashMapPolicies.put(policy.getPolicyNumber(), policy);

        // Add to LinkedHashMap
        linkedHashMapPolicies.put(policy.getPolicyNumber(), policy);

        // Add to TreeMap
        treeMapPoliciesByExpiry.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    // 2. Retrieve and Manipulate Policies

    // Retrieve a policy by its number.
    public Policy retrievePolicyByNumber(String policyNumber) {
        return hashMapPolicies.get(policyNumber); // HashMap is efficient for direct key lookup
    }

    // List all policies expiring within the next 30 days.
    public List<Policy> listPoliciesExpiringSoon(int days) {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(days);

        // Iterate through the TreeMap for efficient date-based filtering
        // The subMap method of TreeMap is very efficient for range queries.
        Map<LocalDate, List<Policy>> relevantPolicies = treeMapPoliciesByExpiry.subMap(today.minusDays(1), true, futureDate, false);

        for (List<Policy> policiesAtDate : relevantPolicies.values()) {
            for (Policy policy : policiesAtDate) {
                // Ensure the policy hasn't already expired and is within the future range
                if (policy.getExpiryDate().isAfter(today) && policy.getExpiryDate().isBefore(futureDate.plusDays(1))) {
                    expiringPolicies.add(policy);
                }
            }
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder.
    public List<Policy> listPoliciesByPolicyholder(String policyholderName) {
        List<Policy> policiesForHolder = new ArrayList<>();
        // Iterate through any of the maps (e.g., HashMap's values)
        for (Policy policy : hashMapPolicies.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                policiesForHolder.add(policy);
            }
        }
        return policiesForHolder;
    }

    // Remove policies that are expired.
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        
        // Use an Iterator for safe removal during iteration
        Iterator<Map.Entry<String, Policy>> hashMapIterator = hashMapPolicies.entrySet().iterator();
        while (hashMapIterator.hasNext()) {
            Policy policy = hashMapIterator.next().getValue();
            if (policy.getExpiryDate().isBefore(today)) {
                hashMapIterator.remove(); // Remove from HashMap

                // Also remove from LinkedHashMap
                linkedHashMapPolicies.remove(policy.getPolicyNumber());

                // Remove from TreeMap
                // Note: Removing from TreeMap is more complex if multiple policies
                // can share the same expiry date. We need to find the specific policy
                // within the list associated with that date and remove it.
                List<Policy> policiesAtExpiryDate = treeMapPoliciesByExpiry.get(policy.getExpiryDate());
                if (policiesAtExpiryDate != null) {
                    policiesAtExpiryDate.remove(policy);
                    if (policiesAtExpiryDate.isEmpty()) {
                        treeMapPoliciesByExpiry.remove(policy.getExpiryDate());
                    }
                }
            }
        }
        System.out.println("Expired policies removed.");
    }

    // Helper method to display policies from a given map
    public void displayPolicies(String title, Map<String, Policy> policiesMap) {
        System.out.println("\n--- " + title + " ---");
        if (policiesMap.isEmpty()) {
            System.out.println("No policies found.");
            return;
        }
        for (Policy policy : policiesMap.values()) {
            System.out.println(policy);
        }
    }

    // Helper method to display policies from the TreeMap (sorted by expiry)
    public void displayPoliciesSortedByExpiry() {
        System.out.println("\n--- Policies Sorted by Expiry Date (TreeMap) ---");
        if (treeMapPoliciesByExpiry.isEmpty()) {
            System.out.println("No policies found.");
            return;
        }
        for (Map.Entry<LocalDate, List<Policy>> entry : treeMapPoliciesByExpiry.entrySet()) {
            for (Policy policy : entry.getValue()) {
                System.out.println(policy);
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        // Add some sample policies
        Policy p1 = new Policy("POL001", "Divyanshu Srivastava", LocalDate.of(2026, 7, 20), "Auto", 750.00);
        Policy p2 = new Policy("POL002", "Alice Johnson", LocalDate.of(2025, 8, 10), "Health", 1200.00); // Expiring soon
        Policy p3 = new Policy("POL003", "Bob Williams", LocalDate.of(2027, 3, 15), "Home", 900.00);
        Policy p4 = new Policy("POL004", "Divyanshu Srivastava", LocalDate.of(2025, 7, 26), "Life", 500.00); // Expiring soon
        Policy p5 = new Policy("POL005", "Charlie Davis", LocalDate.of(2025, 1, 1), "Auto", 600.00); // Expired
        Policy p6 = new Policy("POL006", "Alice Johnson