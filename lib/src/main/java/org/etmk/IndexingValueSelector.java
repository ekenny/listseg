package org.etmk;


/**
 * @author eric
 *
 * @param <D> The type of the Data objects that will be indexed.
 * @param <H> The type of the Header objects.  Probably never need anything more than String, but let's not assume.
 * @param <I> The type of the value that we are indexing on. For alphabetical indexing, this would be Character, for example.
 */
public interface IndexingValueSelector<D, H, I> {
	
	/**
	 * Returns the member of the given object that is to be used for indexing (i.e., partitioning or grouping) the list of
	 * data objects.
	 * 
	 * @param forThisDataObject
	 * 
	 * @return
	 */
	public I getIndexValue(D forThisDataObject);
	
	/**
	 * Implementation should derive the section header value either from the Index value itself, or by using
	 * the Index value to look up the header value.  
	 * 
	 * In the alphabetical example, where "I" is "Character", and "H" is "String", you would just return indexValue.toString();
	 * 
	 * @param section
	 * @return
	 */
	public H getSectionHeader(I indexValue);
	
}