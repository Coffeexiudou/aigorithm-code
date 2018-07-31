import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JewelsandStones {
    /**
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

     The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

     Example 1:

     Input: J = "aA", S = "aAAbbbb"
     Output: 3
     Example 2:

     Input: J = "z", S = "ZZ"
     Output: 0
     Note:

     S and J will consist of letters and have length at most 50.
     The characters in J are distinct.
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        List<String> j = Arrays.asList(J.split(""));
        List<String> s = Arrays.asList(S.split(""));
        Map<String,Integer> term = new HashMap<>();
        for (String item : j){
            term.put(item,0);
        }
        for (String item : s){
            if (term.containsKey(item)){
                int num = term.get(item);
                term.put(item,num+1);
            }
        }
        int nums = 0;
        for (Map.Entry<String,Integer> entry:term.entrySet()){
            nums += entry.getValue();
        }
        return nums ;

    }

    public static void main(String [] args){
        String J = "z";
        String S = "ZZZ";
        JewelsandStones j = new JewelsandStones();
        System.out.println(j.numJewelsInStones(J,S));
    }
}
