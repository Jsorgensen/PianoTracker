package com.Jsorgensen.PT;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.TableRow.*;
import android.view.*;
import android.graphics.*;
import android.view.View;
import android.content.*;
import android.graphics.drawable.*;

public class MainActivity extends Activity implements OnClickListener
{

	int id=1000;
	GridLayout gl;
	LinearLayout ll0, ll1, ll1b, ll2, ll2b;
	ImageButton ib1, ib2;
	Button bt1, bt2;
	TextView tv1;
	Intent i, e;
	int BROWN;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		BROWN = Color.rgb(120, 69, 19);
		
		Display dsp = getWindowManager().getDefaultDisplay();
		Point dpt = new Point();
		dsp.getSize(dpt);
		int w = dpt.x, h = dpt.y;
		int wa=w, ha=h;
		if(w>h){
			wa = h;
			ha = w;
			w = h;
		}
		int cw = w*8/10;
		int cc = dpt.x/cw;

		ll0 = new LinearLayout(this);
		ll0.setId(id); id++;
		LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		ll0.setLayoutParams(lp);
		ll0.setOrientation(LinearLayout.VERTICAL);
		ll0.setGravity(Gravity.CENTER);
		ll0.setBackgroundColor(Color.BLACK);
		//ll0.setPadding(w*5/100, h*5/100, 20, w*5/100);
		
		gl = new GridLayout(this);
		gl.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		gl.setLayoutParams(lp);
		//gl.setBackgroundColor(Color.BLACK);
		gl.setColumnCount(cc);
		ll0.addView(gl);
		
		int w1 = ha*15/1000;
		ll1 = new LinearLayout(this);
		ll1.setId(id); id++;
		lp = new LayoutParams(cw, LayoutParams.WRAP_CONTENT);
		ll1.setLayoutParams(lp);
		ll1.setOrientation(LinearLayout.VERTICAL);
		ll1.setGravity(Gravity.CENTER_HORIZONTAL);
		ll1.setBackgroundColor(Color.WHITE);
		ll1.setPadding(w1, w1, w1, w1);
		gl.addView(ll1);

		int w2 = ha*18/1000, w3 = ha*4/100;
		ll1b = new LinearLayout(this);
		ll1b.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		ll1b.setLayoutParams(lp);
		ll1b.setOrientation(LinearLayout.VERTICAL);
		ll1b.setGravity(Gravity.CENTER_HORIZONTAL);
		ll1b.setBackgroundColor(BROWN);
		ll1b.setPadding(w3, w2, w3, w2);
		ll1.addView(ll1b);

		ll2 = new LinearLayout(this);
		ll2.setId(id); id++;
		lp = new LayoutParams(cw, LayoutParams.WRAP_CONTENT);
		ll2.setLayoutParams(lp);
		ll2.setOrientation(LinearLayout.VERTICAL);
		ll2.setGravity(Gravity.CENTER_HORIZONTAL);
		ll2.setBackgroundColor(Color.WHITE);
		ll2.setPadding(w1, w1, w1, w1);
		gl.addView(ll2);

		ll2b = new LinearLayout(this);
		ll2b.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		ll2b.setLayoutParams(lp);
		ll2b.setOrientation(LinearLayout.VERTICAL);
		ll2b.setGravity(Gravity.CENTER_HORIZONTAL);
		ll2b.setBackgroundColor(BROWN);
		ll2b.setPadding(w3, w2, w3, w2);
		ll2.addView(ll2b);
		
		int w4 = ha*28/100;
		ib1 = new ImageButton(this);
		ib1.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		ib1.setLayoutParams(lp);
		ib1.setOnClickListener(this);
		int ir1 = getResources().getIdentifier("@drawable/burtbucks", null, getPackageName());
		Drawable res1 = getResources().getDrawable(ir1);
		Bitmap bm1 = ((BitmapDrawable) res1).getBitmap();
		Drawable res1b = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bm1, w4, w4, true));
		ib1.setBackgroundDrawable(res1b);
		ll1b.addView(ib1);
		
		ib2 = new ImageButton(this);
		ib2.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		ib2.setLayoutParams(lp);
		ib2.setOnClickListener(this);
		int ir2 = getResources().getIdentifier("@drawable/receipts", null, getPackageName());
		Drawable res2 = getResources().getDrawable(ir2);
		Bitmap bm2 = ((BitmapDrawable) res2).getBitmap();
		Drawable res2b = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bm2, w4, w4, true));
		ib2.setBackgroundDrawable(res2b);
		ll2b.addView(ib2);

		bt1 = new Button(this);
		bt1.setId(id); id++;
		lp = new LayoutParams(w4, LayoutParams.WRAP_CONTENT);
		bt1.setLayoutParams(lp);
		bt1.setPadding(10, -10, 10, -10);
		bt1.setText("Income");
		bt1.setTextSize(32);
		bt1.setTextColor(Color.GREEN);
		bt1.setBackgroundColor(Color.BLUE);
		bt1.setOnClickListener(this);
		ll1b.addView(bt1);

		bt2 = new  Button(this);
		bt2.setId(id); id++;
		lp = new LayoutParams(w4, LayoutParams.WRAP_CONTENT);
		bt2.setLayoutParams(lp);
		bt2.setPadding(10, -10, 10, -10);
		bt2.setText("Expenses");
		bt2.setTextSize(32);
		bt2.setTextColor(Color.RED);
		bt2.setBackgroundColor(Color.BLUE);
		bt2.setOnClickListener(this);
		ll2b.addView(bt2);
		
		setContentView(ll0);
		
		i = new Intent(this, Income.class);
		e = new Intent(this, Expenses.class);
    }

	@Override
	public void onClick(View v)
	{
		if(v==ib1||v==bt1){
			startActivity(i);
		}
		if(v==ib2||v==bt2){
			startActivity(e);
		}
	}
}
