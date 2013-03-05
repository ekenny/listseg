package org.etmk;


import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;
import android.widget.SectionIndexer;


/**
 * 
 *
 * @param <D> domain object type.  These are the objects you want to show in a list
 * @param <H> header object type.  Probably always a String, but you might want something more complex if you want tex and images in the header, for example.
 * @param <I> index type.  User-defined classes must override equals and hashCode for this to work properly.  For alphabetical indexing/partitioning, this would be Character, for example.  Each distinct index value is its own section in the list.
 */
public abstract class SectionIndexingListAdapter<D, H, I> extends BaseAdapter implements SectionIndexer, Filterable {

//	private static final String TAG = SectionIndexingListAdapter.class.getSimpleName();

	private static final int VIEW_TYPE_ITEM = 1;

	private static final int VIEW_TYPE_HEADER = 0;

	private ListIndexer<D, H, I> indexer = null;
	
	private IndexingValueSelector<D, H, I> selector;
	
	private Partitioner<I> partitioner;
	
	
	protected List<Object> items;
	
	public SectionIndexingListAdapter(List<D> objects, IndexingValueSelector<D, H, I> selector, Partitioner<I> partitioner) {
		//super(context, android.R.id.text1);
		super();
		this.selector = selector;
		this.partitioner = partitioner;
		indexer = new ListIndexer<D, H, I>();
		changeList(objects);
	}

	public void changeList(List<D> objects) {
		items = indexer.partitionPreSortedList(objects, selector, partitioner);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (getItemViewType(position) == VIEW_TYPE_HEADER) {
			return getSectionHeaderView((H) getItem(position), position, convertView, parent);
			
		} else {
			return getListItemView((D) getItem(position), position, convertView, parent);
		}
	}
	
	public abstract View getSectionHeaderView(H header, int position, View convertView, ViewGroup parent);
	
	public abstract View getListItemView(D item, int position, View convertView, ViewGroup parent);

	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		return items == null || items.size() == 0;
	}
	
	@Override
	public int getCount() {
		return items == null ? 0 : items.size();
	}
	
	@Override
	public Object getItem(int arg0) {
		return items.get(arg0);
	}
	
	@Override
	public boolean isEnabled(int position) {
		return getItemViewType(position) != VIEW_TYPE_HEADER;
	}
	
	@Override
	public boolean hasStableIds() {
		return true;
	}
	
	@Override
	public long getItemId(int position) {
		return items.get(position).hashCode();
	}
	
	@Override
	public int getPositionForSection(int arg0) {
		return indexer.getPositionForSection(arg0);
	}

	@Override
	public int getSectionForPosition(int arg0) {
		return indexer.getSectionForPosition(arg0);
	}

	@Override
	public Object[] getSections() {
		return indexer.getSections();
	}
	
	@Override
	public int getItemViewType(int position) {
		return indexer.isSectionStart(position) ? VIEW_TYPE_HEADER : VIEW_TYPE_ITEM;
	}
	
	@Override
	public int getViewTypeCount() {
		return 2;
	}
}