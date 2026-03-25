import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class programmers_42579{
    public static int[] solution(String[] genres, int[] plays) {
    	int [] index = new int[genres.length];
        Map<String, Integer> sums = new HashMap<>();
        Set<String> set = new HashSet<>();
        int[] answer = {}; int count = 0;
        String [] copyGenres = genres.clone();
        int [] copyPlays = plays.clone();
	    for (int i = 0; i < genres.length; ++i) {
	    	set.add(genres[i]);
	    	index[i] = i;
	    }
	    /*적합한 정렬 알고리즘을 생각하던 중 버블 정렬이 떠올라 사용함.
	     람다 함수를 이용하면 간단하게 코드 작성 가능.*/
	    for (int i = 0; i < genres.length; ++i) {
	    	for (int j = 1; j < genres.length - i; ++j) {
		    	if(plays[j] > plays[j - 1]) {
		    		int temp = plays[j - 1];
		    		plays[j - 1] = plays[j];
		    		plays[j] = temp;
		    		int tempI = index[j - 1];
		    		index[j - 1] = index[j];
		    		index[j] = tempI;
		    		String tempStr = genres[j - 1];
		    		genres[j - 1] = genres[j];
		    		genres[j] = tempStr;
		    	}
	    	}
	    }
	    int sum = 0; count = 0; boolean access = false; String temp = ""; int tmpj = 0;
	    for (int i = 0; i < set.size(); ++i) {
	    	count = 0;
	    	for(int j = 0; j < copyGenres.length; ++j) {
	    		if (set.toArray()[i].equals(copyGenres[j])) {
	    			sum += copyPlays[j];
	    			count++;
	    			tmpj = j;
	    		}
	    	}
	    	//총합이 같은 장르가 존재하고 장르에 속한 곡이 1개면 저장함.
	    	if(sums.containsValue(sum) && count == 1) {
	    		access = true;
	    		temp = copyGenres[tmpj];
	    	}
	    	sums.put(set.toArray()[i].toString(), sum);
	    	sum = 0;
	    }
	    List<Integer> list = new ArrayList<>();
	    List<String> keyList = new ArrayList<>(sums.keySet());
        keyList.sort((o1, o2) -> sums.get(o2) - sums.get(o1));
        int length = sums.size()*2; count = 0; int repeat = -1;
        int resultIndex = 0;
        //저장해둔 값 맨 앞에 추가.
        if(access == true) {
			if(genres[0].equals(temp)) {
				list.add(index[0]);
				repeat = index[0];
			}
        }
	    for(int i = 0; i < keyList.size(); ++i) {
	    	for(int j = 0; j < index.length; ++j) {
	    		if(resultIndex != length && count != 2) {
		    		if(keyList.get(i).equals(genres[j])) {
		    			if(sums.get(keyList.get(i)) == plays[j] && !list.contains(index[j])) {
		 					repeat = index[j];
		 					list.add(index[j]);
		 				}
		    			if(repeat != index[j]) {
		    				list.add(index[j]);
		    				resultIndex++; count++;
		    			}
		    		}
	    		}
	    	}
	    	count = 0;
	    }
	    Integer [] answerInt = list.toArray(new Integer[list.size()]);
	    answer = Arrays.stream(answerInt).mapToInt(Integer::intValue).toArray();
	    return answer;
    }
}