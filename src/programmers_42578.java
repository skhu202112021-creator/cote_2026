import java.util.HashMap;
import java.util.Map; 
class programmers_42578 {
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < clothes.length; ++i){
        	String key = clothes[i][1];
            if(hash.containsKey(key)){
                hash.put(key,hash.get(key) + 1);
            }
            else{hash.put(key, 1);}
        }
        for (int count : hash.values()) {
        	answer *= (count + 1);
        }
        return answer - 1;
    }
}