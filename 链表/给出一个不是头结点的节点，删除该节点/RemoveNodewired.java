package algorithms2;
/**
 * ���������е�һ���ڵ�node��Ҫ��ɾ�������еĸýڵ㣬���ǲ������������ͷ���
 * ˼·��
 * 		�����˽ڵ㣬Ҫ��ɾ���ýڵ㣬����û�и���ͷ��㣬�����ǵ��������Բ����ҵ��ýڵ��ǰһ���ڵ㣬
 * ��ˣ����Խ���ǰ�ڵ��ֵ��Ϊ��һ���ڵ㣬Ȼ����һ���ڵ�ɾ����������������ɾ�������Ľڵ㣬��������
 * ����ɾ�����һ���ڵ㣬��Ϊ���һ���ڵ�û����һ���ڵ㣬������Ҫ������ʾ���׳�һ���쳣
 * @author wushijia
 *
 */
public class RemoveNodewired {
	public void remove(Node node){
		if(node == null){
			return;
		}
		Node next = node.next;
		if(next == null){
			throw new RuntimeException("Can not remove the last Node");
		}
		node.value = next.value;
		node.next = next.next;
	}
}
