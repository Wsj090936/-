package array;
/**
 * ��Ŀ���ڣ�p331
 * @author wushijia
 *
 */
public class Aa_331 {
	public void printArrayWithCycle(int[][] arr){
		int lx = 0;//���Ͻǵ�x��
		int ly = 0;//���Ͻǵ�y��
		int rx = arr.length-1;//���½�x��
		int ry = arr[0].length-1;//���½�y��
		while(lx <= rx && ly <= ry){
			printCycle(arr,lx++,ly++,rx--,ry--);
		}
	}
	private void printCycle(int[][] arr,int lx,int ly,int rx,int ry){
		if(ly == ry){//��ֻ��һ��ʱ
			for(int i = ly;i <= ry;i++){
				System.out.println(arr[lx][i]+" ");
			}
		}else if(lx == rx){//��ֻ��һ��
			for(int i = lx;i <= rx;i++){
				System.out.println(arr[i][ly]+" ");
			}
		}else{//��������
			int cur = lx;//�����Ͻ�x��ʼ
			int ptr = ly;//�����Ͻ�y��ʼ
			while(ptr != ry){
				System.out.println(arr[lx][ptr]+"");
				ptr++;
			}
			while(cur != rx){
				System.out.println(arr[cur][ry]+" ");
				cur++;
			}
			while(ptr != ly){
				System.out.println(arr[rx][ptr]+" ");
				ptr--;
			}
			while(cur != lx){
				System.out.println(arr[cur][ly]+" ");
				cur--;
			}
		}
	}
	public static void main(String[] args) {
		Aa_331 test = new Aa_331();
		int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		test.printArrayWithCycle(arr);
	}
}
