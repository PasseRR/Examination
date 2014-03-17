package xiaomi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * �ַ������������㡣����һ���ַ���������0~9�����ֺ�+ - * /()���������<BR>
 * -��������Ų����������������£�<BR>
 * ���룺1+2*(3-4)<BR>
 * �����-1.<BR>
 * @company С��
 * @author xiehai
 * @date 2014-2-18 ����03:43:30 
 */
public class CalculateExpression {
    /**������*/
    private final char []OPERATOR = {'+', '-', '*', '/', '(', ')'};
    /**���ַ���*/
    private final String EMPTY = "";
    /**������*/
    private final String LEFT_PARENTHESIS = "("; 
    /**������*/
    private final String RIGHT_PARENTHESIS = ")";
    /**�Ӻ�*/
    private final String PLUS_SIGN = "+"; 
    /**����*/
    private final String HYPHEN_MINUS = "-";
    /**�˺�*/
    private final String ASTERISK = "*";
    /**����*/
    private final String SOLIDUS = "/";
    /**����*/
    private final String POUND = "#";
    /**����0*/
    private final int ZERO = 0;
    /**����1*/
    private final int ONE = 1;
    private Map<String, Integer> priority;
    
    /** 
     * ���ַ������ʽ�ָ�ɵ���Ԫ��,ÿ��Ԫ�������ֻ������
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
     * �жϱ��ʽ�Ƿ�Ϸ�
     * @param str
     * @return
     */
    private boolean isLeagl(Queue<String> queue){
	boolean flg = true;
	boolean isFirst = true;
	int count = 0;//"("������
	int operatorCount = 0;//������������
	boolean isSymbol = false;//ǰһ���ַ��Ƿ��ǲ�����
	int i = 0;
	while(ZERO != queue.size()){
	    String temp = queue.poll();
	    if(isFirst){
		if(ONE == temp.length() && isOperator(temp.charAt(ZERO))){//��ͷ�ǲ�����
		    flg = false;
		    break;
		}
		isFirst = false;
	    }else{
		if(isOperator(temp.charAt(ZERO))){
		    if(LEFT_PARENTHESIS.equals(temp)){
			if(isSymbol){
			    count ++;
			}else{//��ʽ�磺12(1-5)
			    flg = false;
			    break;
			}
		    }else if(RIGHT_PARENTHESIS.equals(temp)){
			if(isSymbol){//��ʽ�磺(A-B*)
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
	if(ZERO != count){//����ƥ�����
	    flg = false;
	}else if(ZERO != operatorCount){//����ƥ�����
	    flg = false;
	}else if(isSymbol){//��β�ǲ�����
	    flg = false;
	}
	return flg;
    }
    
    /** 
     * ��ǰλ�õ��ַ��Ƿ��ǲ�����
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
     * <B>����ͬ�ı��ʽת��Ϊ�沨��ʽ(Reverse Polish notation)</B><BR>
     * ������Ҫ����2��ջ��һ����Ϊ��ʱ�洢�������ջS1����һ���������ţ���<BR>
     * һ����Ϊ�����沨��ʽ��ջS2����ջ����S1ջ���ȷ������ȼ���͵������#��<BR>
     * ע�⣬��׺ʽӦ�Դ�������ȼ����������������ָ�������ַ�����һ����#���ɡ�<BR>
     * ����׺ʽ����˿�ʼȡ�ַ�������������²��裺<BR>
     * (1)��ȡ�����ַ��ǲ�����������������������������ò�����ֱ������S2ջ<BR>
     * (2)��ȡ�����ַ�����������򽫸��������S1ջջ��Ԫ�رȽϣ�<BR>
     * �������������ȼ�����S1ջջ����������ȼ����򽫸��������S1ջ������<BR>
     * ��S1ջ��ջ�����������������S2ջ�У�ֱ��S1ջջ����������ڣ����������ڣ�����������ȼ���<BR>
     * �򽫸����������S1ջ��<BR>
     * (3)��ȡ�����ַ���"("����ֱ������S1ջջ����<BR>
     * (4)��ȡ�����ַ���")"���򽫾���S1ջջ�������"("֮���������������ջ����������S2ջ����ʱ����"("��<BR>
     * (5)�ظ������1~4����ֱ�����������е������ַ�<BR>
     * (6)��ȡ�����ַ���"#"����S1ջ�����������(������"#")�������ջ����������S2ջ��<BR>
     * @param str
     * @return �沨��ʽ��Stack
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
		}else{//����������
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
	//������ʽ
	while(ZERO != number.size()){
	    operator.push(number.pop());
	}
	return operator;
    }
    
    /** 
     * ������ʽ��ֵ
     * @param stack
     * @return
     */
    private double calculate(Stack<String> stack){
	Stack<String> left = new Stack<String>();
	double result = 0d;
	while(ONE != stack.size()){
	    String pre = stack.pop();//��һ��������
	    String next = stack.pop();//�ڶ���������
	    String op = stack.pop();//������
	    char operator = op.charAt(ZERO);
	    if(isOperator(operator) && ONE == op.length()){//��֤����Ϊ1,�ų����������
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
		while(ZERO != left.size()){//�������û����ı��ʽ����ջ��
		    stack.push(left.pop());
		}
	    }else{
		left.push(pre);//��ջ�������ַ���ʣ��leftջ��
		stack.push(op);
		stack.push(next);
	    }
	}
	result = Double.parseDouble(stack.pop());
	return result;
    }
    
    /** 
     * �������㷽��
     * @param str
     * @return
     */
    public double calculate(String str){
	return calculate(RPN(str));
    }
    
    /**
     * �Ƿ��ǺϷ��ı��ʽ<BR>
     * һ�����ʽ���Կ���һ������<BR>
     * ����:A+B, A-(B+A),��Ϊ���� 
     * @return
     */
    public boolean isExpression(String str){
	return isLeagl(getEveryPart(str));
    }
    
    /** 
     * ��ʼ�����ȼ�Map
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
	System.out.println(ce.isExpression(str) ? str + " = "+ ce.calculate(str) : "���ʽ�Ƿ�!");
    }
}