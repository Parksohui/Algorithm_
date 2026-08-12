import java.util.*;

class Solution {
	boolean solution(String s) {
		boolean answer = true;

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.add(s.charAt(i));
			} else {
				if (stack.size() == 0) {
					answer = false;
					break;
				}
				stack.pop();
			}
		}

		if (stack.size() != 0) {
			answer = false;
		}

		return answer;
	}
}