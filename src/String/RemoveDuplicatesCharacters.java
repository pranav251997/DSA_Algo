package String;

import java.util.stream.Collectors;

public class RemoveDuplicatesCharacters {

	public static void main(String[] args) {
		String str = "aabbcc";
		String op = str.chars().distinct().mapToObj(s -> String.valueOf((char)s)).collect(Collectors.joining());
		System.out.println(op);

	}

}
