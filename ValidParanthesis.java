class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s.length() == 0) return true;
        if(s.length() == 1) return false;

        int i = 0;
        while(i<s.length()){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else if((!stack.isEmpty
()) && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')){
                if(s.charAt(i) == ')' && stack.pop() != '(')
                   return false;
                else if(s.charAt(i) == ']' && stack.pop() != '[')
                    return false;
                else if(s.charAt(i) == '}' && stack.pop() != '{')
                    return false;
            }
            else return false;
            i++;
        }
        if(i == s.length() && stack.isEmpty()) return true;
        return false;
    }
}
