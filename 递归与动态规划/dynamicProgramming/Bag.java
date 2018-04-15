package dynamicProgramming;
/**
 * ������������w��v���������鳤����ȣ�w[i]��ʾ��i����Ʒ�� ������v[i]��ʾ��i����Ʒ�ļ�ֵ��
 *  �ٸ���һ������bag��Ҫ������ѡ��Ʒ������������һ�����ܳ� ��bag������������������£����ܻ�õ�����ֵ
 * @author wushijia
 *
 */
public class Bag {
	public static int getMaxValue(int[] weight,int[] value,int bag){
		return getMax(weight,value,0,0,bag);
	}
	private static int getMax(int[] weight,int[] value,int i,int nowWeight,int bag){
		if(nowWeight > bag){
			return Integer.MIN_VALUE;
		}
		if(i == weight.length){//������ĩβ,�ݹ鷵��
			return 0;
		}
		return Math.max(getMax(weight,value,i + 1,nowWeight,bag), //��ѡ��i��
						value[i] + getMax(weight,value,i + 1,weight[i] + nowWeight,bag));//ѡ���i��
	}
	public static int getMaxValue2(int[] weight,int[] value,int bag){
		int[][] dp = new int[weight.length + 1][bag + 1];
		for(int i = weight.length-1;i>=0;i--){
			for(int j = bag;j>=0;j--){
				dp[i][j] = dp[i + 1][j];//��ѡi,j��ʾ��ǰ����
				if(j + weight[i] <= bag){
					dp[i][j] = Math.max(dp[i][j], value[i] + dp[i + 1][j + weight[i]]);
				}
			}
		}
		return dp[0][0];
	}
}
