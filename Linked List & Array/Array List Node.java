//new Arraylist
new ArrayList<Integer>(Arrays.asList(j, i));



//HashMap
HashMap<Integer, String> hmap = new HashMap<Integer, String>();
hmap.put(3, "English"); //update --> replace

for (Integer each : hmap.keySet())
for (String each : hmap.values())

for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
	Integer a = entry.getKey();
	String b = entry.getValue();
}

String someValue = hmap.get(key);



//char is letter/digit cases
Char c = String.charAt(i);
if (Character.isLetter(c)) {
Character.toLowerCase(c);
}

Character c;
c.isLetter()


isDigit
isLetter
isLetterOrDigit
isLowerCase
isUpperCase



//int[] String[]
int[] myIntArray = new int[3];
int[] myIntArray = {1,2,3};
int[] myIntArray = new int[]{1,2,3};
For classes, for example String, it's the same:

String[] myStringArray = new String[3];
String[] myStringArray = {"a","b","c"};
String[] myStringArray = new String[]{"a","b","c"};
