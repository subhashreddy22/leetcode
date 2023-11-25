package com.leetcode;

/*
 	You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	
	Example 1:
	
	
	Input: l1 = [2,4,3], l2 = [5,6,4]
	Output: [7,0,8]
	Explanation: 342 + 465 = 807.
	Example 2:
	
	Input: l1 = [0], l2 = [0]
	Output: [0]
	Example 3:
	
	Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	Output: [8,9,9,9,0,0,0,1]
	 
	Constraints:
	
	The number of nodes in each linked list is in the range [1, 100].
	0 <= Node.val <= 9
	It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {
	
	public static void main(String[] args) {
		AddTwoNumbers instance = new AddTwoNumbers();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode result = instance.addTwoNumbers(l1, l2);
		
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
	
	
	/**
	 * Time complexity : O(max(m, n)). Assume that m and n represents the length of l1 and l2 respectively, the algorithm below iterates at most max(m,n) times.
	 * Space complexity : O(max(m, n)). The length of the new list is at most max(m,n) + 1 (1 is added in case carry exists on final iteration)
	 * 
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		// Both dummy node and result node point to the same instance of ListNode
		// Whenever a result.next is defined it keeps getting added to dummy node
		// result = result.next overwrites result but the dummy stays intact with the next nodes getting added to it.
		// It can be checked by debugging
		ListNode dummyNode = new ListNode();
		ListNode result = dummyNode;
		int carry = 0;
		int sum;

		while (l1 != null || l2 != null) {
			sum = carry;
			if (l1 != null && l2 != null) {
				sum += l1.val + l2.val;
				l1 = l1.next;
				l2 = l2.next;
			} else if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			} else {
				sum += l2.val;
				l2 = l2.next;
			}

			carry = sum / 10;

			result.next = new ListNode(sum % 10);
			result = result.next;
		}
		
		// if carry exists once the loop ends add it to the linked list
		if (carry > 0) {
			result.next = new ListNode(carry);
		}

		return dummyNode.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
