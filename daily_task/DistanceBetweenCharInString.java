package assignments.daily_task;

public class DistanceBetweenCharInString {
    public static void main(String args[]) {
        //String s = "aaab"; char c = 'b';
        String s = "dbcadcbaadacccbda"; char c = 'a';
        int[] arr = new int[s.length()];
        int count = s.indexOf(c);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c)
                count = i;
            arr[i] = Math.abs(i - count);
        }
        for(int i: arr)
            System.out.print(i+" ");
    }
}
