package tanxin;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ���룺 ����1����������costs ����2����������profits ����3������k ����4������m
costs[i]��ʾi����Ŀ�Ļ��� profits[i]��ʾi����Ŀ�ڿ۳�����֮����������Ǯ(����) k��ʾ�㲻�ܲ��С�ֻ�ܴ��е������k����Ŀ m��ʾ���ʼ���ʽ�
˵������ÿ����һ����Ŀ�����ϻ�õ����棬����֧����ȥ����һ�� ��Ŀ��
����� ������õ����Ǯ��
 * @author wushijia
 *
 */
public class I_P_O {
	public static class Node{
		public int c;//��ʾ��Ŀ�������ʽ�
		public int p;//��ʾ�����Ŀ���õ�����
		public Node(int c,int p){
			this.c = c;
			this.p = p;
		}
	}
	public static class MaxComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			if(o1.p > o2.p){
				return -1;
			}else if(o1.p < o2.p){
				return 1;
			}
			return 0;
		}
		
	}
	public static class MinComparator implements Comparator<Node>{
		
		@Override
		public int compare(Node o1, Node o2) {
			if(o1.c > o2.c){
				return 1;
			}else if(o1.c < o2.c){
				return -1;
			}
			return 0;
		}
		
	}
	private static int getMaxMoney(int[] costs,int[] profits,int k,int m){
		Node[] nodes = new Node[costs.length];
		for(int i = 0;i < profits.length;i++){
			nodes[i] = new Node(costs[i],profits[i]);
		}
		PriorityQueue<Node> minQ = new PriorityQueue<>(new MinComparator());//С���ѣ���ʼ�����������Ŀ
		PriorityQueue<Node> maxQ = new PriorityQueue<>(new MaxComparator());//����ѣ�����ܹ�������Ŀ
		for(int i = 0;i < nodes.length;i++){
			minQ.add(nodes[i]);
		}
		int res = m;
		for(int i = 0;i < k;i++){
			while(!minQ.isEmpty() && minQ.peek().c < res){//�������ʽ�С��m�ķ�������
				maxQ.add(minQ.poll());
			}
			if(maxQ.isEmpty()){//�������û��nodeʱ�����Է���
				return res;
			}
			res = res + maxQ.poll().p;//ÿ������һ����Ŀ�ͼ�������
		}
		return res;
	}
	public static void main(String[] args) {
		
	}
	
}
