class BasicCalculator {
    public int calculate(String s) {
        int res = 0;
        Stack<String> stack = new Stack<String>();
        if(s == null || s.length() == 0) return 0;
         int i = 0;
        while(i < s.length())
        {
            if(s.charAt(i) == ' ')
            {
                i++;
                continue;
            }
            if(s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-'){
                String temp = Character.toString(s.charAt(i));
                stack.push(temp);
                i++;
            }

            else if(Character.isDigit(s.charAt(i))){
                String temp = "";
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    temp = temp + Character.toString(s.charAt(i));
                    i++;
                }
                stack.push(temp);
            }

            else{
                if(s.charAt(i)!=' '){
                    String result = "";
                while(!stack.isEmpty()){
                    //String temp = stack.pop();
                   // System.out.println(stack);
                   int num1 = 0; char sign = '+';int num2 = 0;
                    if(!stack.isEmpty())
                    num1 = Integer.parseInt(stack.pop());

                    if(!stack.isEmpty()){
                       sign = stack.pop().charAt(0);
                        if(sign == '('){
                        stack.push(Integer.toString(num1));
                        break;
                    }

                    if(!stack.isEmpty()){
                      num2 = Integer.parseInt(stack.pop());
                        if(!stack.isEmpty() && stack.peek().equals("-")){
                            stack.pop();
                            stack.push("+");
                            num2 = -num2;
                        }
                    }

                    if(sign == '+'){
                        res = num1 + num2;
                        result = Integer.toString(res);
                        stack.push(result);
                    }
                    else if(sign == '-'){
                        res = num2 - num1;
                        result = Integer.toString(res);
                        stack.push(result);
                    }

                }}}

                i++;

            }

        }


        String result = "";
        if(stack.size() == 1) return Integer.parseInt(stack.pop());
     while(!stack.isEmpty()){
                   int num1 = 0; char sign = '+';int num2 = 0;
                    if(!stack.isEmpty())
                    num1 = Integer.parseInt(stack.pop());

                    if(!stack.isEmpty()){
                       sign = stack.pop().charAt(0);

                    if(!stack.isEmpty()){
                       num2 = Integer.parseInt(stack.pop());
                        if(!stack.isEmpty() && stack.peek().equals("-")){
                            stack.pop();
                            stack.push("+");
                            num2 = -num2;
                        }

                    }

                    if(sign == '+'){
                        res = num1 + num2;
                        result = Integer.toString(res);
                        stack.push(result);
                    }
                    else if(sign == '-'){
                        res = num2 - num1;
                        result = Integer.toString(res);
                        stack.push(result);
                    }

                }
     }

        if(!stack.isEmpty()) return Integer.parseInt(stack.pop());
        return res;
            }
    }
