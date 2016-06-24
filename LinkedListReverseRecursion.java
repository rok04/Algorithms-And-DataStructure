public class LinkedList {

	static node head;

	class node {
		int data;
		node next;
		node prev;

		node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public static void print(node head) {
		while (head != null) {
			System.out.println(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList link = new LinkedList();
		link.head = link.new node(1);
		link.head.next = link.new node(2);
		link.head.next.next = link.new node(3);
		link.head.next.next.next = link.new node(4);
		link.head.next.next.next.next = link.new node(5);
		link.head.next.next.next.next.next = link.new node(6);
		link.head.next.next.next.next.next.next = link.new node(7);
		link.head.next.next.next.next.next.next.next = link.new node(8);
		print(head);
		reverseMe(head);
		print(head);
	}

	public static void reverseMe(node head) {
		if (head == null)
			return;
		else if (head.next == null)
			return;
		else {
			node prev = head;
			node curr = head.next;
			node temp = head.next.next;
			prev.next = null;
			curr.next = prev;
			head = reverse(temp, curr);

		}
	}

	public static node reverse(node curr, node prev) {
		if (curr == null) {
			head = prev;
			return prev;
		}
		node temp = curr.next;
		curr.next = prev;
		return reverse(temp, curr);

	}

}
