package leetCode;
/**
 * �ò�����������һ������
 * @author wushijia
 *
 */
public class Insert_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode ptr = new ListNode(0);//��¼ָ�룬ÿ�ε�λ�õıȵ�ǰ���ǰһ���ڵ�
        ListNode prehead = ptr;
        ListNode cur = head;
        ListNode next = cur;
        while(cur != null){
        	next = cur.next;
        	ptr = prehead;//ÿ�ζ���ԭ�����.��Ϊ��벿���Ѿ��������
        	while(ptr.next != null && ptr.next.val < cur.val){//���ptr����λ�õ�nextֵС��cur����ptr���������ʵ�λ��
        		ptr = ptr.next;
        	}
        	cur.next = ptr.next;
        	ptr.next = cur;
        	cur = next;
        }
        return prehead.next;//���µ�ͷ�ڵ�
    }
}
