package array;
/**
 * ��һ������Ķ�ά�����У�����һ��n����n���ڣ�����true���������ڣ�����false
 * ע�� ������Ķ�ά�����ʾ�к��ж��������
 * @author wushijia
 *
 */
public class FindSuminArray {
	public static boolean find(int[][] arr,int dst){
		int x = 0;
		int y = arr[0].length - 1;
		while(x < arr.length && y > -1){
			if(arr[x][y] == dst){
				return true;
			}else if(arr[x][y] > dst){
				y--;
			}else{
				x++;
			}
		}
		return false;
	}
}
