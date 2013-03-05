package org.etmk;

public abstract class AlphaIndexingValueSelector<T> implements
		IndexingValueSelector<T, String, Character> {

	
	@Override
	public String getSectionHeader(Character indexValue) {
		return indexValue.toString();
	}
	
}
