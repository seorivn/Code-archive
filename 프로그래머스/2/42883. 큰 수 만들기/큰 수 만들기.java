class Solution {
    public String solution(String number, int k) {
        StringBuilder stack = new StringBuilder();
        
        for (char c : number.toCharArray()) {
            // 제거할 숫자 남아있고, stack에 숫자가 있고, stack마지막 숫자보다 크면
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) < c) {
                stack.deleteCharAt(stack.length()-1); // 마지막 숫자 삭제
                k--;
            }
            stack.append(c);
        }
        
        return stack.substring(0, stack.length()-k);
    }
}