package app6;
/**  
 * 面试题47：不用加减乘除做加法
 * 题目：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号   
 * 
 * 思路：
 * 位运算分为三步完成，5的二进制是101，17的二进制是10001。第一步各位相加但不计进位，得到的结果是10100（最后一位两个数都是1，相加的
 * 结果是二进制的10。这一步不计进位，因此结果仍然是0）；第二步记下进位。在这个例子中只在最后一位相加时产生一个进位，结果是二进制的10；
 * 第三步把前两步的结果相加，得到的结果是10110，转换为十进制正好是22。由此可见三步走的策略对二进制也是适用的。
 * 接下来我们试着把二进制的加法用位运算来替代。第一步不考虑进位对每一位相加。0加0、1加1的结果都是0，0加1、1加0的结果都是1。
 * 我们注意到，这和异或的结果是一样的。接着考虑第二步进位，只有对1加1产生1个进位。此时我们可以想象成是这两个数先做位与运算，然后再向左移动一位。
 * 只有两个数都是1的时候，结果才为1，其余都是0。第三步把前两个步骤的结果相加。第三步相加的过程依然是重复前面两步，直到不产生进位为止。
 * 
 * 本题考点：
 * 1. 考查发散思维能力。
 * 2. 考查对二进制和位运算的理解。
 * 
 * 相关问题：
 * 1. 不使用新的变量，交换两个变量的值。比如有两个变量a，b，我们希望交换它们的值。有两种不同的方法。
 *    a = a + b; b = a - b; a = a - b;
 *    a = a ^ b; b = a ^ b; a = a ^ b;
 *  
 * @author 郑元浩 
 * @date 2017年4月6日 上午9:24:15 
 */
public class T47_Add {

	public static void main(String[] args) {

	}
	
	public static int add(int num1, int num2) {
		int sum = 0;
		int carry = 0;
		do {
			sum = num1 ^ num2;
			carry = num1 & num2;
			
			num1 = sum;
			num2 = carry;
		} while (carry != 0);
		
		return num1;
	}

}