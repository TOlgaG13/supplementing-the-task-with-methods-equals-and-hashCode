package main;

import java.util.Comparator;
import java.util.Objects;
import java.util.Arrays;

public class Group {
	private String groupName;
	private Student[] students = new Student[10];

	public Group(String groupName, Student[] students) {
		super();
		this.groupName = groupName;
		this.students = students;
	}

	public Group() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudens() {
		return students;
	}

	public void setStudens(Student[] students) {
		this.students = students;
	}

	public void addStudent(Student student) throws GroupOverflowException {
		 if (equivalentStudent(student)) {
		        System.out.println("Student already exists in the group");
		        return;
		    }
		
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				System.out.println("add to group");
				return;
			}
		}
		throw new GroupOverflowException("the group is overcrowded");
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getLastName().equals(lastName)) {
					return students[i];
				}
			}
		}
		throw new StudentNotFoundException("Don't found student.");
	}

	public boolean removeStudentById(int id) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getId() == id) {
					students[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	public void sortStudentsByLastName() {
		Arrays.sort(students, new StudantLastNameComparator());
	}

	@Override
	public String toString() {
		sortStudentsByLastName();
		StringBuilder list = new StringBuilder("Group: " + groupName + System.lineSeparator());
		for (Student student : students) {
			if (student != null) {
				list.append(student).append(System.lineSeparator());
			}
		}
		return list.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(students);
		result = prime * result + Objects.hash(groupName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Arrays.equals(students, other.students);
	}
	public boolean equivalentStudent(Student student) {
		for(Student s: students) {
		if (s != null && s.equals(student)) {
			 return true;
		}
	}
	 return false;
}
}