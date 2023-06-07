package assignments.daily_task;

public class DistanceBetweenCharInString {
    public static void main(String args[]) {
        //String s = "aaab"; char c = 'b';
        String s = "dbcadcbaadacccbd"; char c = 'a';
        int[] arr = new int[s.length()];
        int count = s.indexOf(c);
        int l = 0, r = 0;
        for(int i = 0; i < s.length(); i++){
            r = s.indexOf(c,i) - i;
            if(s.charAt(i) == c)
                count = i;
            l = Math.abs(i - count);
            //System.out.println("i:"+ i+" l:"+l+" r:"+r);
            arr[i] = (r > 0)&&(l > r)? r:l;
        }
        for(int i: arr)
            System.out.print(i+" ");
    }
}
