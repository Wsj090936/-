package dynamicProgramming;
/**
 * ��Ǯ���ٵĻ�����
 * ��������arr��arr�����е�ֵ��Ϊ�����Ҳ��ظ���ÿ��ֵ����һ����ֵ�Ļ��ң�ÿ����ֵ�Ļ��ҿ���ʹ��һ�ţ��ٸ���
 * һ������aim����Ҫ�ҵ�Ǯ���������aim�����ٻ�����
 * @author wushijia
 *
 */
public class MinCoins_2 {
	public static int minCoins2(int[] arr,int aim){
		if(arr == null || aim < 0 || arr.length == 0){
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][aim + 1];
		//��ʼ����һ��
		for(int i = 0;i <= aim;i++){
			dp[0][i] = max;
		}
		if(arr[0] < aim){
			dp[0][arr[0]] = 1;
		}
		int left = 0;
		for(int i = 1;i < n;i++){//��
			for(int j = 1;i <= aim;j++){//��
				left = max;
				if(j-arr[i] >=0 && dp[i-1][j-arr[i]] != max){
					left = dp[i-1][j-arr[i]]+1;
				}
				dp[i][j] = Math.min(left, dp[i-1][j]);
			}
		}
		return dp[n-1][aim] != max?dp[n-1][aim] : -1;
	}
}
