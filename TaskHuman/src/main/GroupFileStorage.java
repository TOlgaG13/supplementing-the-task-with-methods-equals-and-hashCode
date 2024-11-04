package main;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class GroupFileStorage {
	 public void saveGroupToCSV(Group group, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Student student : group.getStudens()) {
                writer.write(studentToCSV(student));
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	 private String studentToCSV(Student student) {
	        return student.getLastName() + "," +
	               student.getName() + "," +
	               student.getId() + "," +
	               student.getGroupName(); 
	 }

	 public Group loadGroupFromCSV(File file) throws IOException {
		    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		        String temp;
		        Group result = new Group();
		        CSVStringConverter cnvrt = new CSVStringConverter();

		        while ((temp = br.readLine()) != null) {
		            if (result.getStudens().length >= 10) {
		                System.out.println("Група переповнена");
		                break;
		            }
		            try {
		                Student student = cnvrt.fromStringRepresentation(temp);
		                result.addStudent(student);
		            } catch (GroupOverflowException e) {
		                System.out.println("Ошибка: группа переполнена при добавлении студента " + temp);
		            } catch (IllegalArgumentException e) {
		                System.out.println("Ошибка формата CSV: " + temp);
		            }
		        }
		        return result;
		    }
	 }
	 public File findFileByGroupName(String groupName, File workFolder) {
	        String fileName = groupName + ".csv"; 
	        File fileToFind = new File(workFolder, fileName); 

	        
	        if (fileToFind.exists() && fileToFind.isFile()) {
	            return fileToFind; 
	        } else {
	            System.out.println("Файл не знайдено: " + fileToFind.getAbsolutePath());
	            return null; 
	        }
	    }
	}
	 