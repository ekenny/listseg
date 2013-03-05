package org.etmk;

import java.util.ArrayList;
import java.util.List;

import android.widget.SectionIndexer;

public class ListIndexer<D, H, I> implements SectionIndexer {

	// private static final String TAG =
	// AlphabeticalListIndexer.class.getSimpleName();

	private List<I> sections = null;

	private List<Integer> sectionPositions = null;

	private List<Integer> positionSectionMap = null;

	/**
	 * 
	 * @param preSortedList
	 * @param selector
	 * @return A NON-homogeneous List -- i.e., a list containing more than one
	 *         type -- This will be mostly D(ata) references with H(eader)
	 *         reference inserted at section boundaries.
	 */
	public List<Object> partitionPreSortedList(List<D> preSortedList,
			IndexingValueSelector<D, H, I> selector, Partitioner<I> partitioner) {
		sections = new ArrayList<I>();
		sectionPositions = new ArrayList<Integer>();
		positionSectionMap = new ArrayList<Integer>();
		List<Object> newList = new ArrayList<Object>();
		partitioner.reset();

		if (preSortedList != null) {
			Integer currentSection = null;

			for (D obj : preSortedList) {
				I objChar = selector.getIndexValue(obj);

				if (partitioner.isBinBoundary(objChar)) {
					currentSection = addHeader(selector, newList, objChar);
				}

				newList.add(obj);
				positionSectionMap.add(currentSection);
			}
		}
		// Log.d(TAG, String.format("sections (%d): %s", sections.size(),
		// Arrays.toString(sections.toArray()) ));
		// Log.d(TAG, String.format("sectionPositions (%d): %s",
		// sectionPositions.size(), Arrays.toString(sectionPositions.toArray())
		// ));
		// Log.d(TAG, String.format("positionSectionMap (%d): %s",
		// positionSectionMap.size(),
		// Arrays.toString(positionSectionMap.toArray()) ));

		return newList;
	}

	private Integer addHeader(IndexingValueSelector<D, H, I> selector,
			List<Object> newList, I currentIndexValue) {
		sections.add(currentIndexValue);
		H header = selector.getSectionHeader(currentIndexValue);
		newList.add(header);
		Integer sectionPosition = newList.size() - 1;
		sectionPositions.add(sectionPosition);
		positionSectionMap.add(sectionPosition);
		return sectionPosition;
	}

	@Override
	public int getPositionForSection(int section) {
		if (section >= sectionPositions.size()) {
			section = sectionPositions.size() - 1;
		}
		return sectionPositions.get(section);
	}

	@Override
	public int getSectionForPosition(int position) {

		if (positionSectionMap == null || !positionSectionMap.contains(position))	 {
			return 0;

		} else {
			return positionSectionMap.get(position);
		}
	}

	@Override
	public Object[] getSections() {
		return sections.toArray();
	}

	public boolean isSectionStart(int position) {
		return sectionPositions.contains(position);
	}
}
