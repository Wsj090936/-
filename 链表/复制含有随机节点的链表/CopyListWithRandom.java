package algorithms2;

import java.util.HashMap;
import java.util.Map;
/**
 * ���ƻ������ָ��ڵ������
 * @author wushijia
 *
 */
public class CopyListWithRandom {
	/**
	 * ˼·������һ
	 * 		�Ƚ����нڵ����һ�鲢���Ʒ����ϣ��map�У���ԭ���ڵ���Ϊkey�����ƵĽڵ���Ϊvalue
	 * Ȼ���ٱ���һ������ÿһ���ڵ��next��rand�ڵ�ƴ������������get(head)����
	 * @param head
	 * @return
	 */
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
	/**
	 * �����������׷���
	 * 	�Ƚ������е�ÿһ���ڵ���и��ƣ�����ƴ�ӵ�ԭ���ڵ���棬Ȼ���ٱ���һ�����������ƵĽڵ�֮���rand�ڵ���������
	 * ����ٱ���һ��������ԭ��������͸������õ������ֿ������ɣ���������Ҫע���жϽڵ��Ƿ�Ϊnull
	 * @param head
	 * @return
	 */
	public RandNode fun2(RandNode head){
		if(head == null){
			return null;
		}
		RandNode cur = head;//���ڱ����ڵ�
		RandNode next = null;//�洢��һ���ڵ�ı���
		while(cur != null){//��ÿһ������Ľڵ㸴�Ʋ��ӵ����ǵĺ���
			next = cur.next;
			cur.next = new RandNode(cur.value);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		RandNode copyCur = null;
		while(cur != null){//�����Ƶ�����֮��Ĺ�ϵ�໥��������
			next = cur.next.next;//��cur�ƶ���ԭ����ĵڶ����ڵ�
			copyCur = cur.next;
			copyCur.rand = cur.rand != null ? cur.rand.next : null;//����֮����Ϊcur.rand.next������ΪҪ�ø��ƵĽڵ�ָ��ԭ���ڵ��rand�ڵ�ĸ��ƽڵ�
			cur = next;
		}
		cur = head;
		RandNode res = head.next;//������������ı�ͷ
		while(cur != null){//��ԭ����͸������������
			next = cur.next.next;
			copyCur = cur.next;
			cur.next = next;//ԭ��������
			copyCur.next = next != null ? next.next : null;//���������������ƴ��
			cur = next;
		}
		return res;
	}
}
