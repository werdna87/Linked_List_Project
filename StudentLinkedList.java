import java.util.ArrayList;
/**
 * The Class StudentLinkedList.
 * By Andrew Borghesani
 */
public class StudentLinkedList {
	
	/** The head. */
	StudentNode head = new StudentNode(new Student("","",0),null);
	
	/* 
	 * prints the students out in whatever order they are in
	 */
	public String toString(){
		StudentNode s = head.getNext();
		String str = "";
		while(s!=null){
			str += s.getValue().toString() + "\n";
			s= s.getNext();
		}
		return str;
	}
	
	/**
	 * Insert by last name.
	 *
	 *Inserts Students into the linked list by last name
	 * @param fName the f name
	 * @param lName the l name
	 * @param GPA the gpa
	 */
	public void insertByLastName(String fName, String lName, int GPA){
		StudentNode s = new StudentNode(new Student(fName,lName,GPA));
		StudentNode current = head;
		for(;;){
			if(current.getNext()==null){
				current.setNext(s);
				return;
			}
			else{

				if(correctSpotLastName(s,current)){
					StudentNode temp = current.getNext();
					current.setNext(s);
					s.setNext(temp);
					return;
				}
				else{
					current = current.getNext();
				}
			}
		}
	}
	
	/**
	 * Insert by last name.
	 *
	 *Inserts a student object into the linked list by last name, must be sorted by last name to begin with
	 *
	 * @param s the s
	 */
	public void insertByLastName(Student s){
		insertByLastName(s.getFirstName(),s.getLastName(),s.getGPA());

	}
	
