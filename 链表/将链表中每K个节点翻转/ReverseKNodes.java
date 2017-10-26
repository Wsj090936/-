package algorithms2;

import java.util.Stack;

/**
 * ��һ�������У�ÿK���ڵ����� �磺1->2->3->4->5->6->7->8->null ��Ϊ 3->2->1-:6->5->4->7->8->null
 * 
 * @author wushijia
 *
 */
public class ReverseKNodes {
	private Node resign(Stack<Node> stack,Node left,Node right){//leftΪ�����������һ���ڵ㣬rightΪ�ұ�Ԫ�صĵ�һ���ڵ�
		Node cur = stack.pop();
		if(left != null){
			left.next = cur;
		}
		Node next = null;
		while(!stack.isEmpty()){
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;//��ת���������ԭ������������������
		return cur;
	}
	public Node fun1(Node head,int K){
		if(head == null){
			return null;
		}
		if(K < 2){
			return head;
		}
		Stack<Node> stack = new Stack<Node>();
		Node newHead = head;
		Node cur = head;//ָ��ڵ�
		Node next = null;
		Node pre = null;//��ת����������һ���ڵ�
		while(cur != null){
			next = cur.next;
			stack.push(cur);
			if(stack.size() == K){
				pre = resign(stack,pre,next);
				newHead = newHead == head ? cur : newHead;//�ڵ�һ�η�ת����ʱ��ͷ���ȷ�����Ժ�Ͳ���ı���
			}
			cur = next;
		}
		return newHead;
	}
}
