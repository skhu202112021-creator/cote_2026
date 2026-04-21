import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class programmers_67258 {
    public static int[] solution(String[] gems) {
        int[] answer = new int [2];
        int sum = 0, count = 0, write = 0;
        Set<String> s = new HashSet<>();
        Map<String, Integer> h = new HashMap<>();
        for(int i = 0; i < gems.length; ++i) {
        	sum = 0; count = 0;
        	for(String gem : gems) {
            	s.add(gem);
            }
        	for(String gem : s) {
        		h.put(gem, 0);
        	}
        	for(int j = i; j < gems.length; ++j) {
        		count++;
            	h.put(gems[j], h.get(gems[j]) + 1);
            	if(h.get(gems[j]) == 1) {
            		sum++;
            	}
        		if(sum == h.size()) {
            		if(write > count || write == 0) {
            			answer[0] = i + 1;
            			answer[1] = j + 1;
            			write = count;
            		}
            		j = gems.length;
            	}
            }
        }
        return answer;
    }
}