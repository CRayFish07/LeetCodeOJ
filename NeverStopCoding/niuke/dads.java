package niuke;
 
import java.util.*;
 
/**
 * Created by markzuo on 15-5-18.
 */
public class dads {
    private int n;
 
    public dads(int n) {
        this.n = n;
    }
 
    public void print() {
        int[][] data = new int[n][n];
 
        data[0][0] = 1;
        data[n-1][n-1] = n * n;
 
        //�������ξ�����ص㣬��Ϊ���������֣���б��Ϊ��λ�������ݣ���1��ʼ���
        //�����󽫴�������Ϊ��ʼ
        //Top:�ϰ벿�֣�����Խ��ߣ�б����Ϊk,1<=k<=(n-1),���ھ������n��������ż��k����
        //ÿ��б�ߵ���С���ɵ������У���1Ϊ��ʼ
        for (int k = 1; k <= n-1; k++) {
            if (k % 2 == 1) {  //��kΪ����ʱ��û���ߵ���С�����Ϸ�
                data[0][k] = 1 + k * (k + 1)/2;
 
                for (int i = 1; i <= k; i++) { //ÿ������Ҫ����k������
                    data[i][k-i] = data[0][k] + i; //������֮��Ϊk,�������¼��㣬�еݼ�
                }
            } else {//��kΪż��ʱ��û���ߵ���С�����·�
                data[k][0] = 1 + k * (k + 1)/2;
 
                for (int i = 1; i <= k; i++) {
                    data[k-i][i] = data[k][0] + i;
                }
            }
        }
 
        //Down:�ϰ벿�֣�������Խ��ߣ�б����Ϊk,1<=k<=(n-2),���ھ������n������ż��kҲ����
        ////ÿ��б�ߵ�������ɵݼ����У���n*nΪ��ʼ
        if (n % 2 == 1) {//nΪ����
            for (int k = 1; k <= n - 2; k++) {
                if (k % 2 == 0) { //���kΪż������������·�
                    data[k][n-1] = data[n-1][n-1] - (n - k - 1) * (n - k)/2;
                    for (int i = 1; i < n - k; i++) { //�������£����μ���n-1-k������
                        data[i + k][n-1-i] = data[k][n-1] - i;  //�е������еݼ�����Ϊn+k-1
                    }
                } else {//���kΪż������������·�
                    data[n - 1][k] = data[n - 1][n - 1] - (n - k - 1) * (n - k) / 2;
                    for (int i = 1; i < n - k; i++) { //�������ϣ����μ���n-1-k������
                        data[n - 1 - i][i + k] = data[n - 1][k] - i;  //�еݼ����е�������Ϊn+k-1
                    }
                }
            }
 
        } else { //nΪ������������ż������෴
            for (int k = 1; k <= n - 2; k++) {
                if (k % 2 == 1) { //���kΪ��������������·�
                    data[n-1][k] = data[n-1][n-1] - (n - k - 1) * (n - k)/2;
                    for (int i = 1; i < n - k; i++) { //�������£����μ���n-1-k������
                        data[n-1-i][i+k] = data[n-1][k] - i;  //�еݼ����е�������Ϊn+k-1
                    }
                } else {//���kΪż������������Ϸ�
                    data[k][n-1] = data[n - 1][n - 1] - (n - k - 1) * (n - k) / 2;
                    for (int i = 1; i < n - k; i++) { //�������ϣ����μ���n-1-k������
                        data[i+k][n-i-1] = data[k][n-1] - i;  //�е������еݼ�����Ϊn+k-1
                    }
                }
            }
        }
 
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
 
    }
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        System.out.println("������һ�����ξ���Ľ�����");
        dads sn = new dads(scan.nextInt());
        sn.print();
    }
}