package string;
/**
 * �ж������ַ����Ƿ�Ϊ���δ�
 * @author wushijia
 *���������ַ��������������ַ����г��ֵ��ַ�����һ�����Ҵ���Ҳһ�����ͷ���true�����򷵻�false
 */
public class S_242 {
	public static boolean isDeformation(String str1,String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		char[] str1c = str1.toCharArray();
		char[] str2c = str2.toCharArray();
		int[] arr = new int[256];
		for(int i = 0; i<str1c.length;i++){
			arr[str1c[i]]++;
		}
		for(int i = 0;i<str2c.length;i++){
			if(arr[str2c[i]]-- == 0){//�´�ʹ��ʱ��С��0��
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String str1 = "123";
		String str2 = "345";
		boolean b = isDeformation(str1,str2);
		System.out.println(b);
	}
}
