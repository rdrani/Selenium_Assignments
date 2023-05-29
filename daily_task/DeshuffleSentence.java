package assignments.daily_task;

public class DeshuffleSentence {
    public static void main(String args[]) {
        String s = "is2 sentence4 This1 a3";
//        String s = "Myself2 Me1 I4 and3";
        String[] splitArr = s.split(" ");
        String[] orderedArr = new String[splitArr.length];
        int index = 0;
        for(String entry:splitArr){
            index = Character.getNumericValue(entry.charAt(entry.length()-1));
            orderedArr[index-1] = entry.substring(0,entry.length()-1);
        }
        for (String word : orderedArr) {
        	System.out.print(word + " ");
		}
    }
}
