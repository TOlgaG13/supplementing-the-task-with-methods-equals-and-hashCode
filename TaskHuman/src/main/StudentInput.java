package main;
import java.util.Scanner;
public class StudentInput {
	private Scanner scanner;

    public StudentInput() {
        scanner = new Scanner(System.in);
    }
    public Student readStudentFromKeyboard() {
        System.out.print("Input name student's: ");
        String firstName = scanner.nextLine();

        System.out.print("Input lastName student's: ");
        String lastName = scanner.nextLine();

        System.out.print("Input gender student's (MALE/FEMALE): ");
        String genderInput = scanner.nextLine();
        Human.Gender gender = Human.Gender.valueOf(genderInput.toUpperCase());

        System.out.print("Input Id student's: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Input group student's ");
        String group = scanner.nextLine();
        
        return new Student(firstName, lastName, gender, id, group);
    }
}
