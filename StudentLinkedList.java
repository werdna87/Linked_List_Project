import java.util.ArrayList;


public class StudentLinkedList {
	StudentNode head = new StudentNode(new Student("","",0),null);
	public String toString(){
		StudentNode s = head.getNext();
		String str = "";
		while(s!=null){
			str += s.getValue().toString() + "\n";
			s= s.getNext();
		}
		return str;
	}
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
	public boolean correctSpotLastName(StudentNode a, StudentNode current){
		if(a.getValue().getLastName().toString().compareTo(current.getNext().getValue().getLastName().toString())<0){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean correctGPA(StudentNode a, StudentNode current){
		if(a.getValue().getGPA()<current.getNext().getValue().getGPA()){
			return true;
		}
		else{
			return false;
		}
	}
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
	public void sortByAverage(){
		StudentNode temp = head;
		while(temp!=null){
			insertByGPA(temp.getValue().getFirstName(),temp.getValue().getLastName(),temp.getValue().getGPA());
			temp = temp.getNext();
		}
	}
	public static void main(String[] args) throws NoStudentException{
		StudentLinkedList list = new StudentLinkedList();
		list.insertByLastName("Edgars", "Thomas", 89);
		list.insertByLastName("Smith", "Jennifer", 86);
		list.insertByLastName("Umberton", "Harold", 78);
		list.insertByLastName("Martin", "Frank", 60);
		list.insertByLastName("Andrews", "Jeremy", 83);
		list.insertByLastName("Roberts", "Laura", 93);
		list.insertByLastName("Lincoln", "Adele", 85);
		list.insertByLastName("Smith", "Peter", 91);
		list.insertByLastName("Peterson", "Larry", 72);

		System.out.println("The Students in order are:");
		System.out.println(list);
		System.out.println("Frank Martin decided to drop, so the class now has:");
		list.removeStudent("Martin", "Frank");
		System.out.println(list);
		//		StudentLinkedList list2 = new StudentLinkedList();
		//		list2.insertByGPA("Edgars", "Thomas", 89);
		//		list2.insertByGPA("Smith", "Jennifer", 86);
		//		list2.insertByGPA("Umberton", "Harold", 78);
		//		list2.insertByGPA("Martin", "Frank", 60);
		//		list2.insertByGPA("Andrews", "Jeremy", 83);
		//		list2.insertByGPA("Roberts", "Laura", 93);
		//		list2.insertByGPA("Lincoln", "Adele", 85);
		//		list2.insertByGPA("Smith", "Peter", 91);
		//		list2.insertByGPA("Peterson", "Larry", 72);




		list.sortByAverage();
		System.out.println(list);
	}

}
