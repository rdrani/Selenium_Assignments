package assignments.daily_task;

public class JewelsAndStones {

	public static void main(String[] args) {
		String jewels = "aA", stones = "aAAbbbb";
//		String jewels = "z", stones = "ZZ";
//		String jewels = "aBc", stones = "CBacCBaBcbaAbbcB";
		stones = stones.replaceAll("[^"+jewels+"]", "");
		System.out.println("Number of jewels in stones: "+stones.length());
	}

}
