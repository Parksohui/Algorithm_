import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _21030_ { // Frequent Alphabet

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		String S = bf.readLine();
		String T = bf.readLine();

		int result = 0;

		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (S.charAt(i) == T.charAt(i)) {
				if (map.containsKey(S.charAt(i))) {
					map.replace(S.charAt(i), map.get(S.charAt(i)) + 1);
				} else {
					map.put(S.charAt(i), 1);
				}
			} else {
				if (map.containsKey(S.charAt(i))) {
					map.replace(S.charAt(i), map.get(S.charAt(i)) + 1);
				} else {
					map.put(S.charAt(i), 1);
				}

				if (map.containsKey(T.charAt(i))) {
					map.replace(T.charAt(i), map.get(T.charAt(i)) + 1);
				} else {
					map.put(T.charAt(i), 1);
				}
			}
			result = Math.max(result, map.get(S.charAt(i)));
			result = Math.max(result, map.get(T.charAt(i)));
		}
		System.out.println(result);
	}
}
