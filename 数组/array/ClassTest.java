package array;

public class ClassTest {
	/**
	 * תȦ��ӡ��ά����
	 * @param arr
	 */
	public static void fun1(int[][] arr){
		int lx = 0;
		int ly = 0;
		int rx = arr.length - 1;
		int ry = arr[0].length - 1;
		while(lx <= rx && ly <= ry){
			printArryay(arr,lx++,ly++,rx--,ry--);
		}
	}

	private static void printArryay(int[][] arr, int lx, int ly, int rx, int ry) {
		if(lx == rx){//ֻ��һ��ʱ
			for(int i = 0;i<=ry;i++){
				System.out.println(arr[lx][i]+" ");
			}
		}else if(ly == ry){//��ֻ��һ��ʱ
			for(int i = 0;i<=rx;i++){
				System.out.println(arr[i][ly]+" ");
			}
		}else{//�������
			int cur = lx;
			int ptr = ly;
			while(ptr != ry){
				System.out.println(arr[lx][ptr++]+" ");
			}
			while(cur != rx){
				System.out.println(arr[cur++][ry]+" ");
			}
			while(ptr != ly){
				System.out.println(arr[rx][ptr--]+" ");
			}
			while(cur != lx){
				System.out.println(arr[cur--][ly]+" ");
			}
		}
	}
	
	
	/**
	 * "֮"���δ�ӡ����
	 * @param arr
	 */
	public void fun2(int[][] arr){
		int lx = 0;//�ұߵ�ָ��
		int ly = 0;
		int rx = 0;//��ߵ�ָ��
		int ry = 0;
		boolean flag = false;
		int endx = arr.length-1;
		int endy = arr[0].length - 1;
		while(lx <= endx){
			printA(arr,lx,ly,rx,ry,flag);
			lx = ly==endy?lx+1:lx;
			ly = ly==endy?ly:ly+1;
			ry = rx==endx?ry++:ry;
			rx = rx==endx?rx:rx++;
			flag = !flag;
		}
	}

	private void printA(int[][] arr, int lx, int ly, int rx, int ry, boolean flag) {
		if(flag){//���ϵ���
			while(lx <= rx){
				System.out.println(arr[lx++][ly--]+" ");
			}
		}else{//���µ���
			while(rx >= lx){
				System.out.println(arr[rx--][ry++]+" ");
			}
		}
	}
}
