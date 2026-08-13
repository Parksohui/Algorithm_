import java.util.*;

class Solution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && stack.peek()[0] > prices[i]) {
				answer[stack.peek()[1]] = i - stack.peek()[1];
				stack.pop();
			}
			stack.add(new int[] { prices[i], i });
		}

		while (!stack.isEmpty()) {
			answer[stack.peek()[1]] = prices.length - 1 - stack.peek()[1];
			stack.pop();
		}
		return answer;
	}
}