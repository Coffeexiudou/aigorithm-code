/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are+,-,*,/. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

class Solution {
public:
    int evalRPN(vector<string> &tokens) {
        stack<string> item;
        stack<int> num;
        int result = 0;
        int len = tokens.size();
        for(int i = len-1;i>=0;i--){
            item.push(tokens[i]);
        }
        while(!item.empty()){
            string top = item.top();
            if(top=="+"){
                item.pop();
                int a = num.top();
                num.pop();
                int b = num.top();
                num.pop();
                num.push(a+b);
                continue;
            }
            if(top == "-"){
                item.pop();
                int a = num.top();
                num.pop();
                int b = num.top();
                num.pop();
                num.push(b-a);
                continue;
            }
            if(top == "*"){
                item.pop();
                int a = num.top();
                num.pop();
                int b = num.top();
                num.pop();
                num.push(a*b);
                continue;
            }
            if(top == "/"){
                item.pop();
                int a = num.top();
                num.pop();
                int b = num.top();
                num.pop();
                num.push(b/a);
                continue;
               }
             int temp = atoi(top.c_str());
             num.push(temp);
             item.pop();
        }
        return num.top();
        
    }
};

//略微优化版本，但核心思想都是用栈

class Solution {
public:
    int evalRPN(vector<string> &tokens) {
       stack<int> num;
       int size = tokens.size();
       for(int i =0;i<size;i++){
           string s = tokens[i];
           if(s=="+"||s=="-"||s=="*"||s=="/"){
               int a = num.top();num.pop();
               int b = num.top();num.pop();
               if(s=="+"){
                   num.push(b+a);
               }
               if(s=="-"){
                   num.push(b-a);
               }
               if(s=="*"){
                   num.push(b*a);
               }
               if(s=="/"){
                   num.push(b/a);
               }
           }
           else{
               num.push(atoi(s.c_str()));
           }
       }
         return num.top();
     }
};