package interviewquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NonrepeatedElements {

	public static void main(String[] args) {
		// print non-repeated elements from a list 
List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(12);
		list.add(7);
		list.add(12);
		list.add(7);
		list.add(18);
		list.add(7);
		list.add(9);
		list.add(8);
		list.add(3);
		
		List<Integer> nonRepeated = new ArrayList<>();	
		
		nonRepeatedEl(list);
		
		getUniqueEl (list);
	}

	
	//1st way olmadi.
	public static void nonRepeatedEl(List<Integer> list) {
		List<Integer> nonRepeated = new ArrayList<>();
		List<Integer> repeated = new ArrayList<>();
		
		for (int i = 0; i<list.size(); i++) {
			for (int j=i+1; j<list.size(); j++) {
				if (list.get(i) == list.get(j)) {
					if (!repeated.contains(list.get(j))) {
						repeated.add(list.get(j));
					}
				}
				else {
					if (!nonRepeated.contains(list.get(j))) {
					nonRepeated.add(list.get(j));}
				}
			}
		}
		System.out.println(nonRepeated);
		System.out.println(repeated);
	}
	
	//2nd way HashMap
	public static void  getUniqueEl (List<Integer> list) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		List<Integer> nonRepeated = new ArrayList<>();
		
		for (Integer w : list) {
		
			if (!hm.containsKey(w)) {
				hm.put(w, 1);
			} else {
				hm.put(w, hm.get(w)+1);
			}
	
		}
		System.out.println(hm);
	
		for (Integer w:list) {
			if (hm.get(w)==1) {
				nonRepeated.add(w);
			}
		}
		
		System.out.println(nonRepeated);
		
	}
	
}
