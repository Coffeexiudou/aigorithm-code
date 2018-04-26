import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {


    /**Given a string, find the length of the longest substring without repeating characters.

     Examples:

     Given "abcabcbb", the answer is "abc", which the length is 3.

     Given "bbbbb", the answer is "b", with the length of 1.

     Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     **/

    /***
     * 我的答案
     * 用map记录是否出现过
     * 双重循环O(n)
     * */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        int length = s.length();
        int max = 0 ;
        for (int i = 0 ; i < length; ++i){
            Map<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(i),1);
            for (int j = i + 1 ; j < length; ++j){
                if (map.containsKey(s.charAt(j))){
                    int len = map.size();
                    if (len > max) max = len;
                    break;
                }
                else {
                    map.put(s.charAt(j),1);
                }
            }
            if (map.size() > max){
                max = map.size();
            }
        }

        return max ;
    }

    /**
     * 只需遍历一次O(n)复杂度
     * 只需要记录起始边界就行，不用多一层循环
     "滑动窗口" 
         比方说 abcabccc 当你右边扫描到abca的时候你得把第一个a删掉得到bca，
         然后"窗口"继续向右滑动，每当加到一个新char的时候，左边检查有无重复的char，
         然后如果没有重复的就正常添加，
         有重复的话就左边扔掉一部分（从最左到重复char这段扔掉），在这个过程中记录最大窗
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s){
        if (s == null || s.length() == 0 ) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int leftBound = 0; //记录左侧边界位置
        int max = 0 ;
        for (int i = 0 ; i < s.length(); ++i){
            char c = s.charAt(i);
            //窗口左边可能为下一个新字符，或者和第一个字符重复
            leftBound = Math.max(leftBound, (map.containsKey(c)?map.get(c) + 1 : 0 ));
            max = Math.max(max ,i - leftBound + 1 ); //当前窗口长度
            map.put(c,i); //map存每个字符的位置，若后边出现就更新
        }
        return max;
    }




    public static void main(String [] args){
        String s = "au";
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        int a = l.lengthOfLongestSubstring(s);
        System.out.println(a);

    }
}
