package org.etmk.listsegsample;

import java.util.List;

import org.etmk.AlphaIndexingValueSelector;
import org.etmk.AlphaSectionIndexingListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(new PersonAdapter(new PersonRepository().getPeople()));
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private class PersonAdapter extends AlphaSectionIndexingListAdapter<Person>
    {

		public PersonAdapter(List<Person> objects) {
			super(objects, new AlphaIndexingValueSelector<Person>() {

				@Override
				public Character getIndexValue(Person person) {
					return person.getLastName().charAt(0);  // grouping and indexing by last name
				}
			});
		}

		@Override
		public Filter getFilter() {
			return null;
		}

		@Override
		public View getListItemView(Person person, int arg1, View view,
				ViewGroup arg3) {
			if (view == null) {
				
				view =  getLayoutInflater().inflate(R.layout.recipe_item, null);
			}
			((TextView)view.findViewById(R.id.name)).setText(person.getLastName());
			((TextView)view.findViewById(R.id.instructions)).setText(person.getFirstName());
			return view;
		}

		@Override
		public View getSectionHeaderView(String headerValue, int arg1, View view,
				ViewGroup arg3) {
			if (view == null) {
				
				view =  getLayoutInflater().inflate(R.layout.header, null);
			}
			((TextView)view.findViewById(R.id.headerText)).setText(headerValue);
			return view;	
		}
    	
    }
}
