package niuke;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class getPalindromeLength {
    
    public static int getPalindromeLength(String str) {
        // 1.�����µ��ַ���
        // Ϊ�˱����������ĺ�ż�����ĵĲ�ͬ�������⣬��ԭ�ַ����в���'#'�������л��ı����������
        StringBuilder newStr = new StringBuilder();
        newStr.append('#');
        for (int i = 0; i < str.length(); i ++) {
            newStr.append(str.charAt(i));
            newStr.append('#');
        }
        
        // rad[i]��ʾ��iΪ���ĵĻ��ĵ����뾶��i����Ϊ1�������ַ�����
        int [] rad = new int[newStr.length()];
        // right��ʾ��֪�Ļ����У����ҵı߽������
        int right = -1;
        // id��ʾ��֪�Ļ����У�ӵ�����ұ߽�Ļ��ĵ��е�����
        int id = -1;
        // 2.�������е�rad
        // ����㷨��O(n)�ģ���Ϊrightֻ���������while�ĵ�����������������١�
        for (int i = 0; i < newStr.length(); i ++) {
            // 2.1.ȷ��һ����С�İ뾶
            int r = 1;
            if (i <= right) {
                r = Math.min(rad[id] - i + id, rad[2 * id - i]);
            }
            // 2.2.���Ը���İ뾶
            while (i - r >= 0 && i + r < newStr.length() && newStr.charAt(i - r)
            		== newStr.charAt(i + r)) {
                r++;
            }
            // 2.3.���±߽�ͻ�����������
            if (i + r - 1> right) {
                right = i + r - 1;
                id = i;
            }
            rad[i] = r;
        }
        
        // 3.ɨ��һ��rad���飬�ҳ����İ뾶
        int maxLength = 0;
        for (int r : rad) {
            if (r > maxLength) {
                maxLength = r;
            }
        }
        return maxLength - 1;
    }
 
    
    public static void main(String[] args) throws FileNotFoundException {
        int caseNum = 0;
      Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if (str.equals("END")) {
                break;
            } else {
                caseNum ++;
                System.out.println("Case " + caseNum + ": " + getPalindromeLength(str));
            }
        }
    }
 
}