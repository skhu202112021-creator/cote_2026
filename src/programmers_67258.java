import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 1. 보석의 총 종류 수 계산
        int totalKind = new HashSet<>(Arrays.asList(gems)).size();
        
        // 2. 결과 저장용 변수
        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;
        
        // 3. 구간을 관리할 Map과 포인터
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        
        for (int end = 0; end < gems.length; end++) {
            // 오른쪽 포인터(end)를 이동하며 보석 추가
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            // 모든 종류를 다 모았다면, 왼쪽 포인터(start)를 줄여가며 최소 구간 탐색
            while (map.size() == totalKind) {
                // 현재 구간이 더 짧다면 갱신
                if (end - start < minLength) {
                    minLength = end - start;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
                
                // start 쪽 보석 제거
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]); // 0개가 되면 종류 수에서 제외되도록 삭제
                }
                start++;
            }
        }
        
        return answer;
    }
}
