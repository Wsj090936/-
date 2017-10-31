package algorithms2;
/**
 * �������ѡ������
 * Ҫ�����ռ临�Ӷ�ΪO(1),�������������ȹ���
 * @author wushijia
 *
 */
public class SelectionSort {
	public Node fun1(Node head){
		Node tail = null;//���򲿷ֵ�β��
		Node cur = head;//δ���������ͷ���
		Node smallpre = null;//��ɾ�������ǰһ���ڵ�
		Node smallNode = null;//��С�Ľڵ�
		while(cur != null){
			smallNode = cur;
			smallpre = getSmallpre(head);
			if(smallpre != null){//ɾ����С�ڵ�
				smallNode = smallpre.next;
				smallpre.next = smallNode.next;
			}
			cur = cur == smallNode ? cur.next : cur;
			if(tail == null){//ȷ��ͷ���
				head = smallNode;
			}else{
				tail.next = smallNode;
			}
			tail = smallNode;
		}
		return head;
	}
	private Node getSmallpre(Node head){//�õ���С�ڵ��ǰһ���ڵ�
		Node smallpre = null;
		Node small = head;
		Node pre = head;
		Node cur = head.next;
		while(cur != null){
			if(cur.value < small.value){
				smallpre = pre;
				small = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		return smallpre;
	}
}
