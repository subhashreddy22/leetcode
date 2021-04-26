package com.leetcode;

public class BinaryLinkedListToInteger {
	
	public static void main(String[] args) {
		BinaryLinkedListToInteger instance = new BinaryLinkedListToInteger();
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
		head.next.next = new ListNode(1);
		System.out.println(instance.getDecimalValue(head));
	}
	
	/**
	 * Bit Manipulation:
	 * 
	 * Initialize result number to be equal to head value: num = head.val. This operation is safe because the list is guaranteed to be non-empty.
	 * Parse linked list starting from the head: while head.next:

		The current value is head.next.val. Update the result by shifting it by one to the left and adding the current value using logical OR: num = (num << 1) | head.next.val.
	 * 
	 * Time complexity: O(N).
	 * Space complexity: O(1).
	 */
    public int getDecimalValue(ListNode head) {
        
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) | head.next.val;
            head = head.next;    
        }
        return num;
    }
    
    
    /**
     * Binary Representation:
     * 
     * Initialize result number to be equal to head value: num = head.val. This operation is safe because the list is guaranteed to be non-empty.
     * Parse linked list starting from the head: while head.next:

		The current value is head.next.val. Update the result by shifting it by one to the left and adding the current value: num = num * 2 + head.next.val.
     * 
     * Time complexity: O(N).
	 * Space complexity: O(1).
     */
//    public int getDecimalValue(ListNode head) {
//        int num = head.val;
//        while (head.next != null) {
//            num = num * 2 + head.next.val;
//            head = head.next;    
//        }
//        return num;
//    }
}