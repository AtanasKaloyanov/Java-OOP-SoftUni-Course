package T12DesignPatterns.Exercise.P04Phonebook;

import java.util.*;

public class Main {

    private static final String CREATE_COMMAND = "CREATE";
    private static final String CONTACT_INFO_COMMAND = "INFO";
    private static final String DELETE_CONTACT_COMMAND = "DELETE";
    private static final String PHONEBOOK_COMMAND = "PHONEBOOK";
    private static final String END_COMMAND = "END";

    public static void main(String[] args) {
        // 1. Info reading:
        Scanner scanner = new Scanner(System.in);
        List<String> contacts = readContactInfo(scanner);
        String name = contacts.get(0);
        String number = contacts.get(1);
        String company = contacts.get(2);
        String title = contacts.get(3);
        String email = contacts.get(4);
        String website = contacts.get(5);
        String birthday = contacts.get(6);

        // 2. Contact creating:
        Contact contact = new Contact(name, number)
                .withCompany(company)
                .withTitle(title)
                .withEmail(email)
                .withWebsite(website)
                .withBirthDay(birthday)
                .build();

        // 3. Final printing:
        System.out.println(contact.toString());
    }

    private static List<String> readContactInfo(Scanner input) {
        List<String> contactInfo = new ArrayList<>();

        System.out.print("Name: ");
        contactInfo.add(input.nextLine());

        System.out.print("Number: ");
        contactInfo.add(input.nextLine());

        System.out.print("Company: ");
        contactInfo.add(input.nextLine());

        System.out.print("Title: ");
        contactInfo.add(input.nextLine());

        System.out.print("Email: ");
        contactInfo.add(input.nextLine());

        System.out.print("Website: ");
        contactInfo.add(input.nextLine());

        System.out.print("Birthday: ");
        contactInfo.add(input.nextLine());

        return contactInfo;
    }
}
