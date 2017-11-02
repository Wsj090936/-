package algorithms2;

import java.util.Stack;

public class OrderRecur {
	public void preOrderRecur(Node2 root){//�������
		if(root != null){
			Stack<Node2> stack = new Stack<>();
			stack.add(root);
			while(!stack.isEmpty()){
				Node2 ptr = stack.pop();
				System.out.println(ptr.value);
				if(ptr.right != null){
					stack.push(ptr.right);
				}
				if(ptr.left != null){
					stack.push(ptr.left);
				}
			}
		}
	}
	public void inOrderRecur(Node2 root){//�������
		if(root != null){
			Stack<Node2> stack = new Stack<>();
			while(!stack.isEmpty() || root != null){
				if(root != null){
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					System.out.println(root.value);
					root = root.right;
				}
			}
		}
	}
	public void posOrderRecur(Node2 root){//�������
		if(root != null){
			Stack<Node2> stack1 = new Stack<>();
			Stack<Node2> stack2 = new Stack<>();
			stack1.push(root);
			while(!stack1.isEmpty()){
				root = stack1.pop();
				stack2.push(root);//ÿ�ν�stack1�е����ݵ�����ѹ��ջ�У�Ȼ��stack2�е�����ȫ�����������õ��ľ��Ǻ��������˳��
				if(root.left != null){
					stack1.push(root.left);
				}
				if(root.right != null){
					stack1.push(root.right);
				}
			}
			while(!stack2.isEmpty()){
				System.out.println(stack2.pop().value);
			}
		}
	}
}
