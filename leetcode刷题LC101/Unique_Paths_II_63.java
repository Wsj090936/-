package algorithms;
/**
 *  Follow up for "Unique Paths":

	Now consider if some obstacles are added to the grids. How many unique paths would there be?
		
	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	
	For example,
	There is one obstacle in the middle of a 3x3 grid as illustrated below.
	
	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
	The total number of unique paths is 2.
	
	Note: m and n will be at most 100.
 * @author wushijia
 *�����ֻ��Ҫע���һ�к͵�һ����ֻҪ��һ���ط�Ϊ1����ô���л��߸��к�������и��Ӷ�û�п��Ե����·��
 */
public class Unique_Paths_II_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0){
            return 0;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] arr = new int[rows][cols];
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(obstacleGrid[i][j] == 1){
                    arr[i][j] = 0;
                }else if(i == 0 && j == 0){
                    arr[i][j] = 1;
                }else if(i == 0){
                    arr[i][j] = arr[i][j - 1] * 1;//������ϰ����޷�����
                }else if(j == 0){
                    arr[i][j] = arr[i -1][j] * 1;
                }else
                    arr[i][j] = arr[i -1][j] + arr[i][j - 1];
            }
        }
        return arr[rows - 1][cols - 1];
    }
}
