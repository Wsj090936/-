package tree;
/**
 * ��ӡһ�����ı߽�ڵ�
 * @author wushijia
 *
 */
public class PrintEdge {
	public class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int data){
			this.value = data;
		}
	}
	public static void printNode(Node head){
		if(head == null){
			return;
		}
		//��һ����ά���齫�������еı߽�ڵ�ȫ�������ڸ�������
		//���ȵ���֪�������ĸ߶�
		int height = getHeight(head,0);
		Node[][] edgeMap = new Node[height][2];//��0��0����¼��һ�����߽磬(0,1)��¼�б߽磬�Դ�����
		setEdgeMap(edgeMap,head,0);
		for(int i = 0;i < edgeMap.length;i++){
			System.out.println(edgeMap[i][0].value+" ");
		}
		//Ȼ���ӡ�Ȳ�����߽磬�ֲ����б߽��Ҷ�ӽ��
		printNotEdgeNode(head,0,edgeMap);
		//��ӡ�ұ߽�ڵ㵫��������߽�
		for(int i = 0;i < edgeMap.length;i++){
			if(edgeMap[i][0] != edgeMap[i][1]){
				System.out.println(edgeMap[i][1]+" ");
			}
		}
	}
	private static void printNotEdgeNode(Node head, int i, Node[][] edgeMap) {
		if(head == null){
			return;
		}
		if(head.left == null && head.right == null && head != edgeMap[i][0] && head != edgeMap[i][1]){
			System.out.println(head.value);
		}
		printNotEdgeNode(head.left,i+1,edgeMap);
		printNotEdgeNode(head.right,i+1,edgeMap);
		
	}
	private static void setEdgeMap(Node[][] edgeMap,Node h,int l){//���߽�ȫ������ö�ά����
		if(h == null){
			return;
		}
		edgeMap[l][0] = edgeMap[l][0] == null ? h:edgeMap[l][0];
		edgeMap[l][1] = h;
		setEdgeMap(edgeMap,h.left,l+1);
		setEdgeMap(edgeMap,h.right,l+1);
	}
	private static int getHeight(Node head,int l){//�õ����ĸ߶�
		if(head == null){
			return l;
		}
		return Math.max(getHeight(head.left,l++), getHeight(head.right,l++));
	}
}
