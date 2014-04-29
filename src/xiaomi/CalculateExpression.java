package xiaomi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * 字符串的四则运算。给出一个字符串，包含0~9的数字和+ - * /()的运算符，<BR>
 * -仅代表减号不代表负数。举例如下：<BR>
 * 输入：1+2*(3-4)<BR>
 * 输出：-1.<BR>
 * @company 小米
 * @author xiehai
 * @date 2014-2-18 下午03:43:30 
 */
public class CalculateExpression {
    /**操作符*/
    private final char []OPERATOR = {'+', '-', '*', '/', '(', ')'};
    /**空字符串*/
    private final String EMPTY = "";
    /**左括号*/
    private final String LEFT_PARENTHESIS = "("; 
    /**右括号*/
    private final String RIGHT_PARENTHESIS = ")";
    /**加号*/
    private final String PLUS_SIGN = "+"; 
    /**减号*/
    private final String HYPHEN_MINUS = "-";
    /**乘号*/
    private final String ASTERISK = "*";
    /**除号*/
    private final String SOLIDUS = "/";
    /**井号*/
    private final String POUND = "#";
    /**数字0*/
    private final int ZERO = 0;
    /**数字1*/
    private final int ONE = 1;
    private Map<String, Integer> priority;
    
    /** 
     * 将字符串表达式分割成单个元素,每个元素是数字或操作符
     * @param str
     * @return
     */
    private Queue<String> getEveryPart(String str){
	Queue<String> queue = new LinkedList<String>();
	int len = str.length();
	StringBuilder number = new StringBuilder();
	for(int i = 0; i < len; ++i){
	   char temp = str.charAt(i);
	   if(isOperator(temp)){
	       if(!EMPTY.equals(number.toString())){
		   queue.offer(number.toString());
	       }
	       number.setLength(ZERO);
	       queue.offer(EMPTY+temp);
	   }else{
	       number.append(temp);
	       if(i == len-1){
		   queue.offer(number.toString());
	       }
	   }
	}

	return queue;
    }
    /** 
     * 判断表达式是否合法
     * @param str
     * @return
     */
    private boolean isLeagl(Queue<String> queue){
	boolean flg = true;
	boolean isFirst = true;
	int count = 0;//"("的数量
	int operatorCount = 0;//操作符的数量
	boolean isSymbol = false;//前一个字符是否是操作符
	@SuppressWarnings("unused")
	int i = 0;
	while(ZERO != queue.size()){
	    String temp = queue.poll();
	    if(isFirst){
		if(ONE == temp.length() && isOperator(temp.charAt(ZERO))){//开头是操作符
		    flg = false;
		    break;
		}
		isFirst = false;
	    }else{
		if(isOperator(temp.charAt(ZERO))){
		    if(LEFT_PARENTHESIS.equals(temp)){
			if(isSymbol){
			    count ++;
			}else{//格式如：12(1-5)
			    flg = false;
			    break;
			}
		    }else if(RIGHT_PARENTHESIS.equals(temp)){
			if(isSymbol){//格式如：(A-B*)
			    flg = false;
			    break;
			}
			count --;
		    }else{
			isSymbol = true;
			operatorCount ++;
		    }
		}else{
		    operatorCount --;
		    isSymbol = false;
		}
	    }
	    i ++;
	}
	if(ZERO != count){//括号匹配错误
	    flg = false;
	}else if(ZERO != operatorCount){//符号匹配错误
	    flg = false;
	}else if(isSymbol){//结尾是操作符
	    flg = false;
	}
	return flg;
    }
    
    /** 
     * 当前位置的字符是否是操作符
     * @param ch
     * @return
     */
    private boolean isOperator(char ch){
	boolean flg = false;
	for(int i = 0; i < OPERATOR.length; ++i){
	    if(ch == OPERATOR[i]){
		flg = true;
	    }
	}

	return flg;
    }
    
