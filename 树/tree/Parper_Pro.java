package tree;
/**
 * ��ֽ����
 * ���һ��ֽ�����ŷ��������ϣ�Ȼ���ֽ�����±����Ϸ�����1�Σ�
 * ѹ���ۺۺ�չ������ʱ �ۺ��ǰ���ȥ�ģ����ۺ�ͻ��ķ���ָ��ֽ���ı��档
 * �����ֽ�����±����Ϸ���������2 �Σ�ѹ���ۺۺ�չ������ʱ�������ۺۣ����ϵ������������ۺۡ�
 * ���ۺۺ����ۺۡ�����һ ���������N������ֽ�������±����Ϸ���������N�Σ�����ϵ��´�ӡ�����ۺ۵ķ���
 * @author wushijia
 *��ʵ������Ƕ��������������
 */
public class Parper_Pro {
	public static void printDownUp(int n){
		if(n < 1){
			return;
		}
		printParper(1,n,true);//true��ʾ���£�����ȥ��
	}
	private static void printParper(int i,int n,boolean down){
		if(i > n){
			return;
		}
		printParper(i + 1,n,true);
		System.out.println(down ? "down" : "up");
		printParper(i + 1,n,false);
	}
}
