import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _12919_ { // A와 B 2

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String S = bf.readLine();
		String T = bf.readLine();

		Queue<String> queue = new LinkedList<>();
		queue.add(T);

		boolean flag = false;
		while (!queue.isEmpty()) {
			String temp = queue.poll();

			if (temp.length() - 1 < S.length())
				continue;

			// 문자열 뒤에 A 제거
			if (temp.charAt(temp.length() - 1) == 'A') {
				String a = temp.substring(0, temp.length() - 1);
				if (a.equals(S)) {
					flag = true;
					break;
				}
				queue.add(a);
			}

			// 맨 앞 문자열 B 제거 후 뒤집기
			if (temp.charAt(0) == 'B') {
				String a = "";
				for (int i = temp.length() - 1; i > 0; i--) {
					a += temp.charAt(i);
				}
				if (a.equals(S)) {
					flag = true;
					break;
				}
				queue.add(a);
			}
		}
		if (flag)
			System.out.println(1);
		else
			System.out.println(0);
	}
}
