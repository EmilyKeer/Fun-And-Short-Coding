/*
Given a string, write a function to check if it is a permutation of a palindrome.
Eg:

Input    | Output
mmo      | True
yakak    | True
travel   | False
Tact Coa | True

Hint: use hash table to count
*/

//Keer's solution
/*
1.toLowerCase
2.cases:
  all 2n
  one 2n-1 the others 2n
  only one char with 2n-1
*/
    public static boolean permuPali (String str) {
        str = str.toLowerCase();
        str = str.replace(" ", ""); //actually: no need to deal with spaces, just treat it as a character
        char[] charArray = str.toCharArray();
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (Character c : charArray) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);

            } else {
                charMap.put(c, 1);
            }
        }
        int flag = 0;
        for (int num : charMap.values()) {
            if (flag > 1) {
                return false;
            }
            if (num%2 == 1) {
                flag++;
            }
        }
        return true;
    }

//Optimized solution
/*
1.You can use array to achieve this. like a[n] where n = char - 'a'
2.optimize:
check odd counts as we go along
*/
public static boolean permuPali (String str) {
        str = str.toLowerCase();
        str = str.replace(" ", "");
        char[] charArray = str.toCharArray();
        HashMap<Character, Integer> charMap = new HashMap<>();
        int countOdd = 0;
        for (Character c : charArray) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
                countOdd--;
            } else {
                charMap.put(c, 1);
                countOdd++;
            }
        }
        return countOdd<=1;
    }
}
