
import java.util.*;

class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

public class ContactManager {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Contact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    displayContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    System.out.println("Exiting Contact Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    private static void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.next();

        Contact newContact = new Contact(name, phoneNumber);
        contacts.add(newContact);

        System.out.println("Contact added successfully!\n");
    }

    private static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.\n");
        } else {
            System.out.println("Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
            System.out.println();
        }
    }

    private static void searchContact() {
        System.out.print("Enter Name to search: ");
        String searchName = scanner.next();
        boolean found = false;

        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(searchName)) {
                System.out.println("Contact found:\n" + contact);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.\n");
        }
    }
}
