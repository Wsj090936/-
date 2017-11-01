package algorithms2;
/**
 * �ϲ���������ĵ�����
 * @author wushijia
 *
 */
public class MergeList {
	public Node fun1(Node head1,Node head2){
		if(head1 == null || head2 == null){
			return head1 != null ? head1 : head2;
		}
		Node head = head1.value < head2.value ? head1 : head2;//ȡ��С��ͷ�ڵ�Ϊ�������ͷ���
		Node cur1 = head == head1 ? head1 : head2;//����һ���ڱ�
		Node cur2 = head == head1 ? head2 : head1;//��������ڱ�
		Node pre = null;//�����˵Ľڵ�
		Node next = null;//����2�е���һ���ڵ�
		while(cur1 != null && cur2 != null){//ֻҪ��һ�����������ɾ��˳�
			if(cur1.value < cur2.value){//��һ�β��õ���
				pre = cur1;
				cur1 = cur1.next;
			}else{
				next = cur2.next;
				pre.next = cur2;
				cur2.next = cur1;
				pre = cur2;
				cur2 = next;
			}
		}
		pre.next = cur1 == null? cur2 : cur1;//��δ�����������ƴ��
		return head;
	}
}
