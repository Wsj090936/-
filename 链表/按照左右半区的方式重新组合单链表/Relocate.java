package algorithms2;
/**
 * �Ƚ������ֳ���������Ȼ����װ����
 * @author wushijia
 *
 */
public class Relocate {
	public void fun1(Node head){
		if(head == null){
			return;
		}
		Node mid = head;//�м�ڵ㡣��������β���ڵ�
		Node right = head.next;//�ұ������ͷ���
		while(right.next != null && right.next.next != null){
			mid = mid.next;
			right = right.next.next;
		}
		right = mid.next;
		mid.next = null;
		mergeLR(head, right);//��ʼ�ϲ���������
	}
	private void mergeLR(Node left,Node right){//�ϲ���������
		Node next = null;
		while(left.next != null){
			next = right.next;
			right.next = left.next;
			left.next = right;
			left = right.next;
			right = next;
		}
		left.next = right;
	}
}
