package main;

import java.util.ArrayList;
import java.util.Objects;


import java.util.Collections;
public class Group {
	private static final int MAX_GROUP_SIZE = 10;
	private String groupName;
	private ArrayList<Student> students = new ArrayList<>();
	public Group(String groupName, ArrayList<Student> students) {
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
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public static int getMaxGroupSize() {
		return MAX_GROUP_SIZE;
	}
	//додаємо студента 
	public void addStudent(Student student) throws GroupOverflowException {
		 if (equivalentStudent(student)) {
		        System.out.println("Student already exists in the group");
		        return;
		    }
		  if (students.size() >= MAX_GROUP_SIZE) {
	            throw new GroupOverflowException("The group is overcrowded");
	        }
		  students.add(student);
	        System.out.println("Added to group");
	    }
	//пошук студента
	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		   for (Student student : students) {
		        if (student != null && student.getLastName().equals(lastName)) {
		            return student;
		        }
		    }
		    throw new StudentNotFoundException("Student not found.");
		}//видалення
	public boolean removeStudentById(int id) {
	    for (Student student : students) {
	        if (student != null && student.getId() == id) {
	            students.remove(student);
	            return true;
	        }
	    }
	    return false;
	} //сортування
	public void sortStudentsByLastName() {
		 Collections.sort(students, new StudantLastNameComparator());
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
        return Objects.hash(groupName, students);
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
		return Objects.equals(groupName, other.groupName) && Objects.equals(students, other.students);
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
