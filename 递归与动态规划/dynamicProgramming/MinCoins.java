package dynamicProgramming;
/**
 * ��Ǯ���ٵĻ�����
 * ��������arr��arr�����е�ֵ��Ϊ�����Ҳ��ظ���ÿ��ֵ����һ����ֵ�Ļ��ң�ÿ����ֵ�Ļ��ҿ���ʹ�������ţ��ٸ���
 * һ������aim����Ҫ�ҵ�Ǯ���������aim�����ٻ�����
 * @author wushijia
 *
 */
public class MinCoins {
	public static int minCoins1(int[] arr,int aim){
		if(arr == null || aim < 0){
			return -1;
		}
		int row = arr.length;
		int col = aim+1;
		int max = Integer.MAX_VALUE;//���Ҳ������ͽ�ֵ����Ϊmax
		int[][] dp = new int[row][col];//dp[o...row][0]��ʾ��Ҫ�ҵ�Ǯ��Ϊ0ʱ����Ҫ0..rowǮ������
		for(int j = 1;j < col;j++){//dp[0][x]��ʾֻ��ʹ��arr[0]��������ҵ�x����Ҫ��arr[0]������
			dp[0][j] = max;
			if((j-arr[0] >= 0) && (dp[0][j-arr[0]] != max)){//��ʼ����һ��
				dp[0][j] = dp[0][j - arr[0]] + 1;
			}
		}
		int temp = 0;
		for(int i = 1;i < row;i++){
			for(int j = 1;j < col;j++){
				temp = max;
				if(j - arr[i] >= 0 && dp[i][j - arr[i]] != max){
					temp = dp[i][j - arr[i]] + 1;//ֻʹ��arr[i]�����
				}
				dp[i][j] = Math.min(temp, dp[i - 1][j]);//dp[i - 1][j]��ʾ��ȫ��ʹ��arr[i]������±�ʾ����С����
			}
		}
		return dp[row - 1][aim] != max ? dp[row-1][aim] : -1;
	}
	public static int minCoins2(int[] arr,int aim){//�Ż��汾
		if(arr == null || aim < 0){
			return -1;
		}
		int row = arr.length;
		int max = Integer.MAX_VALUE;
		int[] dp = new int[row];
		for(int j = 1;j <= aim;j++){
			dp[j] = max;
			if((j-arr[0] >= 0) && (dp[j-arr[0]] != max)){
				dp[j] = dp[j - arr[0]] + 1;
			}
		}
		int temp = 0;
		for(int i = 1;i < row;i++){
			for(int j = 1;j <= aim;j++){
				temp = max;
				if(j - arr[i] >= 0 && dp[j - arr[i]] != max){
					temp = dp[j - arr[i]] + 1;
				}
				dp[j] = Math.min(temp, dp[j]);
			}
		}
		return dp[aim] != max ? dp[aim] : -1;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{5,2,3};
		int aim = 20;
		System.out.println(minCoins1(arr,aim));
	}
}
