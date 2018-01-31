package TreeSetTest;

import java.util.Objects;

/**
 * 设置树集的要放入的Item，需要注意，树集的元素要么得实现Comparable接口（内部，实现compateTo）；要么构造集合的时候必须提供了个Comparator
 * （外部，实现compare），而这里重写了hashcode，所以要重写equals方法。
 * 从java6开始 TreeSet实现了NavigableSet接口，增加了几个便于定位元素以及反向遍历的方法。
 * @author Lucifer
 *
 */
public class Item implements Comparable<Item>{
	private String description;
	private int partNumber;
	
	public Item(String aDescription, int aPartNumber){
		description = aDescription;
		partNumber = aPartNumber;
	}
	
	public String getDescription(){ 
		return description;
	}
	
	public String toString(){
		return "[description=" + description +", partNumber=" + partNumber +"]";
	}
	
	public boolean equals(Object otherObject){
		if(this == otherObject) return true;
		if(otherObject == null) return false;
		if(getClass() != otherObject.getClass())return false;
		Item other = (Item)otherObject;
		return Objects.equals(description, other.description) && partNumber == other.partNumber;
	}
	
	public int hashCode(){
		return Objects.hash(description,partNumber);
	}
	
	public int compareTo(Item other){
		int diff = Integer.compare(partNumber, other.partNumber);
		return diff != 0 ? diff : description.compareTo(other.description);
	}
}
