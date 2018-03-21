package linkedList;
/**
 * �ж�һ�������Ƿ�Ϊ���Ľṹ
 * ��ͨ�ⷨ���ռ临�Ӷ�Ϊo(n)  ��������Ұ벿��ѹ��ջ��Ȼ�����벿�ֿ�ʼ�Ƚϣ�ֻҪ��һ����һ�����ͷ���false�����򷵻�true
 * @author wushijia
 * ���׽ⷨ���ռ临�Ӷ�ΪO(1)  �ҵ�������е�λ�ã�Ȼ���Ұ����������Ұ�����ʼ�Ƚ�
 *  1 2 3 4 5 6
 */
public class shi_fou_wei_hui_wen {
	public class Node{
		public int value;
		public Node next;
		public Node(int value){
			this.value = value;
		}
	}
	public boolean judge(Node head){
		if(head == null){
			return false;
		}
		Node slow = head;
		Node fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		Node ptr = slow.next;//�ұ߲��ֵ�һ���ڵ�
		slow.next = null;
		Node next = null;
		while(ptr != null){//���Ұ벿������
			next = ptr.next;
			ptr.next = slow;
			slow = ptr;
			ptr = next;
		}
		next = slow;//slowΪ�Ұ벿�ֵ�ͷ�ڵ㣬Ҳ����������һ���ڵ�
		ptr = head;
		boolean res = true;
		while(slow != null&&ptr != null){
			if(slow.value != ptr.value){
				res = false;
				break;
			}
			slow = slow.next;//�ҵ���
			ptr = ptr.next;//����
		}
		slow = next.next;//�洢��һ���ڵ�
		next.next = null;//next�����һ���ڵ�
		while(slow != null){//�������������
			ptr = slow.next;
			slow.next = next;
			next = slow;
			slow = ptr;
		}
		return res;
	}
}
