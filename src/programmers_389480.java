class programmers_67258 {
	static int N = 0, end1 = 0, end2 = 0, result = Integer.MAX_VALUE, index = 1;
	static int l = 0;
	static int[] temp;
	static int sum1 = 0;
	static int sum2 = 0;

	public static void dfs(int index, int[][] tree, int[][] info) {
		if (index >= tree.length) {
			return;
		}
		if(temp[N-1] != 0) {
			if(tree[index-1][2] == 0) {
				sum1 -= tree[index-1][0];
			}
			else {
				sum2 -= tree[index-1][0];
			}
		}
		temp[tree[index][1]] = tree[index][0];
		if(tree[index][2] == 0) {
			sum1 += tree[index][0];
		}
		else {
			sum2 += tree[index][0];
		}
		if(sum1 < end1 && sum2 < end2) {
			if(result > sum1 && temp[N-1] != 0) {
				result = sum1;
			}
		}
		dfs(2 * index + 1, tree, info);
		dfs(2 * index + 2, tree, info);
	}

	public static int solution(int[][] info, int n, int m) {
		N = info.length; temp = new int[N];
		end1 = n;
		end2 = m;
		for (int i = 1; i <= N; i++) {
			index += Math.pow(2, i);
		}
		int[][] tree1 = new int[index][3];

		int k = 0;
		l = 1;
		int p = 1;
		tree1[0][0] = 0;
		for (int i = 1; i < index; i += 2) {
			p *= 2;
			if (i == 1)
				p = 1;
			for (int j = 0; j < p; j++) {
				tree1[l][0] = info[k][0];
				tree1[l][1] = k;
				l++;
				tree1[l][0] = info[k][1];
				tree1[l][2] = 1;
				tree1[l][1] = k;
				l++;
			}
			k++;
			if (k == N)
				break;
		}
		dfs(0, tree1, info);
		if(result == Integer.MAX_VALUE) {
			return -1;
		}
		return result;
	}
}