	/**
	 * Correct spot last name.
	 * 
	 * Checks to see if the name is in the correct spot in the list, helper method to sortByLastName
	 *
	 * @param a the a
	 * @param current the current
	 * @return true, if successful
	 */
	public boolean correctSpotLastName(StudentNode a, StudentNode current){
		if(a.getValue().getLastName().toString().compareTo(current.getNext().getValue().getLastName().toString())<0){
			return true;
		}
		else if(a.getValue().getLastName().toString().compareTo(current.getNext().getValue().getLastName().toString())==0){
			if(a.getValue().getFirstName().toString().compareTo(current.getNext().getValue().getFirstName().toString())<0){
			return true;
			}
			else return false;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Correct gpa.
	 * 
	 * Checks to see if the student is in the right place when sorting by GPA, helper method to sortByGPA
	 *
	 * @param a the a
	 * @param current the current
	 * @return true, if successful
	 */
	public boolean correctGPA(StudentNode a, StudentNode current){
		if(a.getValue().getGPA()<current.getNext().getValue().getGPA()){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Removes the student.
	 * 
	 * Removes a student from the linked list
	 *
	 * @param fName the f name
	 * @param lName the l name
	 * @return the student node
	 * @throws NoStudentException the no student exception
	 */
	public StudentNode removeStudent(String fName, String lName) throws NoStudentException{
		StudentNode checker = new StudentNode(new Student(fName, lName, 0));
		StudentNode current = head.getNext();
		StudentNode previous = head;
		while(current.getNext()!=null){
			if(checker.getValue().getFirstName().equals(current.getValue().getFirstName()) && checker.getValue().getLastName().equals(current.getValue().getLastName())){
				previous.setNext(current.getNext());
				return current;
			}
			else{
				current = current.getNext();
				previous = previous.getNext();
			}
		}
		//		return null;
		throw new NoStudentException();
	}
	
	/**
	 * Insert by gpa.
	 * 
	 * Inserts a Student into the linked list based on GPA, list must be sorted by GPA to work correctly
	 *
	 * @param fName the f name
	 * @param lName the l name
	 * @param GPA the gpa
	 */
	public void insertByGPA(String fName, String lName, int GPA){
		StudentNode s = new StudentNode(new Student(fName,lName,GPA));
		StudentNode current = head;
		for(;;){
			if(current.getNext()==null){
				current.setNext(s);
				return;
			}
			else{

				if(correctGPA(s,current)){
					StudentNode temp = current.getNext();
					current.setNext(s);
					s.setNext(temp);
					return;
				}
				else{
					current = current.getNext();
				}
			}
		}
	}
	
	/**
	 * Insert by gpa.
	 * 
	 * Inserts a Student into the linked list based on GPA, list must be sorted by GPA to work correctly
	 *
	 * @param s the s
	 */
	public void insertByGPA(Student s){
		insertByGPA(s.getFirstName(),s.getLastName(),s.getGPA());
	}

	/**
	 * Sort by average.
	 * 
	 * Sorts the list based on GPA
	 */
	public void sortByAverage(){
		StudentNode temp = head.getNext();
		head =  new StudentNode(new Student("","",0));
		while(temp!=null){
			insertByGPA(temp.getValue());
			temp = (temp.getNext());
		}
	}
	
	/**
	 * Sort by last name.
	 * 
	 * sorts the list based on last name
	 */
	public void sortByLastName(){
		StudentNode temp = head.getNext();
		StudentNode newHead = new StudentNode(new Student("","",0));
		head = newHead;
		while(temp!=null){
			insertByLastName(temp.getValue());
			temp = (temp.getNext());
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws NoStudentException the no student exception
	 */
	public static void main(String[] args) throws NoStudentException{
		StudentLinkedList list = new StudentLinkedList();
		list.insertByLastName("Edgars", "Thomas", 89);
		list.insertByLastName("Umberton", "Harold", 78);
		list.insertByLastName("Martin", "Frank", 60);
		list.insertByLastName("Andrews", "Jeremy", 83);
		list.insertByLastName("Roberts", "Laura", 93);
		list.insertByLastName("Lincoln", "Adele", 85);
		list.insertByLastName("Smith", "Peter", 91);
		list.insertByLastName("Peterson", "Larry", 72);
		list.insertByLastName("Smith", "Jennifer", 86);


		System.out.println("The Students in order are:");
		System.out.println(list);
		System.out.println("Frank Martin decided to drop, so the class now has:");
		list.removeStudent("Martin", "Frank");
		System.out.println(list);
		System.out.println("Sorted by GPA, the class is:");
		list.sortByAverage();
		System.out.println(list);
		System.out.println("Alice Martin joins the class with an average of 96 so the class now has:");
		list.insertByGPA("Martin","Alice",96);
		System.out.println(list);
		System.out.println("Sorted by last name, the class is:");
		list.sortByLastName();
		System.out.println(list);

	}

}
/*
 * The Students in order are:
Jeremy Andrews, gpa = 83
Thomas Edgars, gpa = 89
Adele Lincoln, gpa = 85
Frank Martin, gpa = 60
Larry Peterson, gpa = 72
Laura Roberts, gpa = 93
Jennifer Smith, gpa = 86
Peter Smith, gpa = 91
Harold Umberton, gpa = 78

Frank Martin decided to drop, so the class now has:
Jeremy Andrews, gpa = 83
Thomas Edgars, gpa = 89
Adele Lincoln, gpa = 85
Larry Peterson, gpa = 72
Laura Roberts, gpa = 93
Jennifer Smith, gpa = 86
Peter Smith, gpa = 91
Harold Umberton, gpa = 78

Sorted by GPA, the class is:
Peterson Larry, gpa = 72
Umberton Harold, gpa = 78
Andrews Jeremy, gpa = 83
Lincoln Adele, gpa = 85
Smith Jennifer, gpa = 86
Edgars Thomas, gpa = 89
Smith Peter, gpa = 91
Roberts Laura, gpa = 93

Alice Martin joins the class with an average of 96 so the class now has:
Peterson Larry, gpa = 72
Umberton Harold, gpa = 78
Andrews Jeremy, gpa = 83
Lincoln Adele, gpa = 85
Smith Jennifer, gpa = 86
Edgars Thomas, gpa = 89
Smith Peter, gpa = 91
Roberts Laura, gpa = 93
Alice Martin, gpa = 96

Sorted by last name, the class is:
Martin Alice, gpa = 96
Jeremy Andrews, gpa = 83
Thomas Edgars, gpa = 89
Adele Lincoln, gpa = 85
Larry Peterson, gpa = 72
Laura Roberts, gpa = 93
Jennifer Smith, gpa = 86
Peter Smith, gpa = 91
Harold Umberton, gpa = 78

*/
