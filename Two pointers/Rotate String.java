/*
Given a string and an offset, rotate string by offset. (rotate from left to right)

Example
Given "abcdefg".

offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"
*/

/*
also check: offset >= str.length: mod
*/
public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0) {
            return;
        }
        offset = offset % str.length;
        reversePart(str, 0, str.length-1);
        reversePart(str, 0, offset-1);
        reversePart(str, offset, str.length-1);
    }
    private void reversePart(char[] str, int start, int end) {
        while(start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}