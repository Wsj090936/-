package algorithms2;
/**
 * ��ӡ�������ı߽�ڵ�
 * 				1
 * 			  /    \
 * 			 /      \
 * 			/        \
 * 		   /     	  3
 * 		  /           /\
 * 	     2			 5  6	   
 * 	      \   		/\  
 * 	       4 	   9  10
 * 	      / \     /
 * 	     7   8    12
 * 	    	  \    /\
 * 	     	   11 15 16
 * 	     	  /  \
 * 	     	 13   14
 * �磬���ϵ���Ӧ�ô�ӡ 1 2 4 7 11 13 14 15 16 12 10 6 3 
 * @author wushijia
 *
 */
public class PrintEdge {
	public void fun1(Node2 root){
		if(root == null){
			return;
		}
		int h = getHeight(root,0);
		Node2[][] edgeMap = new Node2[h][2];//�����벿�ֵı߽�ڵ���Ұ벿�ֵı߽�ڵ�
		initEdgeMap(root,0,edgeMap);
		for(int i = 0;i != edgeMap.length;i++){//��ӡ������߽�
			System.out.println(edgeMap[i][0].value);
		}
		//��ӡ�Ȳ�����߽磬�ֲ����б߽��Ҷ�ӽ��
		printNoneLR(root,0,edgeMap);
		//��ӡ�ұ߽磬��������߽�
		for(int i = edgeMap.length - 1;i != -1;i--){
			if(edgeMap[i][0] != edgeMap[i][1]){
				System.out.println(edgeMap[i][1].value);
			}
		}
		
	}
	private int getHeight(Node2 root,int i){//�õ��������ĸ߶�
		if(root == null){
			return 1;
		}
		return Math.max(getHeight(root.left,i + 1), getHeight(root.right,i + 1));
	}
	private void initEdgeMap(Node2 root,int h,Node2[][] edgeMap){//��ʼ�����飬��[x][0]�����벿�ֱ߽�ڵ㣬[x][1]����Ұ벿�ֽڵ�
		if(root == null){
			return;
		}
		edgeMap[h][0] = edgeMap[h][0] == null ? root : edgeMap[h][0];//�����߽�ڵ�
		edgeMap[h][1] = root;//����ұ߽�ڵ�
		initEdgeMap(root.left,h + 1,edgeMap);
		initEdgeMap(root.right,h + 1,edgeMap);
	}
	private void printNoneLR(Node2 root,int i,Node2[][] edgeMap){//��ӡ�Ȳ�����߽��ֲ����б߽�Ľڵ�
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null && root != edgeMap[i][0] && root != edgeMap[i][1]){
			System.out.println(root.value);
		}
		printNoneLR(root.left,i + 1,edgeMap);
		printNoneLR(root.right,i + 1,edgeMap);
	}
}
