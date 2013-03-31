
public class Student {
	
	private String firstName;
	private String lastName;
	private int gpa;
	
	public Student(String lName, String fName, int gpa){
		lastName = lName;
		firstName = fName;
		this.gpa = gpa;
	}
	
	public String getFirstName(){return firstName;}
	public String getLastName(){return lastName;}
	public int getGPA(){return gpa;}
	
	public void setFirstName(String fName){firstName = fName;}
	public void setLastName(String lName){lastName = lName;}
	public void setGPA(int gpa){this.gpa = gpa;}
	
	public String toString(){
		return firstName + " " + lastName + ", gpa = " + gpa;
	}

}
