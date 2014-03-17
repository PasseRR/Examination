package huawei;

/**
 * 通过键盘输入一串小写字母(a~z)组成的字符串。<br>
 * 请编写一个字符串压缩程序，将字符串中连续出席的重复字母进行压缩，<br>
 * 并输出压缩后的字符串。压缩规则：<br>
 * 1、仅压缩连续重复出现的字符。比如字符串"abcbc"由于无连续重复字符，压缩后的字符串还是"abcbc"。<br>
 * 2、压缩字段的格式为"字符重复的次数+字符"。例如：字符串"xxxyyyyyyz"压缩后就成为"3x6yz"。
 * @company 华为
 * @author xiehai
 * @date 2014-2-13 下午02:21:00 
 */
public class StringCompression {
    /** 
     * 字符串压缩方法
     * @param str
     * @return 返回指定压缩格式的字符串
     */
    public String stringCompression(String str){
	char []data = str.toCharArray();
	int count = 1;
	if(1 == str.length()){
	    return str;
	}
	StringBuilder sb = new StringBuilder();
	for(int i = 1; i < data.length; ++i){//从第二个字符开始比较
	    if(data[i] == data[i-1]){
		count ++;
	    }else{
		if(1 != count){//如果计数是1,则省略
		    sb.append(count);
		}
		sb.append(data[i-1]);
		count = 1;
	    }
	    
	    if(i == data.length-1){//判断最后一个字符和倒数第二个字符是否相同
		if(data[i] == data[i-1]){
		    sb.append(count);
		    sb.append(data[i-1]);//相同,直接累加
		}else{
		    sb.append(data[i]);//否则,添加最后一个字符到返回结果,循环遍历不到该处
		}
	    }
	}
	
	return sb.toString();
    }
    
    public static void main(String[] args) {
	StringCompression sc = new StringCompression();
	String e = "a";
	String f = "aa";
	String a = "abcbc";
	String b = "abcbcc";
	String c = "xxxyyyyyyyyyyyyyyyyyyyyyyyyyyyyz";
	System.out.println(sc.stringCompression(a));
	System.out.println(sc.stringCompression(b));
	System.out.println(sc.stringCompression(c));
	System.out.println(sc.stringCompression(e));
	System.out.println(sc.stringCompression(f));
    }
}
