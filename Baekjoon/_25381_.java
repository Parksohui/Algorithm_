import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _25381_ { // ABBC

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();

		PriorityQueue<Integer> aQueue = new PriorityQueue<>(Collections.reverseOrder());
		Deque<Integer> bQueue = new ArrayDeque<>();
		Queue<Integer> cQueue = new LinkedList<>();

		int result = 0;

		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if (x == 'A') {
				aQueue.add(i);
			} else if (x == 'B') {
				bQueue.add(i);
			} else if (x == 'C') {
				cQueue.add(i);
			}
		}

		while (!aQueue.isEmpty()) {
			int num = aQueue.poll();
			if (!bQueue.isEmpty() && num < bQueue.peekLast()) {
				result += 1;
				bQueue.pollLast();
			}
		}

		while (!bQueue.isEmpty()) {
			int num = bQueue.pollFirst();
			while(!cQueue.isEmpty() && num > cQueue.peek()) {
				cQueue.poll();
			}
			if(!cQueue.isEmpty() && num < cQueue.peek()) {
				result+=1;
				cQueue.poll();
			}
		}
		
		System.out.println(result);
	}
}
