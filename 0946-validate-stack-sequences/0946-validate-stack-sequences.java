class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0; // Pointer simulating stack top position
        int j = 0; // Pointer for popped array
        
        for (int val : pushed) {
            pushed[i] = val; // Equivalent to stack.push(val)
            while (i >= 0 && pushed[i] == popped[j]) {
                i--; // Equivalent to stack.pop()
                j++;
            }
            i++;
        }
        
        return i == 0;
    }
}