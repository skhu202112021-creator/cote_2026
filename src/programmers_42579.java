import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class programmers_42579 {
    public static int[] solution(String[] genres, int[] plays) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<String, List<Integer>> sort = new HashMap<>();
        Map<String, Integer> sums = new HashMap<>();
        Set<String> set = new HashSet<>();
        String [] array = new String[genres.length];
        int[] answer = {}; int count = 0; String temp = "";
	    for (int i = 0; i < genres.length; ++i) {
	    	set.add(genres[i]);
	    	if(map.containsKey(plays[i]) && !genres[i].equals(temp)) {
	    		if(!sort.containsKey(genres[i])) {
	    			sort.put(genres[i], new ArrayList<>());
	    		}
	    		sort.get(genres[i]).add(map.get(plays[i]));
	    		sort.get(genres[i]).add(i);
	    		count++;
	    		temp = genres[i];
	    		System.out.print(genres[i]);
	    		System.out.println(sort.get(genres[i]).toString());
	    	}
	    	map.put(plays[i], i);
    	}
	    Arrays.sort(plays);
	    for (int i = 0; i < genres.length; ++i) {
	    	array[i] = genres[map.get(plays[i])];
	    }
	    int sum = 0;
	    for (int i = 0; i < set.size(); ++i) {
	    	for(int j = 0; j <array.length; ++j) {
	    		if (set.toArray()[i].equals(array[j])) {
	    			sum += plays[j];
	    		}
	    	}
	    	sums.put(set.toArray()[i].toString(), sum);
	    	sum = 0;
	    }
	    String tempGenre = ""; int tempPlay = 0;
	    List<Integer> list = new ArrayList<>();
	    List<String> keyList = new ArrayList<>(sums.keySet());
        keyList.sort((o1, o2) -> sums.get(o1).compareTo(sums.get(o2)));
	    int index = 0, length = sums.size()*2; count = 0;
	    for(int i = keyList.size() - 1; i >= 0; --i) {
	    	for(int j = array.length - 1; j >= 0; --j) {
	    		if(sums.get(keyList.get(i)) == plays[j]) {
	    			length--;
	    		}
	    		if(index != length && count != 2 && !sort.containsKey(keyList.get(i))) {
		    		if(keyList.get(i).equals(array[j]) && map.get(plays[j]) != null) {
		    			list.add(index,map.get(plays[j]));
		    			System.out.print(map.get(plays[j]));
		    			map.put(plays[j], null);
		    			index++; count++;
		    		}
	    		}
	    		tempGenre = array[i]; tempPlay = plays[i];
	    	}
	    	if(tempGenre.equals(array[i]) && tempPlay == plays[i] && sort.containsKey(keyList.get(i))) {
	    		for(int j = 0; j < sort.get(keyList.get(i)).size(); ++j) {
	    			list.add(sort.get(keyList.get(i)).get(j));
	    		}
    			map.put(plays[i], null);
	    	}
	    	count = 0;
	    }
	    Integer [] answerInt = list.toArray(new Integer[list.size()]);
	    answer = Arrays.stream(answerInt).mapToInt(Integer::intValue).toArray();
	    return answer;
    }
}