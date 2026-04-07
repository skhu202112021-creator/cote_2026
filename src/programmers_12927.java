import java.util.Arrays;

class programmers_12927 {
	public static long solution(int n, int[] works) {
		long answer = 0;
		int max = 0;
		int index = works.length - 1;
		int [] dp = new int[works.length];
		Arrays.sort(works);
		while(n != 0) {
			if(index-1 != -1) {
				if(works[index] < works[index-1]) {
					dp[index] = works[index];
					index--;
				}
			}
			int count = works.length - 1;
			while(count != 0 && dp[count] != 0) {
				if(works[index] < dp[count]) {
					index = count;
				}
				count--;
				while(dp[count] != 0) {
					count--;
				}
			}
			max = works[index];
			int x = max - 1;
			if (x == -1) {
				return 0;
			}
			works[index] = x;
			n--;
		}
		for (int i = 0; i < works.length; ++i) {
			answer += Math.pow(works[i], 2);
		}
		return answer;
	}
}
