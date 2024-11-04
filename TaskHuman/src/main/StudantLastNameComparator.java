package main;

import java.util.Comparator;

public class StudantLastNameComparator implements Comparator<Student> {

	   @Override
	    public int compare(Student student1, Student student2) {
	        if (student1 == null || student2 == null) {
	            return 0; 
	        }
	        return student1.getLastName().compareTo(student2.getLastName());
	    }
	}
