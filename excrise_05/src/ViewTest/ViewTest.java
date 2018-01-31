package ViewTest;
import java.util.*;
import java.util.Map.Entry;
public class ViewTest {
	public static void main(String[] args) {
		HashMap<Integer , String > hashmap = new HashMap<>();
		hashmap.put(1, "黄一东");
		hashmap.put(2, "黄玮东");
		hashmap.put(3, "黄绿蓝");
		
		// 获取主键key
		Set<Integer> key = hashmap.keySet();
		Iterator a = key.iterator();
		while(a.hasNext()){
			System.out.print(a.next() + " ");
		}
		System.out.println(" ----------");
		// 获取值
		Collection<String> value = hashmap.values();
		Iterator b = value.iterator();
		while(b.hasNext()){
			System.out.print(b.next() + " ");
		}
		
		System.out.println("------------");
		// 返回键值对
		Set<Entry<Integer, String>> entry =   hashmap.entrySet();
		Iterator<Entry<Integer,String>> c = entry.iterator();
		while(c.hasNext()){
			Entry<Integer, String> entry1 = c.next();
			int i = entry1.getKey();
			String j = entry1.getValue();
			System.out.println(i+"  "+j);
		}
		
	}
}
