package main;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student("Viktor", "Nekiphorow", Human.Gender.MALE, 1, "Group");
		Student student2 = new Student("Oleg", "Rozochkin", Human.Gender.MALE, 3, "Group");
		Student student3 = new Student("Martiz", "Karpenko", Human.Gender.MALE, 4, "Group");
		Student student4 = new Student("Melissa", "Sichkar", Human.Gender.FEMALE, 2, "Group");
		Student student5 = new Student("Erika", "Mayorova", Human.Gender.FEMALE, 5, "Group");
		Student student6 = new Student("Eudora", "Tretiak", Human.Gender.FEMALE, 6, "Group");
		Student student7 = new Student("Veronika", "Ulmasova", Human.Gender.FEMALE, 7, "Group");
		Student student8 = new Student("Barts", "Ustinov", Human.Gender.MALE, 8, "Group");
		Student student9 = new Student("Aurora", "Novikova", Human.Gender.FEMALE, 9, "Group");
		Student student10 = new Student("Enrike", "Nesterenko", Human.Gender.MALE, 10, "Group");
		Student student11 = new Student("Vera", "Meshko", Human.Gender.FEMALE, 11, "Group");

		Group group = new Group();
		try {
			group.addStudent(student1);
			group.addStudent(student2);
			group.addStudent(student3);
			group.addStudent(student4);
			group.addStudent(student5);
			group.addStudent(student6);
			group.addStudent(student7);
			group.addStudent(student8);
			group.addStudent(student9);
			group.addStudent(student10);
			group.addStudent(student11);
		} catch (GroupOverflowException e) {
			System.out.println(e.getMessage());

			try {
				System.out.println(group.searchStudentByLastName("Simonenko"));
			} catch (StudentNotFoundException ae) {
				System.out.println(ae.getMessage());
			}
			System.out.println();
			System.out.println(group.removeStudentById(7));

			System.out.println(group);
		}
		StudentInput studentInput = new StudentInput();
		try {
			Student newStudent = studentInput.readStudentFromKeyboard();
			group.addStudent(newStudent);
		} catch (GroupOverflowException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(group);

		Student student = new Student("Joe", "Santiago", Human.Gender.MALE, 13, "Group");
		CSVStringConverter converter = new CSVStringConverter();

		String csv = converter.toStringRepresentation(student);
		System.out.println(csv);

		Student newStudent = converter.fromStringRepresentation(csv);
		System.out.println(newStudent);

		GroupFileStorage storage = new GroupFileStorage();
		String filePath = "group.csv";
		storage.saveGroupToCSV(group, filePath);

		System.out.println("Group save in file " + filePath);

//
		GroupFileStorage storage1 = new GroupFileStorage();
		File file = new File("group.csv");

		try {
			Group loadedGroup = storage1.loadGroupFromCSV(file);
			System.out.println("Группа загружена из файла:");
			System.out.println(loadedGroup);
		} catch (IOException e) {
			System.out.println("Ошибка чтения файла: " + e.getMessage());

		}
		GroupFileStorage storage2 = new GroupFileStorage();
		File workFolder = new File("D:\\Java 11.09.2024\\TaskHuman");
		String groupName = "Group";

		File foundFile = storage.findFileByGroupName(groupName, workFolder);
		if (foundFile != null) {
			System.out.println("Знайдено файл: " + foundFile.getAbsolutePath());
		} else {
			System.out.println("Файл не знайдено.");
		}
		System.out.println(student1.toString());
		System.out.println(student2.toString());
		
		System.out.println(student1 == student2);
		System.out.println(student1.equals(student2));

		System.out.println(student1.hashCode());
		System.out.println(student2.hashCode());
	}
}
