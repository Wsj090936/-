package tanxin;

import java.util.PriorityQueue;

/**
 * һ������г����룬����Ҫ���Ѻͳ�����ֵһ����ͭ��ġ����糤��Ϊ20�� �����������гɳ��ȶ������룬��Ҫ����20��ͭ�塣һȺ������������� ������ô����ʡͭ�壿
����,��������{10,20,30}������һ�������ˣ������������Ϊ10+20+30=60. ����Ҫ�ֳ�10,20,30�������֡� ����� �Ȱѳ���60�Ľ����ֳ�10��50������60 �ٰѳ���50�Ľ����ֳ�20��30������50 һ������110ͭ�塣
��������� �Ȱѳ���60�Ľ����ֳ�30��30������60 �ٰѳ���30�����ֳ�10��20������30 һ������90ͭ�塣
����һ�����飬���طָ����С����
 * @author wushijia
 *���������͵Ĺ�������������
 *ʹ��С���ѽṹ���
 */
public class Less_Money {
	private static int getLessMoney(int[] arr){
		PriorityQueue<Integer> pro = new PriorityQueue<>();
		for(int i = 0;i < arr.length;i++){//����С����
			pro.add(arr[i]);
		}
		int res = 0;
		int temp = 0;
		while(pro.size() > 1){
			temp = pro.poll() + pro.poll();
			res += temp;
			pro.add(temp);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{10,20,30};
		int money = getLessMoney(arr);
		System.out.println(money);
	}
}
