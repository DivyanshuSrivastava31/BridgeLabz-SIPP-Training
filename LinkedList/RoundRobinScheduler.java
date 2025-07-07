// Node class
class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

// Circular Linked List class
public class RoundRobinScheduler {
    ProcessNode head = null;
    ProcessNode tail = null;

    // Add process at end
    void addProcess(int pid, int burst, int priority) {
        ProcessNode newProcess = new ProcessNode(pid, burst, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    // Remove process by ID
    void removeProcess(int pid) {
        if (head == null) return;

        ProcessNode current = head;
        ProcessNode prev = tail;

        do {
            if (current.processId == pid) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Display process list
    void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        ProcessNode current = head;
        System.out.println("Current Process Queue:");
        do {
            System.out.println("Process ID: " + current.processId + ", Remaining Time: " +
                               current.remainingTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    // Simulate Round Robin Scheduling
    void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        int processCount = 0;
        double totalWaitingTime = 0, totalTurnaroundTime = 0;

        ProcessNode current = head;

        // Count processes
        do {
            processCount++;
            current = current.next;
        } while (current != head);

        current = head;
        System.out.println("Starting Round Robin Scheduling with Time Quantum = " + timeQuantum);

        while (head != null) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                System.out.println("Executing Process " + current.processId + " for " + execTime + " units");
                currentTime += execTime;
                current.remainingTime -= execTime;

                if (current.remainingTime == 0) {
                    current.turnaroundTime = currentTime;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                    totalWaitingTime += current.waitingTime;
                    totalTurnaroundTime += current.turnaroundTime;

                    System.out.println("Process " + current.processId + " completed. TAT = " + current.turnaroundTime + ", WT = " + current.waitingTime);
                    removeProcess(current.processId);
                }
            }

            // Move to next only if not empty
            current = current.next != null ? current.next : head;

            displayProcesses();
        }

        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWaitingTime / processCount);
        System.out.printf("Average Turnaround Time: %.2f\n", totalTurnaroundTime / processCount);
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Add processes
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 4, 2);
        scheduler.addProcess(3, 6, 3);
        scheduler.addProcess(4, 8, 2);

        // Display initial list
        scheduler.displayProcesses();
        System.out.println();

        // Run simulation
        scheduler.simulateRoundRobin(3); // Time Quantum = 3
    }
}
