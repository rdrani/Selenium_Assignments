package assignments.daily_task;

public class CommonCharsInStrings {

	public static void main(String args[]) {

		String[] words = { "bella", "label", "roller" };
//		String[] words = { "cool", "lock", "cook" };
		String match = words[words.length-1];
		String temp = "";
		for (int i = words.length-2; i >= 0; i--) {
			for (char c : words[i].toCharArray()) {
				if (match.contains(c + "")) {
					match = match.replaceFirst(c + "", "");
					temp += c;
				}
			}
			match = temp;
			temp = "";
		}
		System.out.println(match.toCharArray());

	}

}
