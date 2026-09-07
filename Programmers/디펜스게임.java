import java.util.*;

class Solution {
	public int solution(int n, int k, int[] enemy) {
		int answer = enemy.length;

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < enemy.length; i++) {
			queue.add(enemy[i]);
			n -= enemy[i];

			if (n < 0) {
				if (k > 0) {
					n += queue.poll();
					k -= 1;
				}
				if (n < 0) {
					answer = i;
					break;
				}
			}
		}
		return answer;
	}
}