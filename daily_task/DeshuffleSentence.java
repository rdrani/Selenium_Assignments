package assignments.daily_task;

public class DeshuffleSentence {
    public static void main(String args[]) {
//        String s = "is2 sentence4 This1 a3";
        String s = "Myself2 Me1 I4 and3";
        String[] splitArr = s.split(" ");
        String[] orderedArr = new String[splitArr.length];
        String result = "";
        int index = 0;
        String word = "";
        for(String entry:splitArr){
            index = Character.getNumericValue(entry.charAt(entry.length()-1));
            word = entry.substring(0,entry.length()-1);
            orderedArr[index-1] = word;
        }
        for (String string : orderedArr) {
			result = result + " " + string;
		}
        System.out.println(result);
    }
}
