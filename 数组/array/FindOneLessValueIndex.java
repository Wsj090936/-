package array;
/**
 * ���������ҵ�һ���ֲ���С��λ�� 
 * ����Ŀ�� ����ֲ���С�ĸ��arr����Ϊ1ʱ��arr[0]�Ǿֲ���С��
 * arr�ĳ���Ϊ N(N>1)ʱ�����arr[0]<arr[1]����ôarr[0]�Ǿֲ���С��
 * ���arr[N1]<arr[N-2]����ôarr[N-1]�Ǿֲ���С�����0<i<N-1��
 * ���� arr[i]<arr[i-1]������arr[i]<arr[i+1]����ôarr[i]�Ǿֲ���С�� 
 * ������������arr����֪arr�������������ڵ���������ȡ�дһ��������
 *  ֻ�践��arr������һ���ֲ���С���ֵ�λ�ü���
 * @author wushijia
 *
 */
public class FindOneLessValueIndex {
	public static int findOneLessValueIndex(int[] arr){
		if(arr == null || arr.length < 1){
			return -1;
		}
		if(arr.length == 1 || arr[0] < arr[1]){//ͷ
			return 0;
		}
		if(arr[arr.length-1] < arr[arr.length - 2]){//β��
			return arr.length - 1;
		}
		//���������������˵��ͷ��β֮��һ���оֲ���Сλ��
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while(left < right){
			mid = left + (right - left)/2;
			if(arr[mid] > arr[mid - 1]){//�м�ı���ߵĴ�
				right = mid - 1;
			}else if(arr[mid] > arr[mid + 1]){//�м�ı��ұߵĴ�
				left = mid + 1;
			}else{//�ҵ�
				return mid;
			}
		}
		return left;
	}
}
