package dynamicProgramming;
/**
 * ��һ���������飬��һ��������aim��Ҫ���������еļ�����(ÿ����ֻ����һ��)��������aim������ɾͷ���true�����ܾͷ���false
 * @author wushijia
 *
 */
public class Money {
	public static void money(int[] arr,int aim){
		diguiMoney(arr,aim,0,0);
	}

	private static boolean diguiMoney(int[] arr, int aim, int i, int sum) {
		if(i == arr.length){
			return sum == aim;
		}
		return diguiMoney(arr,aim,i + 1,sum) || diguiMoney(arr,aim,i + 1,sum + arr[i]);
	}
	
	public static boolean money1(int[] arr,int aim){//�ɵݹ�������
		boolean[][]dp = new boolean[arr.length + 1][aim + 1];
		for(int i = 0;i < arr.length;i++){
			dp[i][aim] = true;//��sum==aimʱ����Ϊtrue
		}
		for(int i = arr.length - 1;i >= 0;i--){//��
			for(int j = aim - 1; j > 0;j--){//��
				dp[i][j] = dp[i + 1][aim];//��ʾ��ǰ״̬,j����sum��ֵ
				if(j + arr[i] <= aim){
					dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
				}
			}
		}
		return dp[0][0];
	}
}
