public class SameStringInTwoArrays {
    public static void main(String args[]) {
//      String[] word1 = {"ab", "c"}, word2 = {"a", "bc"};
//      String[] word1 = {"a", "cb"}, word2 = {"ab", "c"};
        String[] word1 = {"abc", "d", "defg"}, word2 = {"abcddefg"};
        String s1 = String.join("",word1);
        String s2 = String.join("",word2);
        System.out.println(s1.equals(s2));
    }
}
