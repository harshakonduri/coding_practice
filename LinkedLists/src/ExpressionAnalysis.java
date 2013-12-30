class ExpressionAnalysis {
    public static void main(String [] args) {
	String infixExpressions = "1+2*3+4";
	//infixToPostFix(infixExpressions);
	//infixToPrefix(infixExpressions);
	evalInfix(infixExpressions);
    }
    static void evalInfix(String input) {
	if(0 == input.length()) {
	    return;
	}
	Stacks operators = new Stacks();
	LinkedList operands = new LinkedList();
	int i = 0;
	while(i < input.length()) {
	    char c = input.charAt(i);
	    if(c >=48 && c <=57) {
		operands.insert(c-48);
	    }//end if
	    else {
		Node top = operators.peek();
		switch(c) {
		case '+':
		case '-':
		    if(null == top) {
			operators.push((int)c);
		    }//
		    else { // check for more priority symbols below in stack
			
			switch(top.data) {
			case '*':
			case '/':
			    top = operators.pop();
			    do {
			    int oper1 = operands.getTail().data;
			    int oper2 = operands.getTail().data;
			    
			    switch(top.data) {
			    case '+':
				int res = oper1+oper2;
				operands.insert(res);
				break;
			    case '-':
				int res1 = oper1-oper2;
				operands.insert(res1);
				break;
			    case '*':
				int res2 = oper1*oper2;
				operands.insert(res2);
				break;
			    case '/':
				int res3 = oper1/oper2;
				operands.insert(res3);
				break;
			    }
			    top = operators.pop();
			    }while(null != top);
			    
				//			    break;
			    break;
			}//end switch
			operators.push((int)c);
		    }
		    break;
		case '*':
		    operators.push((int)c);
		    break;
		case '/':
		    
		     if(null == top) {
			operators.push((int)c);
		    }//
		    else { // check for more priority symbols below in stack
			
			switch(top.data) {
			case '*':
			    top = operators.pop();
			    do {
			    int oper1 = operands.getTail().data;
			    int oper2 = operands.getTail().data;
			    
			    switch(top.data) {
			    case '+':
				int res = oper1+oper2;
				operands.insert(res);
				break;
			    case '-':
				int res1 = oper1-oper2;
				operands.insert(res1);
				break;
			    case '*':
				int res2 = oper1*oper2;
				operands.insert(res2);
				break;
			    case '/':
				int res3 = oper1/oper2;
				operands.insert(res3);
				break;
			    }
			    top = operators.pop();
			    }while(null != top);
			    operators.push((int)c);
			    break;
		}//end switch
	    }// end else
		}
	    
		    
		} //end while
	    i++;
	}
		Node tt = operators.pop();
			    do {
			    int oper1 = operands.getTail().data;
			    int oper2 = operands.getTail().data;
			    
			    switch(tt.data) {
			    case '+':
				int res = oper1+oper2;
				operands.insert(res);
				break;
			    case '-':
				int res1 = oper1-oper2;
				operands.insert(res1);
				break;
			    case '*':
				int res2 = oper1*oper2;
				operands.insert(res2);
				break;
			    case '/':
				int res3 = oper1/oper2;
				operands.insert(res3);
				break;
			    }
			    tt = operators.pop();
			    }while(null != tt);
			    System.out.println(operands.getHead().data);
    }
    static void infixToPrefix(String input) {
	if(0 == input.length()) {
	    return;
	}
	StringBuffer output = new StringBuffer();
	Stacks operators = new Stacks();
	LinkedList operands = new LinkedList();
	int i = 0;
	while(i < input.length()) {
	    char c = input.charAt(i);
	    if(c >=97 && c <=122) {
		operands.insert((int)c);
	    }
	    else {
		Node top = operators.peek();
		switch(c) {
		case '+':
		case '-':
		    operators.push((int)c);
		    break;
		case '*':
		    if(null == top) {
			operators.push((int)c);
		    }
		    else {
			switch(top.data) {
			default:
			    Node temp = operators.pop();
			    int count = 0;
			    while(null != temp) {
				output.append((char)temp.data);
				temp = operators.pop();
				count++;
			    }
			    while(count > 0) {
				Node h = operands.getHead();
				output.append((char)h.data);
				count--;
			    }
			}
			operators.push((int)c);
		    }
		    break;
		case '/':
		    if(null == top || '*' == top.data) {
			operators.push((int)c);
		    }
		    else {
			switch(top.data) {
			case '+':
			case '-':
			    Node temp = operators.pop();
			    int count = 0;
			    while(null != temp) {
				output.append((char)temp.data);
				temp = operators.pop();
				count++;
			    }//end while
			    while(count > 0) {
				Node h = operands.getHead();
				output.append((char)h.data);
				count--;
			    }//end while
			    break;			    
			}//end switch
			operators.push((int)c);
		    }//end else
		    break;
		case '(':
		    break;
		case ')':
		    break;
		}//end outer switch
	    }//end else
	    i++;
	}//end while
	Node temp = operators.pop();
	while(null != temp) {
	      output.append((char)temp.data);
	      temp = operators.pop();
        }//append remaining operators
	temp = operands.getHead();
	while(null != temp) {
	    output.append((char)temp.data);
	    temp = operands.getHead();
	}//append remaining operands
	System.out.println(output);
    }
    static void infixToPostFix(String input) {
	//int star = 1,division = 2,plus = 3,minus = 3;
	if(input.length() <=0) {
	    return;
	}
	StringBuffer output = new StringBuffer();
	Stacks operandStack = new Stacks();
	int i = 0;
	while(i < input.length()) {
	    char c = input.charAt(i);
	    if(c >=97 && c <=122) {
		output.append(c);
	    }
	    else {
		    Node top = operandStack.peek();
		switch (c) {
		case '+':
		case '-':
		System.out.println("---");
			if(null == top) {
				operandStack.push((int) c);
			}
			else {
				switch(top.data) {
				case '*':
				case '/':
					output.append((char)top.data);
					operandStack.pop();
					System.out.println("--");
					operandStack.push((int) c);
					break;
				default:
					operandStack.push((int) c);
					break;
				}
			}
		    break;
		case '*':
	            operandStack.push((int) c);
		    break;
		case '/':
		    if(null == top || '*' != top.data) {
			operandStack.push((int) c);
		    }
		    else {
			output.append((char)operandStack.pop().data); 
			operandStack.push((int) c);
		    }
		    break;
		case '(':
		    operandStack.push((int) c);
		    break;
		case ')':
		    Node temp = operandStack.pop();
		    while(temp.data != '(') {
			output.append((char)temp.data);
			temp = operandStack.pop();
		    }
		    break;
		}//end switch
	    }//end else
	    i++;
	}//end while
	 Node temp = operandStack.pop();
	    while(null != temp) {
		output.append((char)temp.data);
		temp = operandStack.pop();
	    }
	System.out.println(output);
    }
}
