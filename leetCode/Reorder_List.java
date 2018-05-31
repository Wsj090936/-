package leetCode;
/**
 *  Given a singly linked list L: L 0��L 1������L n-1��L n,
	reorder it to: L 0��L n ��L 1��L n-1��L 2��L n-2����
	
	You must do this in-place without altering the nodes' values.
	
	For example,
	Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * @author wushijia
 * ����˼·���������ҵ��м�ڵ�����ڵ�(����ָ�뼴��)��Ȼ���Ұ벿�ֽڵ㷭ת������
 * Ȼ����е�i���ڵ�͵�n-i���ڵ��ƴ��(i��0��ʼ)
 */
public class Reorder_List {
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
        	return;
        }
        ListNode slow = head;//λ�������м�
        ListNode fast = head;//λ������ĩβ
    	while(fast.next != null && fast.next.next != null){
    		slow = slow.next;//�м��ָ��
    		fast = fast.next.next;
    	}
    	if(fast.next != null){
    		fast = fast.next;
    	}
    	//Ȼ��ʼ��ת��һ������
    	ListNode pre = slow;
    	ListNode cur = pre.next;
    	ListNode next = null;
    	pre.next = null;
    	while(cur != null){//��ʼ��ת
    		next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}
        cur = head;
        ListNode ptr = fast;//�ұ������nextָ��
        next = null;
        while(cur != null){
        	next = cur.next;
        	ptr = fast.next;
        	cur.next = fast;
        	fast.next = next;
        	cur = next;
        	fast = ptr;
        }
        
    }
    private static void reverseHalfLinkedList(ListNode head){
    }
    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		reorderList(head);
		ListNode cur = head;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
		
	}
}
