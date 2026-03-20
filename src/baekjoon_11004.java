import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_11004 {
    public static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");
        int index = Integer.parseInt(st.nextToken());
        int [] array = new int[index];
        int k = Integer.parseInt(st.nextToken());
        input = br.readLine();
        st = new StringTokenizer(input," ");
        int count = 0;
        while (st.hasMoreTokens()) {
        	array[count++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        return array[k-1];
    }
    public static void main(String[] args) throws IOException {
    	System.out.println(solution());
    }
}