    /** 
     * <B>将不同的表达式转换为逆波兰式(Reverse Polish notation)</B><BR>
     * 首先需要分配2个栈，一个作为临时存储运算符的栈S1（含一个结束符号），<BR>
     * 一个作为输入逆波兰式的栈S2（空栈），S1栈可先放入优先级最低的运算符#，<BR>
     * 注意，中缀式应以此最低优先级的运算符结束。可指定其他字符，不一定非#不可。<BR>
     * 从中缀式的左端开始取字符，逐序进行如下步骤：<BR>
     * (1)若取出的字符是操作数，则分析出完整的运算数，该操作数直接送入S2栈<BR>
     * (2)若取出的字符是运算符，则将该运算符与S1栈栈顶元素比较，<BR>
     * 如果该运算符优先级大于S1栈栈顶运算符优先级，则将该运算符进S1栈，否则，<BR>
     * 将S1栈的栈顶运算符弹出，送入S2栈中，直至S1栈栈顶运算符低于（不包括等于）该运算符优先级，<BR>
     * 则将该运算符送入S1栈。<BR>
     * (3)若取出的字符是"("，则直接送入S1栈栈顶。<BR>
     * (4)若取出的字符是")"，则将距离S1栈栈顶最近的"("之间的运算符，逐个出栈，依次送入S2栈，此时抛弃"("。<BR>
     * (5)重复上面的1~4步，直至处理完所有的输入字符<BR>
     * (6)若取出的字符是"#"，则将S1栈内所有运算符(不包括"#")，逐个出栈，依次送入S2栈。<BR>
     * @param str
     * @return 逆波兰式的Stack
     */
    private Stack<String> RPN(String str){
	Stack<String> operator = new Stack<String>();
	Stack<String> number = new Stack<String>();
	Queue<String> queue = getEveryPart(str);
	operator.push(POUND);
	initPriority();
	while(ZERO != queue.size()){
	    String exp = queue.poll();
	    if(isOperator(exp.charAt(ZERO)) && ONE == exp.length()){
		if(LEFT_PARENTHESIS.equals(exp)){
		    operator.push(exp);
		}else if(RIGHT_PARENTHESIS.equals(exp)){
		    while(true){
			String op = operator.peek();
			if(LEFT_PARENTHESIS.equals(op)){
			    operator.pop();
			    break;
			}else{
			    number.push(operator.pop());
			}
		    }
		}else{//其他操作符
		    String op = operator.peek();
		    int expP = priority.get(exp);
		    int opP = priority.get(op);
		    if(expP > opP ){
			operator.push(exp);
		    }else{

			while(true){
			    op = operator.peek();
			    opP = priority.get(op);
			    if(opP < expP){
				break;
			    }else{
				number.push(op);
				operator.pop();
			    }
			}
			operator.push(exp);
		    }
		}
	    }else{
		number.push(exp);
	    }
	}
	while(POUND != operator.peek()){
	    number.push(operator.pop());
	}
	operator.clear();
	//倒序表达式
	while(ZERO != number.size()){
	    operator.push(number.pop());
	}
	return operator;
    }
    
    /** 
     * 计算表达式的值
     * @param stack
     * @return
     */
    private double calculate(Stack<String> stack){
	Stack<String> left = new Stack<String>();
	double result = 0d;
	while(ONE != stack.size()){
	    String pre = stack.pop();//第一个操作数
	    String next = stack.pop();//第二个操作数
	    String op = stack.pop();//操作符
	    char operator = op.charAt(ZERO);
	    if(isOperator(operator) && ONE == op.length()){//保证长度为1,排除负数的情况
		switch (operator) {
		    case '+':
			result = Double.parseDouble(pre) + Double.parseDouble(next);
			break;
		    case '-':
			result = Double.parseDouble(pre) - Double.parseDouble(next);
			break;
		    case '*':
        		result = Double.parseDouble(pre) * Double.parseDouble(next);
        		break;
		    case '/':
			result = Double.parseDouble(pre) / Double.parseDouble(next);
			break;
        	    default:
        		break;
		}
		stack.push(String.valueOf(result));
		while(ZERO != left.size()){//计算玩后将没计算的表达式加入栈中
		    stack.push(left.pop());
		}
	    }else{
		left.push(pre);//将栈顶的数字放入剩余left栈中
		stack.push(op);
		stack.push(next);
	    }
	}
	result = Double.parseDouble(stack.pop());
	return result;
    }
    
    /** 
     * 公共计算方法
     * @param str
     * @return
     */
    public double calculate(String str){
	return calculate(RPN(str));
    }
    
    /**
     * 是否是合法的表达式<BR>
     * 一个表达式可以看作一个数字<BR>
     * 比如:A+B, A-(B+A),均为数字 
     * @return
     */
    public boolean isExpression(String str){
	return isLeagl(getEveryPart(str));
    }
    
    /** 
     * 初始化优先级Map
     */
    private void initPriority(){
	priority = new HashMap<String, Integer>();
	priority.put(LEFT_PARENTHESIS, 0);
	priority.put(POUND, 1);
	priority.put(PLUS_SIGN, 2);
	priority.put(HYPHEN_MINUS, 2);
	priority.put(ASTERISK, 3);
	priority.put(SOLIDUS, 3);
    }
    
    public static void main(String[] args) {
	String str = "1/(3*3)+2*(3-4.5)";
	CalculateExpression ce = new CalculateExpression();
	System.out.println(ce.isExpression(str) ? str + " = "+ ce.calculate(str) : "表达式非法!");
    }
}