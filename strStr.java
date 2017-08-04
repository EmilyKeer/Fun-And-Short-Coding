/*
For a given source string and a target string, you should output the first index(from 0) of target string in source string.

If target does not exist in source, just return -1.
http://www.lintcode.com/en/problem/strstr/#
*/


class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null) return -1;
        if (source.length() == 0 && target.length() == 0) {
            return 0;
        }
            for (int i=0; i<source.length(); i++) {
            int j=i;
            int k;
            for (k=0; k<target.length(); k++) {
                if (j<source.length() && target.charAt(k) == source.charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            if (k == target.length()) {
                return i;
            }
            
        }
    
        return -1;
    }
}

/*
check:
1. "" ""
2. null