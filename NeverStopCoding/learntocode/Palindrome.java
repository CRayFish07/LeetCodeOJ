package learntocode;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Is_palindrome_v1("noon");
//		Is_palindrome_v1("racecar");
//		Is_palindrome_v1("dented");
		
//		Is_palindrome_v2("noon");
//		Is_palindrome_v2("racecar");
//		Is_palindrome_v2("dented");
		
		Is_palindrome_v3("noon");
		Is_palindrome_v3("racecar");
		Is_palindrome_v3("dented");
		Is_palindrome_v3("denteddad");
	}
	
	public static String Reverse(String s){
		String rev = "";
		for(int i = 0; i < s.length(); i++){
			rev = s.charAt(i) + rev;
//			System.out.println(s.charAt(i));
		}
		return rev;
	}
	
	// �㷨1���ȽϷ�ת����ַ�����ԭ�����ǲ���һ���ģ�
	public static boolean Is_palindrome_v1(String s){
		String rev = Palindrome.Reverse(s);
		System.out.println(rev.equals(s));
		return rev.equals(s);
	}
	
	// �㷨2���ȽϺ�벿�ֵķ�ת��ǰ�벿���ǲ���һ���ģ�
	public static boolean Is_palindrome_v2(String s){
		int n = s.length();
		String before = s.substring(0, n / 2);
		String after = s.substring(n - n / 2, n);
		String rev = Palindrome.Reverse(after);
		System.out.println(rev.equals(before));
		return rev.equals(before);
	}
	
	// �㷨3���Ƚ��ַ���ǰ���ÿ���ַ��Ƿ���ͬ��
	public static boolean Is_palindrome_v3(String s){
		int i = 0;
		int j = s.length() - 1;
		while(i < j && s.charAt(i) == s.charAt(j)){
			i++;
			j--;
		}
		System.out.println(j <= i);
		return j <= i;
	}

}
