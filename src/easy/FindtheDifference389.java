package easy;

import java.util.HashMap;
import java.util.Map;

/**  
 * 389. Find the Difference   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 47624
Total Submissions: 93834
Difficulty: Easy
Contributors: Admin
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.   
 *  
 * @author 郑元浩 
 * @date 2017年1月18日 上午11:49:22 
 */
public class FindtheDifference389 {

	public static void main(String[] args) {
		System.out.println(findTheDifference("abcd", "abdcd"));
	}
	
	public static char findTheDifference(String s, String t) {
		Character result = ' ';
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(Character ch : s.toCharArray()){
        	if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
        }
        for(Character ch : t.toCharArray()){
        	if (!map.containsKey(ch)) {
        		result = ch;
				return ch;
			} else {
				map.put(ch, map.get(ch) - 1);
				if(map.get(ch) < 0){
					result = ch;
					return ch;
				}
			}
        }
        return result;
    }

}
