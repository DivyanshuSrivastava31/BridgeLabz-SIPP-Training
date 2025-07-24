import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

// 1. Policy Class
class Policy implements Comparable<Policy> {
    private String policyNumber;
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
    public int compareTo(Policy other) {
        // Sort by expiry date for TreeSet
        return this.expiryDate.compareTo(other.expiryDate);
    }
}

// 2. PolicyManagementSystem
public class PolicyManagementSystem {

    private Set<Policy> hashSetPolicies;
    private Set<Policy> linkedHashSetPolicies;
    private Set<Policy> treeSetPolicies;

    public PolicyManagementSystem() {
        hashSetPolicies = new HashSet<>();
        linkedHashSetPolicies = new LinkedHashSet<>();
        treeSetPolicies = new TreeSet<>();
    }

    // 1. Store Unique Policies
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve Policies: All unique policies
    public Set<Policy> getAllUniquePolicies() {
        return new HashSet<>(hashSetPolicies); // Return a copy
    }

    // Retrieve Policies: Policies expiring soon (within the next 30 days)
    public List<Policy> getPoliciesExpiringSoon(int days) {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysFromNow = today.plusDays(days);

        for (Policy policy : hashSetPolicies) {
            if (policy.getExpiryDate().isAfter(today) && policy.getExpiryDate().isBefore(thirtyDaysFromNow)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    // Retrieve Policies: Policies with a specific coverage type
    public List<Policy> getPoliciesByCoverageType(String coverageType) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Retrieve Policies: Duplicate policies based on policy numbers
    public List<Policy> getDuplicatePolicies() {
        List<Policy> duplicates = new ArrayList<>();
        Set<String> uniquePolicyNumbers = new HashSet<>();
        Set<String> identifiedDuplicates = new HashSet<>();

        for (Policy policy : linkedHashSetPolicies) { // Use linkedHashSet to maintain insertion order for checking
            if (!uniquePolicyNumbers.add(policy.getPolicyNumber())) {
                // If add returns false, it means the policy number was already in the set
                if (identifiedDuplicates.add(policy.getPolicyNumber())) { // Add only once to avoid repeated duplicates
                    duplicates.add(policy);
                }
            }
        }
        return duplicates;
    }


    // 3. Performance Comparison Utility
    public void comparePerformance(List<Policy> policiesToAdd) {
        System.out.println("\n--- Performance Comparison ---");

        // Adding Performance
        System.out.println("\nAdding Policies:");
        long startTime = System.nanoTime();
        for (Policy p : policiesToAdd) {
            new HashSet<>().add(p); // Add to a temporary set to measure specific performance
        }
        long endTime = System.nanoTime();
        System.out.println("HashSet Add Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

        startTime = System.nanoTime();
        for (Policy p : policiesToAdd) {
            new LinkedHashSet<>().add(p);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

        startTime = System.nanoTime();
        for (Policy p : policiesToAdd) {
            new TreeSet<>().add(p);
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet Add Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");


        // Search Performance (for an existing policy)
        if (!policiesToAdd.isEmpty()) {
            Policy policyToSearch = policiesToAdd.get(policiesToAdd.size() / 2); // Search for a middle element
            System.out.println("\nSearching for policy: " + policyToSearch.getPolicyNumber());

            startTime = System.nanoTime();
            hashSetPolicies.contains(policyToSearch);
            endTime = System.nanoTime();
            System.out.println("HashSet Search Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

            startTime = System.nanoTime();
            linkedHashSetPolicies.contains(policyToSearch);
            endTime = System.nanoTime();
            System.out.println("LinkedHashSet Search Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

            startTime = System.nanoTime();
            treeSetPolicies.contains(policyToSearch);
            endTime = System.nanoTime();
            System.out.println("TreeSet Search Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");
        }

        // Removal Performance (for an existing policy)
        if (!policiesToAdd.isEmpty()) {
            Policy policyToRemove = policiesToAdd.get(0); // Remove the first element added
            System.out.println("\nRemoving policy: " + policyToRemove.getPolicyNumber());

            // Create temporary sets for removal test to not affect main system
            Set<Policy> tempHashSet = new HashSet<>(hashSetPolicies);
            Set<Policy> tempLinkedHashSet = new LinkedHashSet<>(linkedHashSetPolicies);
            Set<Policy> tempTreeSet = new TreeSet<>(treeSetPolicies);

            startTime = System.nanoTime();
            tempHashSet.remove(policyToRemove);
            endTime = System.nanoTime();
            System.out.println("HashSet Remove Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

            startTime = System.nanoTime();
            tempLinkedHashSet.remove(policyToRemove);
            endTime = System.nanoTime();
            System.out.println("LinkedHashSet Remove Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");

            startTime = System.nanoTime();
            tempTreeSet.remove(policyToRemove);
            endTime = System.nanoTime();
            System.out.println("TreeSet Remove Time: " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " ms");
        }
    }


    public static void main(String[] args) {
        PolicyManagementSystem system = new PolicyManagementSystem();

        // Sample Policies
        Policy p1 = new Policy("P001", "Alice Smith", LocalDate.of(2025, 12, 1), "Auto", 500.00);
        Policy p2 = new Policy("P002", "Bob Johnson", LocalDate.of(2024, 8, 15), "Health", 1200.00);
        Policy p3 = new Policy("P003", "Charlie Brown",