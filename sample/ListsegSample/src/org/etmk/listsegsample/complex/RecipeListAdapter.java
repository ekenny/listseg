package org.etmk.listsegsample.complex;

import java.util.Comparator;
import java.util.List;

import org.etmk.IndexingValueSelector;
import org.etmk.Partitioner;
import org.etmk.SectionIndexingListAdapter;
import org.etmk.listsegsample.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

public class RecipeListAdapter extends SectionIndexingListAdapter<Recipe, String, Category> {

	private Context context;
	
	public RecipeListAdapter(Context context, List<Recipe> recipes) {
		
		super(recipes, new IndexingValueSelector<Recipe, String, Category>() {

			@Override
			public Category getIndexValue(Recipe r) {
				return r.getCategory();
			}

			@Override
			public String getSectionHeader(Category c) {
				return c.getName();
			}
		}, new Partitioner<Category>(new Category("a"), new Category("z"), new Comparator<Category>() {

			@Override
			public int compare(Category lhs, Category rhs) {
				return lhs.getName().compareToIgnoreCase(rhs.getName());
			}
		}){
			
		});
		this.context = context;
	}

	@Override
	public Filter getFilter() {
		return null;
	}

	@Override
	public View getListItemView(Recipe r, int arg1, View view, ViewGroup arg3) {
		if (view == null) {
			view =  ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.recipe_item, null);
		}
		((TextView)view.findViewById(R.id.name)).setText(r.getName());
		((TextView)view.findViewById(R.id.instructions)).setText(r.getInstructions());
		return view;
	}

	@Override
	public View getSectionHeaderView(String header, int arg1, View view,
			ViewGroup arg3) {
		if (view == null) {
			view =  ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.header, null);
		}
		((TextView)view.findViewById(R.id.headerText)).setText(header);
		return view;
	}

}
