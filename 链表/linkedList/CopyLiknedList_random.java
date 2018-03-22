package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ�����������Ǹõ������ÿһ���ڵ���һ�������ָ��ָ������ڵ�
 * @author wushijia
 *
 */
public class CopyLiknedList_random {
	public class Node{
		public int value;
		public Node next;
		public Node rand;
		public Node(int value){
			this.value = value;
		}
	}
	public Node CopyLinkedListRand(Node head){//����һ  �ռ临�Ӷ�ΪO(n)
		if(head == null){
			return null;
		}
		Map<Node,Node> map = new HashMap<>();
		Node cur = head;
		while(cur != null){//���ڵ�͸��ƽڵ�ȫ�������ϣ��
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		Node ptr = head;
		while(ptr != null){//����map��Ͽ�¡�ڵ�
			map.get(ptr).next = map.get(ptr.next);
			map.get(ptr).rand = map.get(ptr.rand);
			ptr = ptr.next;
		}
		return map.get(head);
	}
	public Node CopyLinkedListRan(Node head){//���������ռ临�Ӷ�ΪO(1)
		if(head == null){
			return null;
		}
		Node next = null;
		Node ptr = head;
		while(ptr != null){//�����ƽ�����ÿһ��ԭ�ڵ����
			next = ptr.next;
			ptr.next = new Node(ptr.value);
			ptr.next.next = next;
			ptr = next;
		}
		ptr = head;
		Node copyNode = null;
		while(ptr != null){//�����ƽڵ��randָ��ָ��
			next = ptr.next.next;
			copyNode = ptr.next;
			copyNode.rand = ptr.rand==null?ptr.rand.next:null;//�����Ƿ�Ϊ����ָ��
			ptr = next;
		}
		Node copyHead = head.next;
		ptr = head;
		while(ptr != null){
			next = ptr.next.next;
			copyNode = ptr.next;
			ptr.next = next;
			copyNode.next = next == null?null:next.next;
			ptr = next;
		}
		return copyHead;
	}
}
