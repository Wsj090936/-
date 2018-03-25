package other;
/**
 * ��ʱ�ҵ�����������λ��
����Ŀ�� ��һ��ԴԴ���ϵ��³������������������������㹻�Ŀռ��� �����³�������
�����һ������MedianHolder�Ľṹ�� MedianHolder������ʱȡ��֮ǰ�³�����������λ����
��Ҫ�� 1�����MedianHolder�Ѿ��������³���N��������ô����ʱ�� ��һ���������뵽MedianHolder�Ĺ��̣�
��ʱ�临�Ӷ��� O(logN)��
 		2��ȡ���Ѿ��³���N�����������λ���Ĺ��̣�ʱ�临�Ӷ�Ϊ O(1)
 * @author wushijia
 *
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianHolder {
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());//�����
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());//С����
	
	public void modifyHeap(){//��֤�����ѵ�size֮�����1
		if(maxHeap.size() == minHeap.size()+2){//����Ѵ���
			minHeap.add(maxHeap.poll());
		}
		if(minHeap.size() == maxHeap.size()+2){//С���Ѵ���
			maxHeap.add(minHeap.poll());
		}
	}
	public void addNumber(int num){
		if(this.maxHeap.isEmpty()){
			this.maxHeap.add(num);
		}
		if(this.maxHeap.peek() >= num){
			this.maxHeap.add(num);
		}else{//����ȴ���ѵĵ�һ��ֵС����ӵ�С����
			if(this.minHeap.isEmpty()){
				this.minHeap.add(num);
				return;
			}
			if(this.minHeap.peek() > num){//��С���ѶѶ�С
				//��ӵ������
				this.maxHeap.add(num);
			}else{
				this.minHeap.add(num);
			}
		}
		modifyHeap();
	}
	public Integer getMid(){
		int maxsize = this.maxHeap.size();
		int minsize = this.minHeap.size();
		if(maxsize + minsize == 0){
			return null;
		}
		Integer maxhead = this.maxHeap.peek();
		Integer minhead = this.minHeap.peek();
		if((maxsize + minsize)%2 == 0){//ż��������
			return (maxhead+minhead)/2;
		}
		return maxsize > minsize ? maxhead : minhead;
	}
}

class MaxHeapComparator implements Comparator<Integer>{//������õıȽ���

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 < o2){
			return 1;//����1��ʾ����ķ�ǰ���������;
		}else{//-1��ʾǰ��ķ�ǰ���������
			return -1;
		}
	}
	
}
class MinHeapComparator implements Comparator<Integer>{//С�����õıȽ���

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 > o2){
			return 1;
		}else{
			return -1;
		}
	}
	
}