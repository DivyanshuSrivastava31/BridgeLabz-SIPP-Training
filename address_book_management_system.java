import java.io.*;
import java.util.*;

// Contact class with Generics
class Contact<T> implements Serializable {
    private String name;
    private String phone;
    private String email;
    private T address;

    public Contact(String name, String phone, String email, T address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public T getAddress() { return address; }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone +
               ", Email: " + email + ", Address: " + address;
    }
}

// AddressBook class
class AddressBook<T> {
    private Map<String, Contact<T>> contacts = new HashMap<>();

    public void addContact(Contact<T> contact) {
        contacts.put(contact.getPhone(), contact);
    }

    public void removeContact(String phone) {
        contacts.remove(phone);
    }

    public List<Contact<T>> searchByName(String name) {
        List<Contact<T>> result = new ArrayList<>();
        for (Contact<T> c : contacts.values()) {
            if (c.getName().equalsIgnoreCase(name)) {
                result.add(c);
            }
        }
        return result;
    }

    public Contact<T> searchByPhone(String phone) {
        return contacts.get(phone);
    }

    public List<Contact<T>> listAllContacts() {
        return new ArrayList<>(contacts.values());
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(contacts);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            contacts = (Map<String, Contact<T>>) in.readObject();
        }
    }

    public boolean hasSameAddress(Contact<T> c1, Contact<T> c2) {
        return c1.getAddress().equals(c2.getAddress());
    }

    public List<Contact<T>> sortByName() {
        List<Contact<T>> list = listAllContacts();
        list.sort(Comparator.comparing(Contact::getName));
        return list;
    }

    public List<Contact<T>> sortByPhone() {
        List<Contact<T>> list = listAllContacts();
        list.sort(Comparator.comparing(Contact::getPhone));
        return list;
    }
}

// Main class to test the system
public class AddressBookSystem {
    public static void main(String[] args) {
        AddressBook<String> book = new AddressBook<>();

        Contact<String> c1 = new Contact<>("Alice", "123", "alice@example.com", "123 Main St");
        Contact<String> c2 = new Contact<>("Bob", "456", "bob@example.com", "456 Main St");
        Contact<String> c3 = new Contact<>("Charlie", "789", "charlie@example.com", "123 Main St");

        book.addContact(c1);
        book.addContact(c2);
        book.addContact(c3);

        System.out.println("📋 All Contacts:");
        book.listAllContacts().forEach(System.out::println);

        System.out.println("\n🔍 Search by Name: Alice");
        book.searchByName("Alice").forEach(System.out::println);

        System.out.println("\n🔗 Do Alice and Charlie share the same address?");
        System.out.println("Answer: " + book.hasSameAddress(c1, c3));

        System.out.println("\n📊 Sorted by Name:");
        book.sortByName().forEach(System.out::println);

        System.out.println("\n📊 Sorted by Phone:");
        book.sortByPhone().forEach(System.out::println);

        try {
            String filename = "contacts.dat";
            book.saveToFile(filename);
            System.out.println("\n💾 Contacts saved to file: " + filename);

            AddressBook<String> loadedBook = new AddressBook<>();
            loadedBook.loadFromFile(filename);
            System.out.println("\n📂 Contacts loaded from file:");
            loadedBook.listAllContacts().forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
