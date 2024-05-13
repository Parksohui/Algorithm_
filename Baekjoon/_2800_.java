import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class _2800_ { // 괄호 제거
	static ArrayList<String> list;
	static ArrayList<Integer> check;
	static int num[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = bf.readLine();

		num = new int[str.length()];

		Stack<Integer> temp = new Stack<>();
		check = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				temp.add(i);
			} else if (str.charAt(i) == ')') {
				int n = temp.pop();
				check.add(i);
				num[i] = n;
				num[n] = i;
			}
		}

		list = new ArrayList<>();
		boolean arr[] = new boolean[str.length()];
		search(str, 0, arr);

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}
		bw.flush();

	}

	private static void search(String str, int idx, boolean[] arr) {
		if (idx == check.size()) {
			String result = "";
			for (int i = 0; i < str.length(); i++) {
				if (arr[i]) {
					continue;
				}
				result += str.charAt(i);
			}

			if (!list.contains(result) && !result.equals(str))
				list.add(result);
			return;
		}
		
		arr[num[check.get(idx)]] = true;
		arr[check.get(idx)] = true;
		search(str, idx + 1, arr);
		arr[num[check.get(idx)]] = false;
		arr[check.get(idx)] = false;
		search(str, idx + 1, arr);
	}
}
