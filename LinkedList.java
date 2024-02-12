

//I have made it implements comparable becuase I want the data type of the node be a linkedList
public class LinkedList<T extends Comparable<T>> {
	public Node head;
	public Node dummy = new Node(null); // avoid null pointer exception, has no data in it

	public LinkedList() {
		head = dummy;
	}

	// list length
	public int length() {
		Node curr;
		curr = head;
		int len = 0;
		while (curr != null) {
			len++;
			curr = curr.getNext();
		}
		return len - 1; // dummy is not counted
	}

	// Insertsorted a Node to the list, one case because of dummyhead
	public void insertSorted(T data) {
		Node<T> newNode = new Node<>(data);
		Node<T> curr = head;
		Node<T> prev = dummy;

		while (curr != null) {
			if (curr.getData() == null) {
				newNode.setNext(prev.getNext());
				prev.setNext(newNode);
				return; // Inserted the node, exit the if statement
			} else if (curr.getData().compareTo(newNode.getData()) < 0) {
				newNode.setNext(curr);
				prev.setNext(newNode);
				return; // Inserted the node, exit the if statement
			}

			prev = curr;
			curr = curr.getNext();
		}

		// If we reached here, the new node should be inserted at the end
		prev.setNext(newNode);
	}

	public boolean search(T data) {
		Node curr;
		curr = head;
		while (curr != null) {
			if (curr.getData() == null && curr.getNext() != null) {
				curr = curr.getNext();
			} else if (curr.getData().equals(data)) {
				return true;
			} else
				curr = curr.getNext();
		}
		return false;

	}

	public void insertFirst(T data) {
		Node newnode = new Node(data);
		if (dummy.getNext() == null) {
			dummy.setNext(newnode);
		} else {
			newnode.setNext(dummy.getNext());
			dummy.setNext(newnode);
		}
	}

	public void traverse() {
		Node curr = head;
		while (curr != null) {
			if (curr.getData() == null & curr.getNext() != null) {
				curr = curr.getNext();
			} else {
				System.out.println(curr.toString());
				curr = curr.getNext();
			}
		}
	}

	public void delete(T data) {
		Node curr = head;
		Node prev = dummy;
		while (curr != null) {
			if (curr.getData() == null && curr.getNext() != null) {
				prev = curr;
				curr = curr.getNext();
			} else if (curr.getData() != null && curr.getData().equals(data)) {
				prev.setNext(curr.getNext());
				curr = curr.getNext();
			} else {
				prev = curr;
				curr = curr.getNext();
			}
		}
	}

//	public LinkedList mergeSortedLinekdList(LinkedList list1,LinkedList list2 ) {
//		LinkedList mergedList = new LinkedList();
//		
//		if(list1.head.getData().compareTo(list2.head.getData())<0) {
//			mergedList.insertFirst(list1.head);
//			Node curr1 = list1.head;
//			Node curr2= list2.head;
//			while(curr1!=null) {
//				if(curr1.getData().compareTo(curr2.getData())<0) {
//					mergedList.insertSorted(curr1);
//				}
//				else {
//					mergedList.insertSorted(curr2);
//				}
//				curr1= curr1.getNext();
//				curr2 = curr2.getNext();
//			}
//		}
//		else if(list1.head.getData().compareTo(list2.head.getData())>0) {
//			mergedList.insertFirst(list2.head);
//			Node curr1 = list1.head;
//			Node curr2= list2.head;
//			while(curr2!=null) {
//				if(curr2.getData().compareTo(curr1.getData())<0) {
//					mergedList.insertSorted(curr2);
//				}
//				else {
//					mergedList.insertSorted(curr1);
//				}
//				curr1= curr1.getNext();
//				curr2 = curr2.getNext();
//			}
//		}
//		return mergedList;
//	}
	
	public void insertAtEnd(T data) {
	    Node node = new Node(data);
	    if (head == null || head.getData() == null) { // Check if the list is empty
	        head = node;
	    } else {
	        Node curr = head;
	        // Traverse to the second-to-last node
	        while (curr.getNext() != null) {
	            curr = curr.getNext();
	        }
	        // Now curr is the last node, set its next to the new node
	        curr.setNext(node);
	    }
	}
	
	public LinkedList mergeSortedLinkedList(LinkedList list1, LinkedList list2) {
	    LinkedList mergedList = new LinkedList();

	    Node curr1 = list1.head;
	    Node curr2 = list2.head;

	    while (curr1 != null && curr2 != null) {
	        if (curr1.getData().compareTo(curr2.getData()) < 0) {
	            mergedList.insertAtEnd(new Node(curr1.getData())); // Assuming insertAtEnd inserts a new Node
	            curr1 = curr1.getNext();
	        } else {
	            mergedList.insertAtEnd(new Node(curr2.getData())); // Assuming insertAtEnd inserts a new Node
	            curr2 = curr2.getNext();
	        }
	    }

	    // Append remaining elements
	    while (curr1 != null) {
	        mergedList.insertAtEnd(new Node(curr1.getData()));
	        curr1 = curr1.getNext();
	    }
	    while (curr2 != null) {
	        mergedList.insertAtEnd(new Node(curr2.getData()));
	        curr2 = curr2.getNext();
	    }

	    return mergedList;
	}

	
}







