import java.util.*;

public class programmers_389480 {
	static int N, R, M; static int index = 0;
	static int[][] A;
	static List<Integer> selected = new ArrayList<>();
	static int[] NM = new int[2]; static int answer = Integer.MAX_VALUE;

	static void DFS(int e){
		selected.add(e);
		index++;
		if (selected.size() == R) {
			if(NM[0] < N && NM[1] < M) {
				answer = Math.min(answer, NM[0]);
			}
			index--;
			return;
		}
		NM[0] += A[index][0];
		DFS(A[index][0]);
		NM[0] -= A[index][0];
		selected.remove(selected.size() - 1);
		NM[1] += A[index][1];
		DFS(A[index][1]);
		NM[1] -= A[index][1];
		selected.remove(selected.size() - 1);
		index--;
	}

	public static int solution(int info[][], int n, int m){
		N = n;
		R = info.length;
		M = m;
		A = info.clone();
		NM[0] += A[0][0];
		DFS(A[0][0]);
		selected = new ArrayList<>(); index = 0;
		NM = new int[2];
		NM[1] += A[0][1];
		DFS(A[0][1]);
		if(answer == Integer.MAX_VALUE) {
			return -1;
		}
		return answer;
	}
}
