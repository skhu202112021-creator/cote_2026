import java.util.LinkedList;
import java.util.Queue;

class programmers_389480 {
	static int count = 1, N = 0, end1 = 0, end2 = 0, result = Integer.MAX_VALUE;
	static int l = 0; static int[] numbers;
	static int [] temp;
	static int answer[] = new int[2];
	static int sum1 = 0; static int sum2 = 0;
    static class Node {
        int key;
        int value;
        Node left, right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private static Node root;
    public static void insert(int key, int value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 왼쪽 자식이 비었으면 여기에 배치
            if (current.left == null) {
                current.left = newNode;
                break;
            } else {
                queue.add(current.left);
            }

            // 오른쪽 자식이 비었으면 여기에 배치
            if (current.right == null) {
                current.right = newNode;
                break;
            } else {
                queue.add(current.right);
            }
        }
    }

    public static void originalOrderDFS(Node node, int[][] info) {
    	count++;
    	boolean answer = true;
        if (node == null) {
        	return;
        }
        int j = numbers[node.key];
        if(temp[j] != 0) {
        	if(info[j][0] == temp[j]) {
        		sum1 -= temp[j];
        	}
        	if(info[j][1] == temp[j]) {
        		sum2 -= temp[j];
        	}
        }
        if(node.value == info[j][0]) {
        	sum1 += node.value;
        	temp[j] = node.value;
        }
        if(node.value == info[j][1]) {
        	sum2 += node.value;
        	temp[j] = node.value;
        }
        for(int n : temp) {
        	if(n == 0) {
        		answer = false;
        	}
        }
        if(sum1 < end1 && sum2 < end2) {
        	if(result > sum1 && answer == true) {
        		result = sum1;
        	}
        }
        originalOrderDFS(node.left,info);
        originalOrderDFS(node.right,info);
    }

	public static int solution(int[][] info, int n, int m) {
		N = info.length; end1 = n; end2 = m; temp = new int[N];
		int index = 1;
		for (int i = 1; i <= N; i++) {
			index += Math.pow(2, i);
		}
		int[] tree1 = new int[index];
		numbers = new int[index];
		
		int k = 0;
		l = 1;
		int p = 1;
		tree1[0] = 0;
		numbers[0] = 0;
		for (int i = 1; i < index; i += 2) {
			p *= 2;
			if (i == 1)
				p = 1;
			for (int j = 0; j < p; j++) {
				tree1[l] = info[k][0];
				numbers[l] = k;
				l++;
				tree1[l] = info[k][1];
				numbers[l] = k;
				l++;
			}
			k++;
			if (k == N)
				break;
		}
		l = 0;
		for (int entry : tree1) {
            insert(l, entry);
            l++;
		}
		originalOrderDFS(root,info);
        return result;
	}
	public static void main(String[] args) {
		int[][] s = {{1, 2}, {2, 3}, {2, 1}};
		System.out.print(solution(s, 4, 4));
	}
}
