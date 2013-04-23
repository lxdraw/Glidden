package com.example.glidden;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * This is the Main activity for the Glidden how-to app. 
 * @author alexdrawbond
 *
 */
public class MainActivity extends Activity {
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	private static final String TAG="MainActivity";
	private Spinner spinner;
	
	//array for title of each project
		protected String[] PROJECT_NAMES = new String[] {"Traditional", "Modern", "Eclectic", "Cottage"};
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Log.e(TAG, "HERE!!!");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);	
		spinner = (Spinner) findViewById(R.id.spinner);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.categories_array, android.R.layout.simple_spinner_item);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
        /** Enabling dropdown list navigation for the action bar */
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        
        getActionBar().setDisplayShowTitleEnabled(false);
		
        //declare buttons
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		
		
		//go to Tradition class when traditional is clicked
		button1.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//Log.e(TAG, "button pressed");
				
				Intent intent = new Intent(v.getContext(), Traditional.class);
				startActivity(intent);
			}
		});
		
		//go to Modern class when modern is clicked
		button2.setOnClickListener(new OnClickListener()
		{
					@Override
					public void onClick(View v)
					{
						//Log.e(TAG, "button pressed");
						
						Intent intent = new Intent(v.getContext(), Modern.class);
						startActivity(intent);
					}
				});
				
		//go to Cottage class when cottage is clicked
		button3.setOnClickListener(new OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						//Log.e(TAG, "button pressed");
						
						Intent intent = new Intent(v.getContext(), Eclectic.class);
						startActivity(intent);
					}
				});
				
				//go to Eclectic class when eclectic is clicked
				button4.setOnClickListener(new OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						//Log.e(TAG, "button pressed");
						
						Intent intent = new Intent(v.getContext(), Cottage.class);
						startActivity(intent);
					}
				});

        /*ArrayList<ItemDetails> image_details = GetSearchResults();
        
        final ListView lv1 = (ListView) findViewById(R.id.listV_main);
        lv1.setAdapter(new ItemListBaseAdapter(this, image_details));
        
      //sets the click listener to the adapter and not a button
      	lv1.setOnItemClickListener(new OnItemClickListener() {

      			@Override
      			public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
      				// TODO Auto-generated method stub
      				String openClass = PROJECT_NAMES[position];
      				try{
      					Class selected = Class.forName("com.example.glidden." + openClass);
      					Intent intent = new Intent(v.getContext(), selected);
      					startActivity(intent);
      				}catch (ClassNotFoundException e){
      					e.printStackTrace();
      				}
      			}
      		});
      	}
    
    private ArrayList<ItemDetails> GetSearchResults(){
    	ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();
    	
    	ItemDetails item_details = new ItemDetails();
    	item_details.setName("Traditional");
    	item_details.setImageNumber(1);
    	results.add(item_details);
    	
    	item_details = new ItemDetails();
    	item_details.setName("Modern");
    	item_details.setImageNumber(2);
    	results.add(item_details);
    	
    	item_details = new ItemDetails();
    	item_details.setName("Eclectic");
    	item_details.setImageNumber(3);
    	results.add(item_details);
    	
    	item_details = new ItemDetails();
    	item_details.setName("Cottage");
    	item_details.setImageNumber(4);
    	results.add(item_details);
    	
    	return results;
    }*/
    	
		/** Defining Navigation listener */
        ActionBar.OnNavigationListener navigationListener = new OnNavigationListener()
        {
            @Override
            public boolean onNavigationItemSelected(int itemPosition, long itemId) {
                Toast.makeText(getBaseContext(), "You selected : " , Toast.LENGTH_SHORT).show();
                return false;
            }
        };
        
        /** Setting dropdown items and item navigation listener for the actionbar */
       getActionBar().setListNavigationCallbacks(adapter, navigationListener);
	}
}
