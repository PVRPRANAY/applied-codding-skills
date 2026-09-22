class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int ast : asteroids) {
            boolean exploded = false;
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int top = stack.peek();

                if (top < -ast) {
                    stack.pop();
                } else if (top == -ast) {
                    stack.pop(); 
                    exploded = true;
                    break;
                } else {
                    exploded = true; 
                    break;
                }
            }
            if (!exploded) {
                stack.push(ast);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}