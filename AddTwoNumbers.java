package leetcode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// creating nodes linkedlist1
		ListNode list1_0 = new ListNode(2);
		ListNode list1_1 = new ListNode(4);
		ListNode list1_2 = new ListNode(3);
		
		//adding links to the next elements
		list1_0.next = list1_1;
		list1_1.next = list1_2;
		
		//creating nodes for linkedlist2
		ListNode list2_0 = new ListNode(5);
		ListNode list2_1 = new ListNode(6);
		ListNode list2_2 = new ListNode(4);
		
		//adding links to the next elements
		list2_0.next = list2_1;
		list2_1.next = list2_2;
		
		//driver code for printing all elements of linkedList
		displayLinkedList(list1_0);
		System.out.println("\n\n\n");
		displayLinkedList(list2_0);
		
		//Adding elements of two linkedlist
		System.out.println("\n\n\n");
		while(list1_0 != null){
			System.out.println(list1_0.val  +list2_0.val);
			list1_0 = list1_0.next;	// why not curly braces ()
			list2_0 = list2_0.next;
			
		}
	}

	/*
	 * printing all elements of linkedList
	 */
	static void displayLinkedList(ListNode rootNode){
		while(rootNode != null){
			rootNode.printNodeVale();
			rootNode = rootNode.next;
		}
	}
	
	
}

// [1] -> [2] -> [3]
//Encapsulation = wrapping up data in single units 
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
	
	void printNodeVale(){
		System.out.println(val);
	}
}
