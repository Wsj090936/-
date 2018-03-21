package linkedList;
/**
 * ��һ���������Ϊ��߱�ĳһ����С���м������ȣ��ұ߱�����
 * @author wushijia
 *
 */
public class LinkedListPartation {
	public class Node{
		public int value;
		public Node next;
		public Node(int value){
			this.value = value;
		}
	}
	public Node partation(Node head,int n){
		Node smallH = null;//С��ͷ
		Node smallT = null;//С��β��
		Node equalH = null;//��
		Node equalT = null;
		Node moreH = null;//��
		Node moreT = null;
		Node ptr = head;
		while(ptr != null){//�������� �����ڡ����ڡ�С�ڲ��ֶ��������ϵĽڵ���
			ptr = head.next;//������һ���ڵ�
			head.next = null;
			if(head.value < n){
				if(smallH == null){
					smallH = head;
					smallT = head;
				}else{
					smallT.next = head;
					smallT = head;
				}
			}else if(head.value == n){
				if(equalH == null){
					equalH = head;
					equalT = head;
				}else{
					equalT.next = head;
					equalT = head;
				}
			}else{
				if(moreH == null){
					moreH = head;
					moreT = head;
				}else{
					moreT.next = head;
					moreT = head;
				}
			}
			head = ptr;
		}
		if(smallT != null){
			smallT.next = equalH;
			equalT = equalT == null?smallT:equalT;
		}
		if(equalT != null){
			equalT.next = moreH;
		}
		return smallH != null ? smallH : equalH != null ? equalH : moreH;
	}
}
