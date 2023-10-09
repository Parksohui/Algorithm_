import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _25192_ { // 인사성 밝은 곰곰이

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		Set<String> set = new HashSet<>();
		int result = 0;

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			if (!str.equals("ENTER")) {
				set.add(str);
			} else {
				result += set.size();
				set.clear();
			}
		}
		result+=set.size();
		
		System.out.println(result);
	}
}
