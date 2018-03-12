package sort;
/**
 * �����򣺹�������ѣ��ų���С�������
 * ע�������������ʾ��
 * 		 7 8 9 10 11 12
 * �±꣺0 1 2  3  4  5
 * 	��ɵĶ�����
 * 				7
 * 			8		9
 * 		  10 11   12
 * @author wushijia
 *
 */
public class S_05_HeapSort {
	public static void heapSort(int[] arr){
		if(arr == null || arr.length<2){
			return;
		}
		for(int i = 0;i < arr.length;i++){
			heapInsert(arr,i);
		}
		int size = arr.length;//�ѵĴ�С
		swap(arr,0,--size);
		while(size > 0){
			heapfiy(arr,0,size);//��ʼ����
			swap(arr,0,--size);//���źõķ�������ĩ��
		}
	}

	private static void heapfiy(int[] arr, int index, int size) {//�������
		int left = index * 2 + 1;//ȡ����ǰ�ڵ������
		while(left < size){
			int largest = (left + 1) < size && arr[left +1] > arr[left]? left+1 :left;//�ж����������ڵ��ĸ���ȡ�ϴ���ĸ�
			largest = arr[largest] > arr[index]?largest : index;//�Ƚϵ�ǰ���������������ֵ
			if(largest == index){
				break;
			}
			swap(arr,largest,index);
			index = largest;//Ȼ��ӽ�����λ�ÿ�ʼ��������
			left = index * 2 + 1;//�ı�����
		}
	}

	private static void heapInsert(int[] arr,int index) {
		while(arr[index] > arr[(index-1)/2]){//ÿ�����Լ��ĸ��ڵ���бȽ�
			swap(arr,index,(index-1)/2);
			index = (index-1)/2;
		}
	}
	private static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{5,10,7,0,3,8};
		heapSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
