package algorithms2;

import java.util.HashMap;
import java.util.Map;
/**
 * ���ƻ������ָ��ڵ������
 * ˼·��
 * 		�Ƚ����нڵ����һ�鲢���Ʒ����ϣ��map�У���ԭ���ڵ���Ϊkey�����ƵĽڵ���Ϊvalue
 * Ȼ���ٱ���һ������ÿһ���ڵ��next��rand�ڵ�ƴ������������get(head)����
 * @author wushijia
 *
 */
public class CopyListWithRandom {
	public RandNode fun1(RandNode head){
		if(head == null){
			return null;
		}
		Map<RandNode,RandNode> map = new HashMap<>();
		RandNode cur = head;
		while(cur != null){//�ȱ���һ�������������нڵ㵽map��
			map.put(cur, new RandNode(cur.value));
			cur = cur.next;
		}
		cur = head;
		while(cur != null){
			map.get(cur).next = map.get(cur.next);//��ԭ�����������
			map.get(cur).rand = map.get(cur.rand);//������������
			cur = cur.next;
		}
		return map.get(head);//���������ͷ��㷵��
	}
}
