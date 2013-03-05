package org.etmk;

import java.util.Comparator;

public class AlphaPartitioner extends Partitioner<Character> {

	public AlphaPartitioner() {
		
		super('A', 'Z', new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				
				return o1.compareTo(o2);
			}
		});
	}
	
}
