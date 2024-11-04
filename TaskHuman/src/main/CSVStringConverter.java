package main;

public class CSVStringConverter implements StringConverter {

	@Override
	public String toStringRepresentation(Student student) {
  return student.getName() + "," + student.getLastName() + "," +
               student.getGender() + "," + student.getId() + "," + student.getGroupName();
	}
    @Override
    public Student fromStringRepresentation(String str) {
      String[] fields = str.split(",");
        String name = fields[0];
        String lastName = fields[1];
        Human.Gender gender = Human.Gender.valueOf(fields[2]);
        int id = Integer.parseInt(fields[3]);
        String groupName = fields[4];
        
        return new Student( name, lastName, gender, id, groupName);
   
    }
    
}
