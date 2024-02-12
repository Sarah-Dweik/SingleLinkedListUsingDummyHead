
public class driver {

	public static void main(String[]args) {
//		BackLinkedlist list = new BackLinkedlist();
//		list.insertLast(49);
//		list.insertLast(33);
//		list.insertLast(40);
//		
//		System.out.println(list.getfront());
		
//		System.out.println("basic linkedlist test, with no back");
		LinkedList list = new LinkedList();
//		list.insertFirst(40);
//		list.insertFirst(50);
//		list.insertFirst(60);
//		list.insertFirst(80);
//		list.traverse();
		
		System.out.println("basic linkelist test, with no back, add last");
		list.insertAtEnd(30);
		list.insertAtEnd(40);
		list.insertAtEnd(55);
		list.traverse();

	}
}
