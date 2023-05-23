public class MaxWordsSentence{

     public static void main(String []arg){
//       String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
         String[] sentences = {"please wait", "continue to fight", "continue to win"};
         int count = 0, max = 0;
         for(String each : sentences){
             count = each.split(" ").length;
             if(max < count){
                 max = count;
             }
         }
         System.out.println(max);
     }
}
