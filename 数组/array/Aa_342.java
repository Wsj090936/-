package array;
/**
 * ����һ���������飬�����Ҫ�������������鳤��
 * ʱ�临�Ӷ�ΪO(N)
 * @author wushijia
 *˼·���£�
 *		���ȴ��ұ������飬��¼���ֵ���С������������λ����noMinIndex��¼(��ʼֵΪ-1)��
 *����������һ��Ԫ�ؼ�Ϊmin��ÿ��������min���������˵���˴���Ҫ��������noMinIndex��ֵ��Ϊ��λ�õ��±�
 *��Ȼ������������ұ���i����ͬ���ķ�ʽ��¼��Ҫ������λ��ΪnoMaxIndex����������������
 */
public class Aa_342 {
	public static int getMinLength(int[] arr){
		if(arr.length < 2 || arr == null){
			return 0;
		}
		int min = arr[arr.length - 1];
		int noMinIndex = -1;
		for(int i = arr.length - 2; i>=0 ;i-- ){
			if(arr[i] > min){
				noMinIndex = i;
			}else{
				min = Math.min(min, arr[i]);
			}
		}
		if(noMinIndex == -1){
			return 0;
		}
		int max = arr[0];
		int noMaxIndex = -1;
		for(int i = 1; i < arr.length;i++){
			if(arr[i] < max){
				noMaxIndex = i;
			}else{
				max = Math.max(max, arr[i]);
			}
		}
		if(noMaxIndex == -1){
			return 0;
		}
		return noMaxIndex - noMinIndex+1;
		
	}
	public static void main(String[] args) {
		int[] arr = new int[]{1,5,3,4,2,6,7};
		int min = getMinLength(arr);
		System.out.println(min);
	}
}
