package algorithms2;

import java.util.Stack;
/**
 * ɾ��ָ��ֵ�Ľڵ�
 * @author wushijia
 *
 */
public class RemoveNode {
	public Node fun1(Node head,int e){
		if(head == null){
			return null;
		}
		Stack<Node> stack = new Stack<>();
		Node cur = head;
		while(cur != null){//��ֵ��Ϊe�Ľڵ���ջ
			if(cur.value != e){
				stack.push(cur);
			}
			cur = cur.next;
		}
		while(!stack.isEmpty()){//��������������
			stack.peek().next = cur;
			cur = stack.pop();
		}
		return head;
	}
}
