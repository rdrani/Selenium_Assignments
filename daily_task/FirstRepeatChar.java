import java.util.Map;
import java.util.TreeMap;
public class FirstRepeatChar {
    public static void main(String args[]) {
      String s = "abccbaacz";
      //String s = "abcdd";
      Map<Integer,Character> sMap = new TreeMap<>();
      for(int i=0; i < s.length(); i++){
          for(int j=i+1; j < s.length(); j++){
              if(s.charAt(i) == s.charAt(j)){
                  sMap.put(j,s.charAt(i));
                  break;
              }
          }
      }
      if(!sMap.isEmpty()){
          Map.Entry<Integer, Character> firstEntry = sMap.entrySet().iterator().next();
          System.out.println("First repeating letter in the given string is: "+ firstEntry.getValue());
      }else{
          System.out.println("No repeating letters present in the given string");
      }
    }
}
