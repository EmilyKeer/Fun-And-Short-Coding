/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Notice

Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Example
"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.
*/

/*
array, String index: out of bound?
*/
public class Solution {
    /*
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return true;
        }
        int start = 0;
        int end = s.length()-1;
        while(start < end) {
            while(start<end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while(start<end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            char startChar = Character.toLowerCase(s.charAt(start));
            char endChar = Character.toLowerCase(s.charAt(end));
            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}