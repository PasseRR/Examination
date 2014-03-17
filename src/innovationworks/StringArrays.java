package innovationworks;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个字符数组，里面的字符可能是a-z、A-Z、0-9。<br>
 * 现在要求对数组进行排序，要求所有小写字符放在最前面，<br>
 * 所有大写字符放在中间，所有数字放在最后，而且各部分内部分别有序。<br>
 * 即abcABC123
 * @company 创新工厂
 * @author xiehai
 * @date 2014-2-10 下午02:21:28 
 */
public class StringArrays {
    /**字符字典*/
    private static Map<Character, Integer> charMap = new HashMap<Character, Integer>();
    
    public StringArrays(){
	this.init();
    }
    
    /** 
     * 按照题目要求初始化字典,按照abcABC012排序
     */
    private void init(){
	int i = 1;
	for(char c = 'a'; c <= 'z'; ++c){
	    charMap.put(c, i++);
	}
	for(char c = 'A'; c <= 'Z'; ++c){
	    charMap.put(c, i++);
	}
	for(char c = '0'; c <= '9'; ++c){
	    charMap.put(c, i++);
	}
    }
    
    /**
     * 顺序排序(选择排序) 
     * @param str
     * @return
     */
    public String OrderSort(String str){
	char []data = str.toCharArray();
	for(int i = 0; i < data.length; ++i){
	    int k = i;
	    for(int j = i; j < data.length; ++j){
		if(charMap.get(data[k]) > charMap.get(data[j])){
		    k = j;
		}
	    }
	    char temp = data[i];
	    data[i] = data[k];
	    data[k] = temp;
	}

	return new String(data);
    }
    
    /** 
     * 应为部分是有序的,使用插入排序
     * @param str
     * @return
     */
    public String InsertSort(String str){
	char []data = str.toCharArray();
	for(int i = 1; i < data.length; ++i){
	    int j = i-1;
	    char temp = data[i];
	    while(j >= 0
		    && charMap.get(temp) < charMap.get(data[j])){
		data[j+1] = data[j];
		j--;
	    }
	    data[j+1] = temp;
	}
	
	return new String(data);
    }
    
    public static void main(String[] args) {
	StringArrays sa = new StringArrays();
	String str = "18759089WERTWBVCMNBVCFkjhgf760623SHUTOAsuitASFtuYTASStotoDa1234adfdafd";
	System.out.println(sa.OrderSort(str));
	System.out.println(sa.InsertSort(str));
    }
}
