package algorithms;
/**
 * ������ͨ�������ȱ��������õ�����ĳ��ȣ�Ȼ����ݴ˳��ȴ���һ�����飬Ȼ�������е�ÿһ���ڵ�������飬Ȼ�������������privot
 * �������е�ÿһ���ڵ��������бȽϣ�����С�ķ���ߣ���ķ��ұ�
 * @author wushijia
 *
 */
public class ListPartition {
	public Node part1(Node head,int pivot){//����pivotָ�����м�ڵ㣬��ߵĽڵ㶼С�������ұߵĽڵ㶼������
		if(head == null){
			return null;
		}
		Node cur = head;
		int i = 0;
		while(cur != null){
			i++;
			cur = cur.next;
		}
		Node[] arr = new Node[i];
		i = 0;
		cur = head;
		for(i = 0;i < arr.length;i++){//�������е�ÿһ���ڵ�������
			arr[i] = cur;
			cur = cur.next;
		}
		partition(arr, pivot);
		for(i = 1;i < arr.length;i++){//��ʼ�������
			arr[i - 1].next = arr[i];
		}
		arr[i - 1].next = null;//���һ���ڵ��nextָ���
		return arr[0];//�����Ԫ����Ϊ����ĵ�һ���ڵ�
		
	}
	private void partition(Node[] arr,int pivot){//��ʼ������ĿҪ���������飬���ǲ���˳��
		int small = -1;
		int big = arr.length;
		int index = 0;
		while(index != arr.length){
			if(arr[index].value < pivot){
				swap(arr,++small,index++);
			}else if(arr[index].value == pivot){
				index++;
			}else{
				swap(arr,--big,index);
			}
		}
	}
	private void swap(Node[] arr,int a,int b){//���������е�Ԫ��
		Node tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
