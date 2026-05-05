class Solution {
    public int evalRPN(String[] tokens) {
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int count = 0;
        for(String c: tokens){
            if(c.equals("+")){
                stack.push(stack.pop() + stack.pop());
            } else if(c.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if(c.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if(c.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}