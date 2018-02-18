package array;
/**
 * Ѱ�ҵ���������С��k����
 * ��ͨ�Ľⷨ�����ÿ�������Ȼ�󷵻������ǰk���������������Ļ�ʱ�临�Ӷ�ΪO(N*logN)
 * ���öѵĻ�ʱ�临�Ӷȿ��Խ�ΪO(N*logK)
 * �����˶�����ʼ��ά��һ������Ϊk�Ĵ���ѣ��������飬ÿ�������е�ĳһ�����ȶ��еĸ�Сʱ���ͽ�����Ȼ�������
 * �������Ѽ���
 * @author wushijia
 *
 */
public class Aa_336 {
	public static int[] getMinNums(int[] arr,int k){
		if(k < 1 || k > arr.length){
			return arr;
		}
		int[] heapArr = new int[k];//������  �����
		for (int i = 0; i != k; i++) {
			heapInsert(heapArr,arr[i],i);
		}
		for(int i = k;i != arr.length;i++){//���ڶ����Ѿ�������ǰk��Ԫ�أ���������k��ʼ
			if(arr[i] < heapArr[0]){
				heapArr[0] = arr[i];
				heapify(heapArr,0,k);
			}
		}
		return heapArr;
	}
	
	private static void heapify(int[] heapArr, int index, int size) {
		int left = index*2 + 1;//����
		int right = index*2 + 2;
		int largest = index;
		while(left < size){//������������ܽ��е���
			if(heapArr[left] > heapArr[index]){
				largest = left;
			}
			if(right < size && heapArr[right] > heapArr[largest]){
				largest = right;
			}
			if(largest != index){
				swap(heapArr,largest,index);
			}else{
				break;
			}
			index = largest;
			left = index*2 + 1;
			right = index*2 + 2;
		}
		
	}

	private static void heapInsert(int[] heapArr,int value,int index){
		heapArr[index] = value;
		while(index != 0){
			int parent = (index-1)/2;
			if(heapArr[index] > heapArr[parent]){//������
				swap(heapArr,index,parent);
				index = parent;
			}else{
				break;
			}
		}
	}

	private static void swap(int[] arr,int m,int n){
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{3,6,7,9,2,40,50,17};
		int[] minNums = getMinNums(arr,4);
		for (int i : minNums) {
			System.out.println(i);
		}
	}
}
