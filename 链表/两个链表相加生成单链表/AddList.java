package algorithms2;

import java.util.Stack;
/**
 *��������������ɵ�����ÿһ���ڵ����ֵС��10
 * @author wushijia
 *
 */
public class AddList {
	public Node fun1(Node head1,Node head2){
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		while(head1 != null){
			s1.push(head1.value);
			head1 = head1.next; 
		}
		while(head2 != null){
			s2.push(head2.value);
			head2 = head2.next;
		}
		int n1 = 0;//����һ�ļ���
		int n2 = 0;//������ļ���
		int n = 0;//���ú�
		int a = 0;//��λ
		Node cur = null;//�ָ��
		Node res = null;//�ָ��
		while(!s1.isEmpty() && !s2.isEmpty()){
			n1 = s1.isEmpty() ? 0 : s1.pop();//��������
			n2 = s2.isEmpty() ? 0 : s2.pop();//��������
			n = n1 + n2 + a;
			cur = res;
			res = new Node(n % 10);
			res.next = cur;//β�巨����ڵ�
			a = n/10;//������λ
		}
		if(a == 1){//���λ�н�λʱ��������һ���ڵ�
			cur = res;
			res = new Node(1);
			res.next = cur;
		}
		return res;
	}
}
