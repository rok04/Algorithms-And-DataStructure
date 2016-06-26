/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
 /**
 * https://leetcode.com/problems/add-two-numbers/
 * List is already given in reversal order 
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carry = 0;
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else {
			ListNode list = new ListNode((l1.val + l2.val + carry) % 10);
			carry = (l1.val + l2.val + carry) / 10;
			;
			l1 = l1.next;
			l2 = l2.next;
			ListNode head = list;
			while (l1 != null && l2 != null) {
				ListNode newNode = new ListNode((l1.val + l2.val + carry) % 10);
				carry = (l1.val + l2.val + carry) / 10;
				// System.out.println(carry);
				list.next = newNode;
				list = list.next;
				l1 = l1.next;
				l2 = l2.next;
			}

			if (l1 != null) {
				while (l1 != null) {

					list.next = new ListNode((l1.val + carry) % 10);
					carry = (l1.val + carry) / 10;
					list = list.next;
					l1 = l1.next;
				}
			} else if (l2 != null) {
				while (l2 != null) {

					list.next = new ListNode((l2.val + carry) % 10);
					carry = (l2.val + carry) / 10;
					list = list.next;
					l2 = l2.next;
				}
			}
			if (carry != 0) {
				ListNode newNode = new ListNode(carry);
				list.next = newNode;
				list = list.next;
				list.next = null;

			}
			return head;
		}
	}
}
