package algorithms2;

import java.util.HashSet;
import java.util.Set;
/**
 * ɾ��һ�����������ظ�ֵ�Ľڵ㣬Ҫ��ʱ�临�Ӷ�ΪO(N)
 * @author wushijia
 *
 */
public class RemoveRep {
	public Node fun1(Node head){
		if(head == null){
			return null;
		}
		Set<Integer> set = new HashSet<>();
		Node cur = head.next;
		Node ptr = head;
		set.add(head.value);
		while(cur != null){
			if(set.contains(cur.value)){
				ptr.next = cur.next;
			}else{
				set.add(cur.value);
				ptr = cur;
			}
			cur = cur.next;
		}
		return head;
	}
}
