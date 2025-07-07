import java.util.ArrayList;

// Node class for each user
class UserNode {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

// Singly Linked List for managing users
public class SocialMediaManager {
    UserNode head;

    // Add a new user
    void addUser(int userId, String name, int age) {
        UserNode user = new UserNode(userId, name, age);
        if (head == null) {
            head = user;
        } else {
            UserNode current = head;
            while (current.next != null)
                current = current.next;
            current.next = user;
        }
    }

    // Search user by ID
    UserNode findUserById(int userId) {
        UserNode current = head;
        while (current != null) {
            if (current.userId == userId) return current;
            current = current.next;
        }
        return null;
    }

    // Search user by name
    void searchUser(String name) {
        UserNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID = " + current.userId + ", Name = " + current.name + ", Age = " + current.age);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No user found with name: " + name);
    }

    // Add friend connection (bidirectional)
    void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both user IDs not found.");
            return;
        }

        if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
        if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);

        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Remove friend connection (bidirectional)
    void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both user IDs not found.");
            return;
        }

        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Display friends of a user
    void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        if (user.friendIds.isEmpty()) {
            System.out.println("No friends.");
            return;
        }

        for (int friendId : user.friendIds) {
            UserNode friend = findUserById(friendId);
            if (friend != null) {
                System.out.println("-> " + friend.name + " (ID: " + friend.userId + ")");
            }
        }
    }

    // Find mutual friends between two users
    void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual Friends of " + user1.name + " and " + user2.name + ":");
        boolean hasMutual = false;
        for (int id : user1.friendIds) {
            if (user2.friendIds.contains(id)) {
                UserNode mutual = findUserById(id);
                if (mutual != null) {
                    System.out.println("-> " + mutual.name + " (ID: " + mutual.userId + ")");
                    hasMutual = true;
                }
            }
        }
        if (!hasMutual) System.out.println("No mutual friends found.");
    }

    // Count number of friends for each user
    void countFriends() {
        UserNode current = head;
        while (current != null) {
            System.out.println(current.name + " has " + current.friendIds.size() + " friend(s).");
            current = current.next;
        }
    }

    // Display all users
    void displayAllUsers() {
        UserNode current = head;
        while (current != null) {
            System.out.println("User: " + current.name + ", ID: " + current.userId + ", Age: " + current.age);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaManager sm = new SocialMediaManager();

        // Add users
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 28);
        sm.addUser(4, "Diana", 22);

        // Display all users
        System.out.println("\nAll Users:");
        sm.displayAllUsers();

        // Add friend connections
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(3, 4);

        // Display friends
        System.out.println("\nFriend Lists:");
        sm.displayFriends(1);
        sm.displayFriends(3);

        // Find mutual friends
        System.out.println("\nMutual Friends:");
        sm.findMutualFriends(1, 3);

        // Remove friend
        System.out.println("\nRemoving Friend Connection:");
        sm.removeFriendConnection(1, 3);
        sm.displayFriends(1);

        // Count friends
        System.out.println("\nFriend Counts:");
        sm.countFriends();

        // Search user
        System.out.println("\nSearch Results:");
        sm.searchUser("Charlie");
        sm.searchUser("Zoe");
    }
}
