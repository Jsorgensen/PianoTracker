package com.Jsorgensen.PT;
import android.widget.*;
import android.content.*;
import android.view.*;
import android.graphics.*;
import java.util.*;

public class ButtonAdapter extends BaseAdapter
{
	private Context mContext;  
	List<String> fn = new ArrayList<String>();
	String[] fln = new String[]{};

	// Gets the context so it can be used later  
	public ButtonAdapter(Context c) {  
		mContext = c;  
	}  

	// Total number of things contained within the adapter  
	public int getCount() {  
		fn.addAll(Arrays.asList("Mike","Emily","Emma"));
		fln = fn.toArray(fln);
		return fln.length;  
	}  

	// Require for structure, not really used in my code.  
	public Object getItem(int position) {  
		return null;  
	}  

	// Require for structure, not really used in my code. Can  
	// be used to get the id of an item in the adapter for   
	// manual control.   
	public long getItemId(int position) {  
		return position;  
	}  

	public View getView(int position,   
						View convertView, ViewGroup parent) {  
		Button btn;  
		if (convertView == null) {    
			// if it's not recycled, initialize some attributes  
			btn = new Button(mContext);  
			btn.setLayoutParams(new GridView.LayoutParams(100, 55));  
			btn.setPadding(8, 8, 8, 8);  
		}   
		else {  
			btn = (Button) convertView;  
		}  
		btn.setText(fln[position]);   
		// filenames is an array of strings  
		btn.setTextColor(Color.WHITE);  
		//btn.setBackgroundResource(R.drawable.button);  
		btn.setId(position);  

		return btn;  
	}  
}
