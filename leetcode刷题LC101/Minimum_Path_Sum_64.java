package algorithms;
/**
 *  Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	
	Note: You can only move either down or right at any point in time.
 * @author wushijia
 *����ֻ�������߻��������ߣ���˵������½�ֻ�ܴ����½ǵ�Ԫ����Ϸ������󷽵��Ȼ��ȡ������·����ֵ��С��һ������
 */
public class Minimum_Path_Sum_64 {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] arr = new int[rows][cols];
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(i == 0 && j == 0){
                    arr[i][j] = grid[i][j];
                }else if(i == 0){
                    arr[i][j] = arr[i][j -1] + grid[i][j];//��һ��
                }else if(j == 0){
                    arr[i][j] = arr[i - 1][j] + grid[i][j];//��һ��
                }else{
                    arr[i][j] = Math.min(arr[i - 1][j],arr[i][j - 1]) + grid[i][j];//ѡ����С��
                }
            }
        }
        return arr[rows - 1][cols - 1];
    }
}
