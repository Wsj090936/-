package array;


/**
 * ��һ������ֱ�ʵ��ջ�Ͷ��нṹ
 * @author wushijia
 *
 */
public class MyStack_Queue_WithArray {
	public static class ArrayStack{
		public Integer[] arr;
		public int index;//��ʾջ��Ԫ�ص�����һ��λ��
		public ArrayStack(Integer len) {
			if(len <= 0){
				throw new IllegalArgumentException("the stack size is less than 1");
			}
			arr = new Integer[len];
			index = 0;
		}
		public void push(Integer data){
			if(arr.length == index){
				throw new IllegalArgumentException("the stack is full");
			}
			arr[index++] = data;
		}
		public Integer peek(){
			if(index == 0){
				return null;
			}
			return arr[index-1];
		}
		public Integer pop(){
			if(index == 0){
				throw new ArrayIndexOutOfBoundsException("the stack is empty");
			}
			return arr[--index];
		}
	}
	public static class ArrayQueue{
		public Integer[] arr;
		public Integer size;//��ʾ���е�ǰ�Ĵ�С
		public Integer end;//������ӵ�ָ��
		public Integer start;//���𵯳�����ָ��
		public ArrayQueue(Integer len){
			if(len <= 0){
				throw new IllegalArgumentException("the queue size is less than 1");
			}
			arr = new Integer[len];
			this.size = 0;
			this.end = 0;
			this.start = 0;
		}
		public void add(Integer data){
			if(size == arr.length){
				throw new IllegalArgumentException("the queue is full");
				
			}
			size++;
			arr[end] = data;
			end = end == arr.length-1 ? 0 : end+1;//�ﵽ���鳤�Ⱦ�ѭ����ȥ
			
		}
		public Integer peek(){
			if(size == 0){
				return null;
			}
			return arr[start];
		}
		public Integer poll(){
			if(size == 0){
				throw new IllegalArgumentException("the queue is empty");
			}
			size--;
			int res = arr[start];
			start = start == arr.length-1 ? 0 : start+1;
			return res;
		}
	}
}
