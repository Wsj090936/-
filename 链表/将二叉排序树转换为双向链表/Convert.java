package algorithms2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ������������ת��Ϊ˫������
 * @author wushijia
 *
 */
public class Convert {
	public Node2 fun1(Node2 head){
		if(head == null){
			return null;
		}
		Queue<Node2> queue = new LinkedList<>();
		initQueue(head,queue);
		head = queue.poll();
		Node2 cur = null;
		Node2 ptr = head;
		ptr.left = null;
		while(!queue.isEmpty()){//������ƴ������
			cur = queue.poll();
			ptr.right = cur;
			cur.left = ptr;
			ptr = cur;
		}
		ptr.right = null;
		return head;
	}
	
	private void initQueue(Node2 head,Queue<Node2> queue ){//���������������������
		if(head == null){
			return;
		}
		initQueue(head.left,queue);
		queue.offer(head);
		initQueue(head.right,queue);
	}
}
