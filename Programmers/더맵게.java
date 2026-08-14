import java.util.*;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++) {
			queue.add(scoville[i]);
		}

		while (!queue.isEmpty() && queue.peek() < K) {
			if (queue.size() == 1) {
				answer = -1;
				break;
			}

			int num1 = queue.poll();
			int num2 = queue.poll();
			queue.add(num1 + (num2 * 2));
			answer += 1;
		}
		return answer;
	}
}