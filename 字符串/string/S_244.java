package string;
/**
 * ��ӡ�ַ��������������ִ��ĺ�
 * @author wushijia
 *�磺
 *	"A12B3"�����15
 *	"A-12B--3"�����-9
 */
public class S_244 {
	public static int getSum(String str){
		if(str == ""||str == null){
			return 0;
		}
		char[] array = str.toCharArray();
		int res = 0;
		int num = 0;
		boolean b = true;//true��ʾ��ǰ��Ϊ������֮���ʾΪ��
		int cur = 0;
		for(int i = 0;i < array.length;i++){
			cur = array[i] - '0';//�����Ϳ������0-9��
			if(cur < 0 || cur > 9){//����Ϊ0-9
				res = res + num;
				num = 0;
				if(array[i] == '-'){
					if(i - 1 >-1 &&array[i-1] == '-'){//�������ϵĸ���ʱ
						b = !b;
					}else{
						b = false;
					}
				}
			}else{
				num = num*10+(b?cur:-cur);//�ж�����
			}
		}
		res = res + num;//���һ�ν�num�е�ֵ����
		return res;
	}
	public static void main(String[] args) {
		String str = "ABC126D";
		int sum = getSum(str);
		System.out.println(sum);
	}
}
