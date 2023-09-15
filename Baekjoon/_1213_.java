import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class _1213_ { // 팰린드롬 만들기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();

		HashMap<Character, Integer> map = new HashMap<>();
		ArrayList<Character> list = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if (!map.containsKey(x)) {
				map.put(x, 1);
				list.add(x);
			} else {
				map.replace(x, map.get(x) + 1);
			}
		}

		Collections.sort(list);

		boolean flag = false;
		char a = ' ';
		boolean result = false;
		for (char x : map.keySet()) {
			if (map.get(x) % 2 != 0) {
				if (!flag) {
					flag = true;
					a = x;
				} else {
					result = true;
					break;
				}
			}
		}

		if (str.length() % 2 == 0 && flag) {
			result = true;
		}

		String answer = "";

		if (!result) {
			char arr[] = new char[str.length()];
			int front = 0, back = str.length() - 1;

			for (char x : list) {
				while (map.get(x) > 1) {
					arr[front++] = x;
					arr[back--] = x;
					map.replace(x, map.get(x) - 2);
				}
			}
			if(str.length()%2!=0) {
				arr[front] = a;
			}
			
			for (char x : arr) {
				answer += x;
			}
		}

		if (result) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			System.out.println(answer);
		}
	}

}
