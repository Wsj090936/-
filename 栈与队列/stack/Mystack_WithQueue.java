package stack;

import java.util.LinkedList;
import java.util.Queue;
/**
 * �ö���ʵ��ջ�ṹ
 * @author wushijia
 *
 */
public class Mystack_WithQueue {
	private Queue<Integer> queue = new LinkedList<>();
	private Queue<Integer> help = new LinkedList<>();
	public void push(Integer data){
		this.queue.add(data);
	}
	public Integer pop(){
		if(queue.isEmpty()){
			throw new RuntimeException("the queue is Empty");
		}
		int size = queue.size();
		while(size > 1){
			help.add(queue.poll());
		}
		int res = queue.poll();
		swap();
		return res;
	}
	public Integer peek(){
		if(queue.isEmpty()){
			throw new RuntimeException("the queue is Empty");
		}
		int size = queue.size();
		while(size != 1){
			help.add(queue.poll());
		}
		int res = queue.poll();
		help.add(res);//���������һ������������Ԫ���ٴμ���
		swap();
		return res;
	}
	
	private void swap(){//�������ߵ�����
		Queue<Integer> temp = queue;
		queue = help;
		help = queue;
	}
}
