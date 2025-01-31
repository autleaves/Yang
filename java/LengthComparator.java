import java.util.Arrays;
import java.util.Comparator;

public class LengthComparator implements Comparator<String>{
	public int compare(String first, String second) {
		return first.length() - second.length();
	}


	public static void main(String... args){
		String[] friends = {"Peter", "Paul", "Mary"};
		var comp = new LengthComparator();
		Arrays.sort(friends, comp);

		for (String s : friends) {
			System.out.println(s);
		}
	}
}