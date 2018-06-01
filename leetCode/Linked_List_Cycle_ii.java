package leetCode;
/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

	Follow up:
	Can you solve it without using extra space?
 * @author wushijia
 *����һ����������л��������뻷�ڵ㣬���û��������null
 */
public class Linked_List_Cycle_ii {
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
        	return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean  flag = false;
        while(fast.next != null && fast.next.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast){
        		flag = true;
        		break;
        	}
        }
        if(flag == false){
        	return null;
        }//���û��
        fast = head;
        while(fast != slow){
        	fast = fast.next;
        	slow = slow.next;
        }
        return fast;
    }
    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
//		head.next.next.next = head.next;
		System.out.println(detectCycle(head).val);
	}
}
