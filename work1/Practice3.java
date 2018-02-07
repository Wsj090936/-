package work1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * ���ӣ�https://www.nowcoder.net/questionTerminal/d2cced737eb54a3aa550f53bb3cc19d0
��Դ��ţ����

ĳ�͹���n�����ӣ�ÿ��������һ��������a �����ɵ���������� ��m�����ˣ�
ÿ����������������:b������cԤ�����ѽ� �ڲ�����ƴ��������£�
��ʵ��һ���㷨ѡ������һ���ֿ��ˣ�ʹ����Ԥ�����ѽ����� 
��������:
�������m+2�С� 
��һ����������n(1 <= n <= 50000),m(1 <= m <= 50000) 
�ڶ���Ϊn������a,��ÿ�����ӿ����ɵ��������,�Կո�ָ�,��Χ����32λint��Χ�ڡ� 
������m�У�ÿ����������b,c���ֱ��ʾ��i�����˵�������Ԥ�����ѽ��,�Կո�ָ�,��Χ����32λint��Χ�ڡ�
 * @author wushijia
 *
 *˼·�������Ӵ�С�������򣬽����˵Ļ����ʽ��ս�������Ȼ��ÿ��ѡ�ܹ��д��Ĳ��һ������Ĺ˿ͼ���
 *
 */
public class Practice3 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] table = new int[n];//����
		for (int i = 0; i < n; i++) {
			table[i] = scanner.nextInt();
		}
		int[][] cus = new int[m][2];//����
		for (int j = 0; j < m; j++) {
			cus[j][0] = scanner.nextInt();
			cus[j][1] = scanner.nextInt();
		}
		Arrays.sort(table);
		Arrays.sort(cus,new Comparator<int[]>() {//��������

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}
			
		});
		boolean[] tableb = new boolean[n];
		long res = 0l;
		for(int i = 0;i<m;i++){
			if(cus[i][0] > table[n-1])//����˿����������������ӣ��Ǿͺ�����һ���˿�
				continue;
			//���ҳ������ʺ���һ���˿͵�����
			int can = bs(table,cus[i][0]);
			while(can<n && tableb[can]==true){//�����ӱ�ռ��ʱ
				can++;
			}
			if(can < n){//����ҵ����ʵ�����
				res = res + cus[i][1];
				tableb[can] = true;
			}
		}
		scanner.close();
		System.out.println(res);
	}
	private static int bs(int[] arr,int target){//�ҵ����ڻ��ߵ��ڹ˿�����������
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		while(low < high){
			mid = low + ((high-low)/2);
			if(arr[mid] >= target){
				high = mid;
			}else{
				low = mid + 1;
			}
		}
		return low;
	}
}
