package stack;

import java.util.Stack;
/**
 * ʵ��һ������getMin()���ܵ�ջ
 * Ҫ��getMin()��ʱ�临�Ӷ�ΪO(1)
 * @author wushijia
 *
 */
public class GetMinStack {
	private Stack<Integer> dataStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	public void push(Integer value){
		if(minStack.isEmpty()){
			minStack.push(value);
		}else if(value < getMin()){//�����ǰ�������С��ջ����СԪ��
			minStack.push(value);
		}else{//�������������ڵ�����Сֵ
			int newMin = minStack.peek();
			this.minStack.push(newMin);
		}
		this.dataStack.push(value);
	}
	public Integer pop(){
		if(this.dataStack.isEmpty()){
			throw new RuntimeException("the stack is empty");
		}
		this.minStack.pop();
		return this.dataStack.pop();
	}
	public Integer getMin(){
		if(minStack.isEmpty()){
			throw new RuntimeException("the stack is empty");
		}
		return minStack.peek();
	}
}
