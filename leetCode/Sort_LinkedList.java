package leetCode;

public class Sort_LinkedList {
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
       quickList(head,null); 
       return head;
    }
    public static void quickList(ListNode left,ListNode right){
    	if(left == right || left.next == right){
    		return;
    	}
    	ListNode mid = partation(left,right);
    	quickList(left,mid);
    	quickList(mid.next,right);
    }
    private static ListNode partation(ListNode left,ListNode right){
    	if(left == right || left.next == right){
    		return left;
    	}
    	int key = left.val;
    	ListNode head = left;
    	ListNode cur = left;//С������
    	while(left != right){
    		if(left.val < key){//��߽��ǰһ���͵�ǰ����
    			cur = cur.next;
    			swap(cur,left);
    		}
    		left = left.next;
    	}
    	swap(cur,head);//���ͷ�ڵ�key���м��������
    	return cur;//��󷵻��м�����
    }
    private static void swap(ListNode a,ListNode b){
    	int temp = a.val;
    	a.val = b.val;
    	b.val = temp;
    }
    public static void main(String[] args) {
		ListNode head = new ListNode(5);
		head.next = new ListNode(3);
		head.next.next = new ListNode(6);
		ListNode head1 = sortList(head);
		System.out.println(head1.val +""+ head1.next.val +""+ head1.next.next.val);
	}
}
