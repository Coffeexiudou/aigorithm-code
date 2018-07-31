public class ToLowerCase {
    /**
     * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
     Example 1:

     Input: "Hello"
     Output: "hello"
     Example 2:

     Input: "here"
     Output: "here"
     Example 3:

     Input: "LOVELY"
     Output: "lovely"
     * @param str
     * @return
     */

    public String toLowerCase(String str) {
        char[] ch = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : ch){
            stringBuffer.append(charToLowerCase(c));
        }
        return stringBuffer.toString();
    }

    public char charToLowerCase(char ch){
        if (ch <= 90 && ch >= 65){
            ch += 32;
        }
        return ch;
    }

}
