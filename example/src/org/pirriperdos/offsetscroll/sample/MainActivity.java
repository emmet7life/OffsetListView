package org.pirriperdos.offsetscroll.sample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		setContentView(R.layout.activity_main);
		ListView list = (ListView) findViewById(R.id.main_list);
		String[] strs = new String[100];
		for (int i = 0; i < 100; i++) {
			strs[i] = Integer.toString(i);
		}
		list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strs));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
