package org.etmk.listsegsample.complex;

import org.etmk.listsegsample.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class RecipeActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe);

		ListView listView = (ListView) findViewById(R.id.listView1);

		listView.setAdapter(new RecipeListAdapter(this, new RecipeRepository()
				.getRecipes()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_recipe, menu);
		return true;
	}
}
