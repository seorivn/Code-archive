class Solution {
    int[] numbers;
    int target;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        return dfs(0, 0);
    }

    public int dfs(int index, int cur) {
        if (index == numbers.length) {
            if (cur == target) return 1;
            else return 0;
        }

        return dfs(index + 1, cur + numbers[index]) 
             + dfs(index + 1, cur - numbers[index]);
    }
}