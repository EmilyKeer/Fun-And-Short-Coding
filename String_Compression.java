/*
 Implement a method to perform basic string compression using the counts of repeated characters.
 For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string would not
 become smaller than the original string, your method should return the original string. You can
 assume the string has only uppercase and lowercase letters (a-z).
 */

//Keer's solution
/**
  *runtime: O(p+k^2)
  * string concatenation operates in O(n^2) time

  1.for loop compare with the next char
  */
 public static String compressString (String str) {
     String newStr = new String();
     int len = str.length();
     int count = 1;
     char c = str.charAt(0);
     for (int i=0; i<len; i++) {
         if(i<len-1 && str.charAt(i+1) == c) {
             count++;
         }
         else {
            newStr += c;
            newStr += count;
            count = 1;
            if (i<len-1) {
                c = str.charAt(i + 1);
            }
         }
     }
     if (newStr.length() < len) {
         return newStr;
     }
     else {
         return str;
     }
 }

 //optimized solution:
 //use string builder
 public static String compressString (String str) {
        StringBuilder newStr = new StringBuilder();
        int len = str.length();
        int count = 1;
        char c = str.charAt(0);
        for (int i=0; i<len; i++) {
            if(i<len-1 && str.charAt(i+1) == c) {
                count++;
            }
            else {
               newStr.append(c);
               newStr.append(count);
               count = 1;
               if (i<len-1) {
                   c = str.charAt(i + 1);
               }
            }
        }
        return newStr.length() < len ? newStr.toString() : str;
    }
