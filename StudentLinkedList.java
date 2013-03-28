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
		StudentNode s = new StudentNode((fName,lName,GPA);
		StudentNode temp = head;
		for(;;){
			if(head.getNext()==null){
				StudentNode node = new StudentNode(s,null);
				head.setNext(node);
				break;
			}
			else{
				if(temp.getNext() == null){
					StudentNode node = new StudentNode(s,null);
					temp.setNext(node);
					break;
				}
				if(correctSpot(s))
				temp = temp.getNext();
			}
		}
	}
	public boolean correctSpot(StudentNode a){
		if(a.getValue().getLastName().toString().compareTo(a.getNext().getValue().getLastName().toString())>0){
			return true;
		}
		else{
			return false;
		}
	}
	public Student removeStudent(String fName, String lName){
		return null;
	}
	public void sortByAverage(){

	}
	public static void main(String[] args){
		StudentLinkedList list = new StudentLinkedList();
		list.insertByLastName("Edgars", "Thomas", 89);
		list.insertByLastName("Edgars", "Thomas", 89);
		list.insertByLastName("Edgars", "Thomas", 89);
		list.insertByLastName("Edgars", "Thomas", 89);
		list.insertByLastName("Edgars", "Thomas", 89);

		System.out.println(list);
	}

}
