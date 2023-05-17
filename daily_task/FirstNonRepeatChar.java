public class FirstNonRepeatChar {
    public static void main(String args[]) {
        //String s = "leetcode";
        //String s = "loveleetcode";
        String s = "aabb";
        System.out.println(findRep(s));
    }
    public static int findRep(String s){
        int count = 0;
        char[] ch = s.toCharArray();
        for(int i=0; i < ch.length; i++ ){
            count=0;
            for(int j= 0; j< ch.length; j++){
                if((i!=j)&&(ch[i] == ch[j])){
                    count++;
                }
            }
            if(count==0){
                return i;
            }
        }
        return -1;
    }
}
