package algorithms;
/**
 * ���׷���
 * @author wushijia
 *
 */
public class ListPartition2 {
	public Node fun2(Node head,int pivot){
		Node sH = null;//С�����ͷ
		Node sT = null;//С�����β
		Node eH = null;//��ͬ�����ͷ
		Node eT = null;//��ͬ�����β
		Node bH = null;//�������ͷ
		Node bT = null;//�������β
		Node next = null;//�洢��һ���ڵ�
		while(head != null){
			next = head.next;
			head.next = null;
			if(head.value < pivot){//С
				if(sH == null){
					sH = head;
					sT = head;
				}else{//��β������ڵ�
					sT.next = head;
					sT = head;
				}
			}else if(head.value == pivot){
				if(eH == null){
					eH = head;
					eT = head;
				}else{
					eT.next = head;
					eT = head;
				}
			}else{
				if(bH == null){
					bH = head;
					bT = head;
				}else{
					bT.next = head;
					bT = head;
				}
			}
			head = next;//ÿ��ͷ��㶼��䣬��Ϊ֮ǰ�Ľڵ㱻���䵽��������������

		}
		if(sT != null){
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		if(eT != null){
			eT.next = bH;
		}
		return sH != null ? sH : eH != null ? eH : bH;//�жϷ��غϳ������ͷ���
	}
}
