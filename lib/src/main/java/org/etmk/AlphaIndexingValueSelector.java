package org.etmk;

public abstract class AlphaIndexingValueSelector<T> implements
		IndexingValueSelector<T, String, String> {

	
	@Override
	public String getSectionHeader(String indexValue) {
		return indexValue;
	}
	
}
