package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * @author wushijia
 * ��Ŀ����������һ���άƽ���ϵ�����������ߵ�������
 */
public class Max_points_on_a_line {
    public int maxPoints(Point[] points) {
        if(points.length <= 2){
        	return points.length;
        }
        int res = 0;
        for(int i = 0;i < points.length;i++){
        	Map<Double,Integer> map = new HashMap<>();//ÿ�ζ���Ҫ���¶���map
        	int max = 1;//1����Ϊ��ǰ����ʼ��
        	int ptr = 0;//��������ͬ�ĵ�
        	int c = 0;//�ظ�
        	for(int j = 0;j < points.length;j++){
        		if(j != i){
        			double x1 = points[i].x - points[j].x;//���������
        			double y1 = points[i].y - points[j].y;
        			if(x1 == 0 && y1 == 0){//�غ�
        				c++;
        			}else if(x1 == 0){//��������ͬ
        				if(ptr == 0){
        					ptr = 2;
        				}else{
        					ptr++;
        				}
        				max = Math.max(max, ptr);
        			}else{
        				double k = y1/x1;
        				if(map.get(k) == null){
        					map.put(k, 2);
        				}else{
        					map.put(k, map.get(k)+1);
        				}
        				max = Math.max(map.get(k), max);
        			}
        		}
        	}
        	res = Math.max(max+c, res);//ÿ��ȡ���ģ�ע��
        }
        return res;
    }
}
