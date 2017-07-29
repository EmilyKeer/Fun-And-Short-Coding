/*
Implement strStr function in O(n + m) time.

strStr return the first index of the target string in a source string. The length of the target string is m and the length of the source string is n.
If target does not exist in source, just return -1.

Have you met this question in a real interview? Yes
Example
Given source = abcdef, target = bcd, return 1.

http://www.lintcode.com/en/problem/strstr-ii/#

Hint:
null
target hashcode
source for loop hashcode
	takeout (power)
if code == string equals

Special things: 
%BASE to keep all the values always in a range

*/

public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public int BASE = 1000000;
    public int strStr2(String source, String target) {
        // Write your code here
        if(target == null || source == null) return -1;
        
        //"" ""  or "a" ""
        if (target.length() == 0) return 0;
        
        //(bef*31+curChar)%BASE
        int len = target.length();
        int power = 1;
        //31^len
        for (int i=0; i<len; i++) {
            power = power*31%BASE; //in a range
        }
        
        int targetCode = 0;
        for(int i=0; i<len; i++) {
            targetCode = (targetCode*31 + target.charAt(i))%BASE;
        }
        
        int hashCode = 0;
        for(int i=0; i<source.length(); i++) {
            hashCode = (hashCode*31 + source.charAt(i))%BASE;
            
            if (i<len-1) {
                continue;
            }
            if (i>=len) {
                hashCode = hashCode - (source.charAt(i-len)*power)%BASE;
                if (hashCode<0) {
                    hashCode = hashCode+BASE;
                }
            }
            
            if (hashCode == targetCode) {
                if ((source.substring(i-len+1, i+1)).equals(target)) {
                    return i-len+1;
                }
            }
        }
        
        return -1;
    }
}