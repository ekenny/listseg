package org.etmk;

import java.util.Comparator;

public class AlphaPartitioner extends Partitioner<String> {

	public AlphaPartitioner() {
		
		super("A", "Z",  new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
		});
	}
	
}
