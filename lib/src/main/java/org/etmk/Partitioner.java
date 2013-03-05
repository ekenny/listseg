package org.etmk;

import java.util.Comparator;

public class Partitioner<I> {

	private I minBin;
	
	private I maxBin;
	
	private I currentVal;
	
	private boolean outOfBounds;
	
	private Comparator<I> differ;
	
	public Partitioner(I minBin, I maxBin, Comparator<I> differ) {
		super();
		this.minBin = minBin;
		this.maxBin = maxBin;
		this.differ = differ;
	}

	public I getMinBin() {
		return minBin;
	}

	public void setMinBin(I minBin) {
		this.minBin = minBin;
	}

	public I getMaxBin() {
		return maxBin;
	}

	public void setMaxBin(I maxBin) {
		this.maxBin = maxBin;
	}

	public void reset() {
		currentVal = null;
		outOfBounds = false;
	}
	
	public boolean indexValueChanged(I val) {
		return currentVal == null || !currentVal.equals(val);
	}
	
	public boolean isBinBoundary(I val) {
		
		boolean isBoundary = false;
		if (indexValueChanged(val)) {
			currentVal = val;
			isBoundary = isBoundaryValue(val);
		}
		return isBoundary;
	}
	
	/*
	 * Changes in index values that are out of bounds are not boundary values.  For example,
	 * in the case of alpha partitioning, symbols less than 'A' should be grouped into a single
	 * section.
	 */
	private boolean isBoundaryValue(I val) {
		
		boolean nowOutOfBounds = differ.compare(val, minBin) < 1 || differ.compare(val, maxBin) > 0;
		boolean isBoundary =  (nowOutOfBounds && !outOfBounds) 
			|| (differ.compare(val, minBin) >= 0 &&  differ.compare(val, maxBin) <= 0);
		outOfBounds = nowOutOfBounds;
		return isBoundary;
	}

	public Comparator<I> getIndexComparator() {
		return differ;
	}

}
