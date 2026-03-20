import java.util.HashMap;
import java.util.Map;

class programmers_42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Boolean> map = new HashMap<>();
        for(String key : phone_book) {
        	map.put(key, true);
        }
        for(int i = 0; i < phone_book.length; ++i) {
        	map.put(phone_book[i],false);
        	StringBuilder sb = new StringBuilder("");
        	String[] split = phone_book[i].split("");
        	for(String str : split) {
        		sb.append(str);
        		if (map.containsKey(sb.toString()) && map.get(sb.toString()) == true) {
        			answer = false;
        		}
        	}
        	map.put(phone_book[i],true);
        }
        return answer;
    }
}