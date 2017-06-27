/*
There are three types of edits that can be performed on strings: insert a character, remove a character and replace 
a character. Given two strings, write a function to check if they are within one edit of each other.
*/
//Keer's solution O(n)
/*
1.insert is the reverse of delete
2.check length difference
3.one point diff, and then shift
*/
public boolean oneAway (String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        //just use str1.charat(i)
        int difflen = len1 - len2;
        if (difflen>1 || difflen<-1) {
            return false;
        }
        else if (difflen == 0) {
            int p1=0;
            int p2=0;
            int diff = 0;
            while(p1<len1 && p2<len2) {
                if (charArray1[p1] != charArray2[p2]) {
                    if (diff == 1) {
                        return false;
                    }
                    diff++;
                }
                p1++;
                p2++;
            }
        }
        else if (difflen == 1) {
            int p1=0;
            int p2=0;
            int diff = 0;
            while(p1<len1 && p2<len2) {
                if (charArray1[p1] != charArray2[p2]) {
                    if (diff == 1) {
                        return false;
                    }
                    diff++;
                    p1++;
                }
                else {
                    p1++;
                    p2++;
                }
            }
        }
        else {
            int p1=0;
            int p2=0;
            int diff = 0;
            while(p1<len1 && p2<len2) {
                if (charArray1[p1] != charArray2[p2]) {
                    if (diff == 1) {
                        return false;
                    }
                    diff++;
                    p2++;
                }
                else {
                    p1++;
                    p2++;
                }
            }
        }
        return true;
        }

//Trade off:
//refactor
boolean oneAway(String str1, String str2) {
  if (Math.abs(str1.length()-str2.length() > 1) {
    return false;
  }

//s1 shorter, s2 longer or the same
  String s1 = str1.length()<str2.length() ? str1 : str2;
  String s2 = str1.length()<str2.length() ? str2 : str1;

  int index1=0;
  int index2=0;
  boolean diff = false;
  while (index1<s1.length() && index2<s2.length()) {
    if (s1.charAt(index1)!=s2.charAt(index2)) {
      if(diff) return false;
      diff = true;
      if(s1.length()==s2.length()) {
        index1++;
      }
    }
    else {
      index1++;
    }
    index2++;
  }
  return true;
}
