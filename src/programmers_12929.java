import java.util.ArrayList;
import java.util.Collections;

public class programmers_12929 {
	static int answer = 0;

	static void DFS(int n, int index, ArrayList<Character> selected) {
		if (index >= n * 2) {
			int check = 0;
			int s = Collections.binarySearch(selected, ')');
			if (s > 0) {
				for (char c : selected) {
					if (c == '(') {
						check++;
					}
					if (c == ')') {
						check--;
					}
					if (check == -1) {
						break;
					}
				}
				if (check == 0) {
					answer++;
				}
			}
			return;
		}
		var selected2 = new ArrayList<Character>(selected);
		selected2.add('(');
		DFS(n, index + 1, selected2);
		selected.add(')');
		DFS(n, index + 1, selected);
	}

	public static int solution(int n) {
		DFS(n, 0, new ArrayList<Character>());
		return answer;
	}
}
