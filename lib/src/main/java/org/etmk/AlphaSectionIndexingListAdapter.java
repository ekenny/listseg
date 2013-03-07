package org.etmk;

import java.util.List;

public abstract class AlphaSectionIndexingListAdapter<T> extends
		SectionIndexingListAdapter<T, String, String> {

	public AlphaSectionIndexingListAdapter(List<T> objects,
			AlphaIndexingValueSelector<T> selector) {

		super(objects, selector, new AlphaPartitioner());
	}

}
