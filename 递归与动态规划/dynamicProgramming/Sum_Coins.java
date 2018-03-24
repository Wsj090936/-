package dynamicProgramming;
/**
 * ��������arr��arr�����е�ֵ��Ϊ�����в��ظ���ÿ��ֵ����һ����ֵ�Ļ��ң�ÿ��
 * ��ֵ�Ļ��ҿ���ʹ�������ţ��ڸ���һ��aim����Ҫ�ҵ�Ǯ������Ǯ�ķ�������
 * @author wushijia
 *
 */
public class Sum_Coins {
	public static int coins(int[] arr,int aim){
		if(arr == null || aim < 0){
			return 0;
		}
//		int[][] map = new int[arr.length + 1][aim + 1];
		return process2(arr,aim);
	}

	private static int process1(int[] arr, int index, int aim) {
		int res = 0;
		if(index == arr.length){
			res = aim == 0 ? 1 : 0;
		}else{
			for(int i = 0;arr[index]*i <= aim;i++){
				res += process1(arr,index+1,aim-arr[index]*i);
			}
		}
		return res;
	}
	
	private static int process1(int[] arr, int index, int aim,int[][] map) {//�Ż�һ
		int res = 0;
		if(index == arr.length){//��ʱ˵���Ѿ��ҵ����һ������
			res = aim == 0 ? 1 : 0;
		}else{
			int mapValue = 0;
			for(int i = 0;arr[index]*i <= aim;i++){
				mapValue = map[index + 1][aim-arr[index]*i];//������һ��֮ǰ�Ȳ鿴֮ǰ�ǲ��Ǽ������
				if(mapValue != 0){//�������
					res += mapValue == -1 ? 0 : mapValue;
				}else{//û�м����
					res += process1(arr,index+1,aim-arr[index]*i,map);
				}
			}
		}
		map[index][aim] =  res == 0 ? -1 : res; //-1�ò���֮ǰ�����������ֵΪ0. ��0��ʾû�м����
		return res;
	}
	
	private static int process2(int[] arr,int aim){
		if(arr == null || aim < 0){
			return 0;
		}
		int row = arr.length;//
		int col = aim + 1;
		int[][] dp = new int[row][col];//��һ�б�ʾʹ��arr[0]ʱ�ܹ���ɵ�С�ڵ���aim�Ļ��ҵ�Ǯ��
									   //��һ�б�ʾʹ��Ǯ��Ϊ0�ķ�������������Ϊ1
		for(int i = 0;i < row;i++){//��ʼ����һ��
			dp[i][0] = 1;
		}
		for(int j = 1;arr[0]*j <= aim;j++){//��ʼ����һ��  ����arr[0]=5,����ֻ��5�ܹ���ɵı����ķ���ֻ��һ��
			dp[0][arr[0]*j] = 1;
		}
//		int num = 0;
		for(int i = 1;i < arr.length;i++){
			for(int j = 0;j <= aim;j++){//j������Ҫ�ҵ�Ǯ��
/*				num = 0;
				for(int k = 0;j-arr[i]*k >= 0;k++){					
					num += dp[i - 1][j - arr[i]*k];//��¼�ܷ�����		
				}
				dp[i][j] = num;*/
				dp[i][j] = dp[i - 1][j];//��ȫ����arr[i]
				if(j - arr[i]>=0){
					dp[i][j] += dp[i][j - arr[i]];
				}
			}
		}
		return dp[row - 1][aim];
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{5,10,25,1};
		int aim = 15;
		System.out.println(coins(arr,15));
	}
}
