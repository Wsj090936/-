package work1;

import java.util.Scanner;

/**
 * ����ת��������������m��n�ֱ������Ҫת�������ͽ��ƣ���mת��Ϊ��Ӧ�Ľ��ƺ����
 * @author wushijia
 *
 */
public class Practice1 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		if(m == 0){
			System.out.println(0);
		}else{
			char[] table = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			String res = "";
			while(m!=0){
				if(m<0){//mΪ������ʱ��
					m = -m;
					System.out.print("-");
				}
				res = table[m%n]+res;
				m = m/n;
			}
			System.out.println(res);
		}
	}
}
