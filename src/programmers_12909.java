class programmers_12909 {
    static boolean solution(String s) {
        boolean answer = true;

        char[] charArray = s.toCharArray();
        int sum = 0;
        for (char c : charArray) {
            if(c == '(') {
            	sum++;
            }
            if(c == ')') {
            	sum--;
            }
            if(sum < 0) {
            	answer = false;
            }
        }
        if(sum != 0) {
        	answer = false;
        }

        return answer;
    }
}