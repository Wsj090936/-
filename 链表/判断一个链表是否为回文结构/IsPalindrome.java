package algorithms;

import java.util.Stack;

/**
 * �ж�һ�������Ƿ�Ϊ���Ľṹ
 * @author wushijia
 *
 */
public class IsPalindrome {
	public boolean fun1(Node head){//����һ���ռ临�Ӷ�ΪO(N)
		if(head == null || head.next == null){
			return true;
		}
		Node right = head.next;
		Node cur = head;//��ָ�룬��������ȷ���Ұ벿�֣����������Ϊ���������������м�Ľڵ�
		while(cur.next != null && cur.next.next != null){//ȷ���Ұ벿�ֵ�ͷ���Ϊright
			right = right.next;
			cur = cur.next.next;
		}
		Stack<Node> stack = new Stack<>();
		while(right != null){
			stack.add(right);
			right = right.next;
		}
		while(!stack.isEmpty()){
			if(head.value != stack.pop().value){//���Ұ벿������벿�ֲ���ͬʱ
				return false;
			}
			head = head.next;
		}
		return true;
	}
	public boolean fun2(Node head){//���������ռ临�Ӷ�ΪO(1)
		if(head == null || head.next == null){
			return true;
		}
		Node n1 = head;
		Node n2 = head;
		while(n2.next != null && n2.next.next != null){
			n1 = n1.next;//�м�ڵ�
			n2 = n2.next.next;//β���ڵ�
		}
		n2 = n1.next;//�Ұ�����һ���ڵ�
		n1.next = null;//�м�ڵ����һ���ڵ�ָ��null
		Node n3 = null;
		while(n2 != null){//��ת�Ұ���
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;//n1�ƶ�
			n2 = n3;//n2�ƶ�
		}
		n2 = head;//��ߵ�һ���ڵ�
		n3 = n1;//�������һ���ڵ�
		boolean res = true;
		while(n2 != null && n1 != null){//��ʼ�Ƚ�
			if(n2.value != n1.value){
				res = false;
				break;
			}
			n2 = n2.next;
			n1 = n1.next;
		}
		//�ָ�����
		n1 = n3.next;
		n3.next = null;//���һ���ڵ�
		while(n1 != null){
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}
}
