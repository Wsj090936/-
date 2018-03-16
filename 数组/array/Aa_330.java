package array;
/**
 * ��һ����������Сֵ�����ֵ�Ĳ�ֵ��Ҫ��ʱ�临�Ӷ�ΪO(N)
 * ����Ͱ����ÿ��Ͱ����װ��һ����Χ�ϵ�����Ȼ�����
 * Ͱ�Ĵ�С�����鳤��+1
 * @author wushijia
 *
 */
public class Aa_330 {
	public static int getRes(int[] arr){
		if(arr == null || arr.length<2){
			return 0;
		}
		int len = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0;i < len;i++){//�ҵ����ֵ����Сֵ
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		if(min == max){
			return 0;
		}
		boolean[] hasNum = new boolean[len+1];
		int[] maxs = new int[len+1];//��¼�����������
		int[] mins = new int[len+1];//��¼��С��������
		int bid = 0;
		for(int i = 0;i<len;i++){
			bid = bucketNum(arr[i],len,max,min);
			maxs[bid] = hasNum[bid]?Math.max(maxs[bid], arr[i]):arr[i];
			mins[bid] = hasNum[bid]?Math.min(mins[bid], arr[i]):arr[i];
			hasNum[bid] = true;
		}
		int res = 0;
		int lastMax = maxs[0];//��ʼʱ����ǰ�������һ����0��Ͱ��
		for(int i = 1;i <= len;i++){
			if(hasNum[i]){
				res = Math.max(res,mins[i]-lastMax);//��һ���ǿ�Ͱ����Сֵ��ȥǰһ���ǿ�Ͱ�����ֵ
				lastMax = maxs[i];//���ı�ǰһ���ǿ�Ͱ�����ֵ
			}
		}
		return res;
	}
	private static int bucketNum(int num,int len,int max,int min){
		return ((num-min)*len/(max-min));
	}
}
