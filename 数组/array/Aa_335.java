package array;
/**
 * ��һ��������  ֮���δ�ӡ
 * @author wushijia
 *
 */
public class Aa_335 {
	public static void printArray(int[][] arr){
		int lx = 0;
		int ly = 0;
		int rx = 0;
		int ry = 0;
		boolean dst = false;//true��ʾ���ϵ��´�ӡ����֮Ϊ���ϵ��´�ӡ
		int endx = arr.length - 1;
		int endy = arr[0].length - 1;
		while(lx <= endx){
			printA(arr,lx,ly,rx,ry,dst);
			lx = ly == endy?lx+1:lx;//����������ֹԽ��ͽ�ʣ������ӡ��ȫ
			ly = ly == endy?ly:ly+1;
			ry = rx == endx?ry+1:ry;
			rx = rx == endx?rx:rx+1;
			dst = !dst;
		}
	}
	private static void printA(int[][] arr,int lx,int ly,int rx,int ry,boolean dst){
		if(dst){//���ϵ���
			while(lx != rx+1){
				System.out.print(arr[lx++][ly--]+" ");
			}
		}else{//���µ���
				while(rx != lx-1){
					System.out.print(arr[rx--][ry++]+" ");
				}
		}
	}
	public static void main(String[] args) {
		int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		printArray(arr);
	}
}
