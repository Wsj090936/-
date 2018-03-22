package linkedList;
/**
 * ���������ཻ��һϵ������
 * @author wushijia
 *һ�������л�  ��һ���޻������Ȼ���ǲ��뽻�������������л��������ǿ����ཻ  Ҳ���ܲ��뽻
 */
public class TwoLinkedList_xiangjiao {
	public class Node{
		public int value;
		public Node next;
		public Node(int value){
			this.value = value;
		}
	}

	public Node noLoop(Node head1,Node head2){//l�����޻������Ƿ��ཻ�����ཻ�����ص�һ���ཻ�ڵ�
		if(head1 == null || head2 == null){//Ҳ����ʹ��HashSet
			return null;
		}
		int len = 0;
		Node cur = head1;
		Node ptr = head2;
		while(cur.next != null){//�õ�����һ�ĳ���
			len++;
			cur = cur.next;
		}
		while(ptr.next != null){
			len--;
			ptr = ptr.next;
		}
		if(cur != ptr){//�����ཻ
			return null;
		}
		cur = len > 0 ? head1 : head2;//curʼ���ǳ������������ͷ�ڵ�
		ptr = cur == head1 ? head2 : head1;
		len = Math.abs(len);//ȡlen�ľ���ֵ
		while(len != 0){
			len--;
			cur = cur.next;
		}
		//������һ����cur��ptr���ཻ��һ���ڵ�ľ���������
		while(cur != ptr){
			cur = cur.next;
			ptr = ptr.next;
		}
		return cur;
	}
	
	public Node getLoopNode(Node head){//�ж�һ�������Ƿ��л����л��򷵻ص�һ���뻷�ڵ㣬���򷵻�null
		if(head == null){
			return null;
		}
		Node slow = head.next;
		Node fast = head.next.next;
		while(slow != fast){
			if(fast.next == null || fast.next.next == null){
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
