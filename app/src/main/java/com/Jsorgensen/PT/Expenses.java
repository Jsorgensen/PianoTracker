package com.Jsorgensen.PT;
import android.app.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.widget.TableRow.*;
import java.util.*;

import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.TableRow.LayoutParams;
import java.io.*;
import android.content.*;
import android.widget.GridLayout.*;
import java.lang.reflect.*;
import org.w3c.dom.*;
import android.media.*;
import android.text.*;
import android.text.method.*;

public class Expenses extends Activity implements OnClickListener, OnFocusChangeListener
{
	int id=2000, clmn, w, h;
	int nm, tm, da, rt, tl, du, pd, tt, nt;
	ScrollView svv, svs;
	HorizontalScrollView svh;
	LinearLayout ll0, ll1, ll1a, ll1b, ll2;
	LayoutParams lp;
	GridLayout gls;
	EditText et0, et1, et2, et3, et4;
	TextView tv0, tv1, t1, t2, t3;
	ImageButton entr, sav, clr, bck, delin;
	GridLayout gl, gla, glb;
	String filename, nme, nmh, slh;
	Boolean focus, nclr;
	int BROWN, number0;
	List<Integer> dtr = new ArrayList<Integer>();
	List<String> dt = new ArrayList<String>();
	List<String> dth = new ArrayList<String>();
	List<TextView> tv = new ArrayList<TextView>();
	List<TextView> tve = new ArrayList<TextView>();
	List<TextView> tvt = new ArrayList<TextView>();
	List<TextView> div = new ArrayList<TextView>();
	List<EditText> et = new ArrayList<EditText>();
	List<EditText> eti = new ArrayList<EditText>();
	List<EditText> etcal = new ArrayList<EditText>();
	List<Button> slct = new ArrayList<Button>();
	List<GridLayout.Spec> rw = new ArrayList<GridLayout.Spec>();
	List<GridLayout.Spec> cl = new ArrayList<GridLayout.Spec>();
	List<GridLayout.LayoutParams> glp = new ArrayList<GridLayout.LayoutParams>();
	List<GradientDrawable> gd = new ArrayList<GradientDrawable>();
	List<String> inp = new ArrayList<String>();
	List<String> inpa = new ArrayList<String>();
	List<String> inpb = new ArrayList<String>();
	List<Integer> inpbrf = new ArrayList<Integer>();
	List<String> namef = new ArrayList<String>();
	List<LinearLayout> ll = new ArrayList<LinearLayout>();
	List<View> cv = new ArrayList<View>();

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		BROWN = Color.rgb(120, 69, 19);
		number0 = InputType.TYPE_CLASS_NUMBER;

		dt.addAll(Arrays.asList("NAME", "DESCRIPTION", "DUE", "DATE", "COST", "TOTAL", "PAID", "NOTES"));
		clmn = dt.size();
		nm = dt.indexOf("NAME");
		tm = dt.indexOf("DESCRIPTION");
		da = dt.indexOf("DATE");
		rt = dt.indexOf("COST");
		//tl = dt.indexOf("TRVL");
		tt = dt.indexOf("TOTAL");
		pd = dt.indexOf("PAID");
		du = dt.indexOf("DUE");
		nt = dt.indexOf("NOTES");

		String[] dtg = new String[dt.size()];
		dt.toArray(dtg);
		//dtg[tm] = "/min";
		dtg[da] = "m/d/yr";
		dtg[rt] = "$";
		//dtg[tl] = "/mile";
		dtg[pd] = "$";
		dth = Arrays.asList(dtg);

		nme = "Expenses";
		filename = nme + ".txt";
		focus = false;
		nmh = "";
		slh = "";

		Display dsp = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		dsp.getSize(size);
		w = size.x;
		h = size.y;
		if(w>h){w = h;}
		int cc = size.x/(w/2);

		int irl = getResources().getIdentifier("@drawable/sheetmusicj", null, getPackageName());
		Drawable resl = getResources().getDrawable(irl);
		int drx = resl.getIntrinsicWidth()
			, dry = resl.getIntrinsicHeight();
		if(drx>w){
			dry = dry*w/drx;
			drx = w;
		}
		if(dry>h){
			drx = drx*h/dry;
			dry = h;
		}
		Bitmap bml = ((BitmapDrawable) resl).getBitmap();
		BitmapDrawable bdl = new BitmapDrawable(bml);
		bdl.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

		svv = new ScrollView(this);
		svv.setId(id); id++;
		lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		svv.setLayoutParams(lp);
		svv.setBackgroundDrawable(bdl);

		svh = new HorizontalScrollView(this);
		svh.setId(id); id++;
		lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		svh.setLayoutParams(lp);
		svv.addView(svh);

		ll0 = new LinearLayout(this);
		ll0.setId(id); id++;
		lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		ll0.setGravity(Gravity.FILL);
		ll0.setLayoutParams(lp);
		ll0.setOrientation(LinearLayout.VERTICAL);
		ll0.setPadding(15, 15, 15, 15);
		svh.addView(ll0);

		ll1 = new LinearLayout(this);
		ll1.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		ll1.setLayoutParams(lp);
		//ll1.setPadding(15, 15, 15, 15);
		ll1.setOrientation(LinearLayout.HORIZONTAL);
		ll1.setGravity(Gravity.CENTER_VERTICAL);
		ll1.setBackgroundColor(Color.TRANSPARENT);
		ll0.addView(ll1);

		ll1a = new LinearLayout(this);
		ll1a.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		ll1a.setLayoutParams(lp);
		//ll1a.setPadding(15, 15, 15, 15);
		ll1a.setOrientation(LinearLayout.HORIZONTAL);
		ll1a.setGravity(Gravity.CENTER_VERTICAL);
		ll1a.setBackgroundColor(Color.TRANSPARENT);
		ll0.addView(ll1a);

		ll1b = new LinearLayout(this);
		ll1b.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		ll1b.setLayoutParams(lp);
		//ll1b.setPadding(15, 15, 15, 15);
		ll1b.setOrientation(LinearLayout.HORIZONTAL);
		ll1b.setGravity(Gravity.CENTER_VERTICAL);
		ll1b.setBackgroundColor(Color.TRANSPARENT);
		ll0.addView(ll1b);

		for(int i=0; i<4; i++){
			ll.add(new LinearLayout(this));
			ll.get(ll.size()-1).setId(id); id++;
			lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			ll.get(ll.size()-1).setLayoutParams(lp);
			ll.get(ll.size()-1).setPadding(20, 20, 20, 20);
			ll.get(ll.size()-1).setGravity(Gravity.CENTER);
			ll.get(ll.size()-1).setOrientation(LinearLayout.HORIZONTAL);
			//ll2.addView(ll.get(ll.size()-1));
		}
		int sqr = 200;
		ll1b.addView(ll.get(ll.size()-4));
		ll1b.addView(ll.get(ll.size()-3));
		ll1b.addView(ll.get(ll.size()-2));
		ll1b.addView(ll.get(ll.size()-1));

		bck = new ImageButton(this);
		bck.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		bck.setLayoutParams(lp);
		//bck.setPadding(30, 0, 30, 0);
		int ir4 = getResources().getIdentifier("@drawable/backj", null, getPackageName());
		Drawable res4 = getResources().getDrawable(ir4);
		Bitmap bm4 = ((BitmapDrawable) res4).getBitmap();
		Drawable res4b = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bm4, sqr, sqr, true));
		bck.setBackgroundDrawable(res4b);
		bck.setOnClickListener(this);
		ll.get(ll.size()-4).addView(bck);

		clr = new ImageButton(this);
		clr.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		clr.setLayoutParams(lp);
		//clr.setPadding(30, 0, 30, 0);
		int ir3 = getResources().getIdentifier("@drawable/cleari", null, getPackageName());
		Drawable res3 = getResources().getDrawable(ir3);
		Bitmap bm3 = ((BitmapDrawable) res3).getBitmap();
		Drawable res3b = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bm3, sqr, sqr, true));
		clr.setBackgroundDrawable(res3b);
		clr.setOnClickListener(this);
		ll.get(ll.size()-3).addView(clr);

		sav = new ImageButton(this);
		sav.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		sav.setLayoutParams(lp);
		//sav.setPadding(30, 0, 30, 0);
		int ir2 = getResources().getIdentifier("@drawable/savei", null, getPackageName());
		Drawable res2 = getResources().getDrawable(ir2);
		Bitmap bm2 = ((BitmapDrawable) res2).getBitmap();
		Drawable res2b = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bm2, sqr, sqr, true));
		sav.setBackgroundDrawable(res2b);
		sav.setOnClickListener(this);
		ll.get(ll.size()-2).addView(sav);

		entr = new ImageButton(this);
		entr.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		entr.setLayoutParams(lp);
		//entr.setPadding(30, 0, 30, 0);
		int ir1 = getResources().getIdentifier("@drawable/enteri", null, getPackageName());
		Drawable res1 = getResources().getDrawable(ir1);
		Bitmap bm1 = ((BitmapDrawable) res1).getBitmap();
		Drawable res1b = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bm1, sqr, sqr, true));
		entr.setBackgroundDrawable(res1b);
		entr.setOnClickListener(this);
		ll.get(ll.size()-1).addView(entr);

		LinearLayout lli = ll1;

		for(int i=0; i<clmn; i++){
			if(i>2){lli = ll1a;}
			if(i>7){lli = ll1b;}

			ll.add(new LinearLayout(this));
			ll.get(ll.size()-1).setId(id); id++;
			lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			ll.get(ll.size()-1).setLayoutParams(lp);
			ll.get(ll.size()-1).setPadding(15, 15, 15, 15);
			ll.get(ll.size()-1).setOrientation(LinearLayout.VERTICAL);
			ll.get(ll.size()-1).setGravity(Gravity.CENTER_HORIZONTAL);
			ll.get(ll.size()-1).setBackgroundColor(Color.TRANSPARENT);
			lli.addView(ll.get(ll.size()-1));

			tvt.add(new TextView(this));
			tvt.get(tvt.size()-1).setId(id); id++;
			LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
			tvt.get(tvt.size()-1).setLayoutParams(lp);
			tvt.get(tvt.size()-1).setPadding(15,10,15,10);
			GradientDrawable gd = new GradientDrawable();
			gd.setColor(Color.WHITE);
			gd.setCornerRadius(5);
			gd.setStroke(10, BROWN);
			tvt.get(tvt.size()-1).setBackgroundDrawable(gd);
			tvt.get(tvt.size()-1).setTextSize(25);
			tvt.get(tvt.size()-1).setTextColor(Color.BLACK);
			tvt.get(tvt.size()-1).setText(dt.get(i));
			tvt.get(tvt.size()-1).setGravity(Gravity.CENTER);
			ll.get(ll.size()-1).addView(tvt.get(tvt.size()-1));

			eti.add(new EditText(this));
			eti.get(i).setId(id); id++;
			lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
			eti.get(i).setLayoutParams(lp);
			eti.get(i).setGravity(Gravity.CENTER);
			eti.get(i).setPadding(15, 0, 15, 0);
			GradientDrawable gd0 = new GradientDrawable();
			gd0.setColor(Color.WHITE); // Changes this drawbale to use a single color instead of a gradient
			gd0.setCornerRadius(5);
			gd0.setStroke(10, BROWN);
			eti.get(i).setBackgroundDrawable(gd0);
			eti.get(i).setTextSize(25);
			eti.get(i).setHint(dth.get(i));
			ll.get(ll.size()-1).addView(eti.get(i));
		}
		ViewGroup vg = (ViewGroup) eti.get(tt).getParent();
		ViewGroup vg0 = (ViewGroup) vg.getParent();
		vg0.removeView(vg);
		vg = (ViewGroup) eti.get(du).getParent();
		vg0 = (ViewGroup) vg.getParent();
		vg0.removeView(vg);
		vg = (ViewGroup) eti.get(nt).getParent();
		vg0 = (ViewGroup) vg.getParent();
		vg0.removeView(vg);
		ll1.addView(vg);
		
		eti.get(nm).setOnFocusChangeListener(this);
		//eti.get(da).setInputType(number0);
		//eti.get(tm).setInputType(number0);
		//eti.get(tl).setInputType(number0);
		eti.get(rt).setInputType(number0);
		eti.get(pd).setInputType(number0);

		int etr=0, tvr=0;
		for(int i=0; i<clmn; i++){
			switch(dt.get(i)){

				case("TOTAL"):
				case("DUE"):
					dtr.add(tvr);
					tvr++;
					break;

				default:
					dtr.add(etr);
					etr++;
					break;
			}
		}

		ll.add(new LinearLayout(this));
		ll.get(ll.size()-1).setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		ll.get(ll.size()-1).setLayoutParams(lp);
		ll.get(ll.size()-1).setPadding(15, 15, 15, 15);
		ll.get(ll.size()-1).setOrientation(LinearLayout.VERTICAL);
		ll.get(ll.size()-1).setGravity(Gravity.CENTER_HORIZONTAL);
		ll.get(ll.size()-1).setBackgroundColor(Color.TRANSPARENT);
		ll1a.addView(ll.get(ll.size()-1));

		for(int i=0; i<3; i++){
			tvt.add(new TextView(this));
			tvt.get(tvt.size()-1).setId(id); id++;
			LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			tvt.get(tvt.size()-1).setLayoutParams(lp);
			tvt.get(tvt.size()-1).setPadding(15,10,15,10);
			GradientDrawable gd = new GradientDrawable();
			gd.setColor(Color.WHITE);
			gd.setCornerRadius(5);
			gd.setStroke(10, BROWN);
			tvt.get(tvt.size()-1).setBackgroundDrawable(gd);
			tvt.get(tvt.size()-1).setTextSize(25);
			tvt.get(tvt.size()-1).setTextColor(Color.BLACK);
			tvt.get(tvt.size()-1).setText("");
			tvt.get(tvt.size()-1).setGravity(Gravity.CENTER);
			ll.get(ll.size()-1).addView(tvt.get(tvt.size()-1));
		}
		t1 = tvt.get(tvt.size()-3);
		t1.setText("Total");
		t2 = tvt.get(tvt.size()-2);
		t2.setText("$0.0");
		t3 = tvt.get(tvt.size()-1);
		ll.get(ll.size()-1).removeView(t3);

		ll2 = new LinearLayout(this);
		ll2.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		ll2.setLayoutParams(lp);
		ll2.setPadding(15, 15, 15, 15);
		ll2.setOrientation(LinearLayout.HORIZONTAL);
		ll2.setGravity(Gravity.CENTER_VERTICAL);
		ll2.setBackgroundColor(Color.TRANSPARENT);
		ll0.addView(ll2);

		gl = new GridLayout(this);
		gl.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		gl.setLayoutParams(lp);
		gl.setPadding(30, 30, 30, 30);
		gl.setColumnCount(clmn+1);
		gl.setBackgroundColor(Color.BLACK);
		ll0.addView(gl);
		gla = gl;

		read();
		sumt();

		svs = new ScrollView(this);
		svs.setId(id); id++;
		lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		svs.setLayoutParams(lp);
		int irsel = getResources().getIdentifier("@drawable/sheetmusicj", null, getPackageName());
		Drawable ressel = getResources().getDrawable(irsel);
		int selx = resl.getIntrinsicWidth()
			, sely = resl.getIntrinsicHeight();
		Bitmap bmsel = ((BitmapDrawable) ressel).getBitmap();
		BitmapDrawable bds = new BitmapDrawable(bmsel);
		bds.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
		svs.setBackgroundDrawable(bds);

		namef.clear();
		namef.add("ALL");
		namec(inp);
		gls = new GridLayout(this);
		gls.setId(id); id++;
		lp = new LayoutParams((w/2)*cc, LayoutParams.WRAP_CONTENT);
		gls.setLayoutParams(lp);
		gls.setColumnCount(cc);
		svs.addView(gls);
		int wb = w/2;
		for(int i=0; i<namef.size(); i++){
			//namef.get(i).replaceAll(" ","\n");
			slct.add(new Button(this));
			slct.get(slct.size()-1).setId(id); id++;
			lp = new LayoutParams(wb, wb);
			slct.get(slct.size()-1).setLayoutParams(lp);
			slct.get(slct.size()-1).setText(namef.get(i));
			slct.get(slct.size()-1).setTextSize(35);
			slct.get(slct.size()-1).setTextColor(BROWN);
			GradientDrawable gd = new GradientDrawable();
			gd.setColor(Color.WHITE);
			gd.setCornerRadius(20);
			gd.setGradientRadius(20);
			gd.setStroke(20, Color.BLACK);
			slct.get(slct.size()-1).setBackgroundDrawable(gd);
			slct.get(slct.size()-1).setOnClickListener(this);
			gls.addView(slct.get(slct.size()-1));
		}

		delin = new ImageButton(this);
		delin.setId(id); id++;
		int ird = getResources().getIdentifier("@drawable/deletei", null, getPackageName());
		Drawable resd = getResources().getDrawable(ird);
		Bitmap bmd = ((BitmapDrawable) resd).getBitmap();
		Drawable resdb = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bmd, sqr/2, sqr/2, true));
		delin.setBackgroundDrawable(resdb);
		delin.setOnClickListener(this);

		glb = new GridLayout(this);
		glb.setId(id); id++;
		lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		glb.setLayoutParams(lp);
		glb.setPadding(30, 30, 30, 30);
		glb.setColumnCount(clmn+1);
		glb.setBackgroundColor(Color.BLACK);

		setContentView(svs);
		focus = true;
	}
	//End OnCreate()

	//Generate Layouts
	public void generate(GridLayout glr, List<String> inpg){
		try{
			if(glr.getRowCount()<1){
				for(int i=0; i<clmn; i++){
					tv.add(new TextView(this));
					tv.get(tv.size()-1).setId(id); id++;
					rw.add(GridLayout.spec(0));
					cl.add(GridLayout.spec(i));
					glp.add(new GridLayout.LayoutParams(rw.get(i), cl.get(i)));
					glp.get(glp.size()-1).setGravity(Gravity.FILL);
					tv.get(tv.size()-1).setLayoutParams(glp.get(glp.size()-1));
					tv.get(tv.size()-1).setPadding(25,10,25,10);
					GradientDrawable gd = new GradientDrawable();
					gd.setColor(Color.WHITE);
					gd.setCornerRadius(5);
					gd.setStroke(10, BROWN);
					tv.get(tv.size()-1).setBackgroundDrawable(gd);
					tv.get(tv.size()-1).setTextSize(25);
					tv.get(tv.size()-1).setTextColor(Color.BLACK);
					tv.get(tv.size()-1).setText(dt.get(i));
					tv.get(tv.size()-1).setGravity(Gravity.CENTER);
					glr.addView(tv.get(tv.size()-1), glp.get(glp.size()-1));
				}
			}
			int iref = glr.getRowCount()*clmn;
			int rc = glr.getRowCount();
			for(int i=0; i<inpg.size(); i++){
				int r = i/clmn+rc;
				rw.add(GridLayout.spec(r));
				int c = (i)-(r-rc)*clmn;
				cl.add(GridLayout.spec(c));
				GradientDrawable gd = new GradientDrawable();
				gd.setColor(Color.WHITE); // Changes this drawbale to use a single color instead of a gradient
				gd.setCornerRadius(5);
				gd.setStroke(10, BROWN);
				glp.add(new GridLayout.LayoutParams(rw.get(rw.size()-1), cl.get(cl.size()-1)));
				glp.get(glp.size()-1).setGravity(Gravity.FILL);

				switch(dt.get(c)){

					case("TOTAL"):
					case("DUE"):
						tve.add(new TextView(this));
						tve.get(tve.size()-1).setId(id); id++;
						tve.get(tve.size()-1).setLayoutParams(glp.get(glp.size()-1));
						tve.get(tve.size()-1).setPadding(25,10,25,10);
						tve.get(tve.size()-1).setBackgroundDrawable(gd);
						tve.get(tve.size()-1).setGravity(Gravity.CENTER);
						tve.get(tve.size()-1).setTextSize(20);
						tve.get(tve.size()-1).setTextColor(Color.BLACK);
						tve.get(tve.size()-1).setText(inpg.get(i));
						cv.add(tve.get(tve.size()-1));
						cv.get(cv.size()-1).setTag(i+iref);
						glr.addView(tve.get(tve.size()-1), glp.get(glp.size()-1));
						break;

					default:
						et.add(new EditText(this));
						et.get(et.size()-1).setId(id); id++;
						et.get(et.size()-1).setLayoutParams(glp.get(glp.size()-1));
						et.get(et.size()-1).setPadding(25,10,25,10);
						et.get(et.size()-1).setBackgroundDrawable(gd);
						et.get(et.size()-1).setGravity(Gravity.CENTER);
						et.get(et.size()-1).setTextSize(20);
						et.get(et.size()-1).setHint(dth.get(c));
						et.get(et.size()-1).setText(inpg.get(i));
						et.get(et.size()-1).setOnFocusChangeListener(this);
						et.get(et.size()-1).setTag(i+iref);
						cv.add(et.get(et.size()-1));
						glr.addView(et.get(et.size()-1), glp.get(glp.size()-1));
						break;
				}
				switch(dt.get(c)){

						//case("DATE"):
					case("COST"):
					//case("RATE"):
					//case("TRVL"):
					case("PAID"):
						et.get(et.size()-1).setInputType(number0);
						break;

					case("DUE"):
						try{
							Double grn = Double.valueOf(tve.get(tve.size()-1).getText().toString().substring(1, tve.get(tve.size()-1).length()));
							if(grn>0){tve.get(tve.size()-1).setTextColor(Color.RED);}
							if(grn<=0){tve.get(tve.size()-1).setTextColor(Color.GREEN);}
						}
						catch(Exception e){

						}
						break;
				}
			}
		}
		catch(Exception e){
			Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onClick(View v)
	{
		focus = false;
		String sel = "";
		if(v==entr){sel = "e";}
		if(v==sav){sel = "s";}
		if(v==clr){sel = "c";}
		if(v==bck){sel = "b";}
		if(slct.indexOf(v)>-1){sel = "slct";}
		if(v==delin){sel = "del";}
		switch(sel){

			case("e"):
				if(eti.get(da).getText().toString().equals("")){
					Calendar c = Calendar.getInstance();
					int dy, mn, yr;
					dy = c.get(Calendar.DAY_OF_MONTH);
					mn = c.get(Calendar.MONTH)+1;
					yr = c.get(Calendar.YEAR);
					eti.get(da).setText(mn+"/"+dy+"/"+yr);
				}

				calc(eti);

				int r = gl.getRowCount();
				inpa.clear();
				for(int i=0; i<eti.size(); i++){
					inpa.add(eti.get(i).getText().toString());
				}
				inp.addAll(inpa);
				inpb.addAll(inpa);
				for(int i=0; i<inpa.size(); i++){
					inpbrf.add(inpbrf.size());
				}
				generate(gla, inpa);
				eti.get(da).setText("");
				eti.get(pd).setText("");
				eti.get(nt).setText("");

				sumt();
				break;

			case("s"):
				save();
				Toast.makeText(getBaseContext(), "File Saved", Toast.LENGTH_LONG).show();
				break;

			case("c"):
				clear();
				break;

			case("b"):
				namef.clear();
				namef.add("ALL");
				namec(inp);

				for(int i=gl.getChildCount()-1; i>clmn-1; i--){
					View rmv = gl.getChildAt(i);
					gl.removeView(rmv);
					if(rmv instanceof EditText){
						et.remove(rmv);
					}
					if(rmv instanceof TextView){
						tve.remove(rmv);
					}
				}

				for(int i=glb.getChildCount()-1; i>clmn-1; i--){
					View rmv = glb.getChildAt(i);
					glb.removeView(rmv);
					if(rmv instanceof EditText){
						et.remove(rmv);
					}
					if(rmv instanceof TextView){
						tve.remove(rmv);
					}
				}

				ViewGroup prnt = (ViewGroup) slct.get(0).getParent();
				prnt.removeAllViews();
				slct.clear();
				int wb = w/2;
				for(int i=0; i<namef.size(); i++){
					//namef.get(i).replaceAll(" ","\n");
					slct.add(new Button(this));
					slct.get(slct.size()-1).setId(id); id++;
					lp = new LayoutParams(wb, wb);
					slct.get(slct.size()-1).setLayoutParams(lp);
					slct.get(slct.size()-1).setText(namef.get(i));
					slct.get(slct.size()-1).setTextSize(35);
					slct.get(slct.size()-1).setTextColor(BROWN);
					GradientDrawable gd = new GradientDrawable();
					gd.setColor(Color.WHITE);
					gd.setCornerRadius(20);
					gd.setGradientRadius(20);
					gd.setStroke(20, Color.BLACK);
					slct.get(slct.size()-1).setBackgroundDrawable(gd);
					slct.get(slct.size()-1).setOnClickListener(this);
					gls.addView(slct.get(slct.size()-1));
				}
				setContentView(svs);

				ViewGroup parnt = (ViewGroup) eti.get(nm).getParent();
				if(parnt==null){
					parnt = (ViewGroup) tvt.get(nm).getParent();
					parnt.addView(eti.get(nm));
				}
				parnt = (ViewGroup) t3.getParent();
				if(!(parnt==null)){
					parnt.removeView(t3);
				}
				break;

			case("slct"):
				Button sele = (Button) v;
				String snm = sele.getText().toString();
				nmh = snm;
				slh = snm;
				if(!snm.equals("ALL")){
					int rc = inp.size()/clmn;
					int cc = 0;
					inpb.clear();
					inpbrf.clear();
					for(int i=0; i<inp.size(); i++){
						if(inp.get(i).equals(snm)){
							inpb.addAll(inp.subList(i, i+clmn));
							for(int j=i; j<i+clmn; j++){
								inpbrf.add(j);
							}
							i += clmn-1;
						}
						else{
							i += clmn-1;
						}
					}
					generate(glb, inpb);
					int srf = inpb.size()-clmn;
					for(int i=0; i<clmn; i++){
						eti.get(i).setText(inpb.get(i+srf));
					}
					calc(eti);
					sumt();
					ll0.removeView(gla);
					gla = new GridLayout(this);
					gla = glb;
					ll0.addView(gla);
					eti.get(nm).setText(snm);
					ViewGroup prent = (ViewGroup) eti.get(nm).getParent();
					prent.removeView(eti.get(nm));
					prent = (ViewGroup) t3.getParent();
					if(!(prent==null)){
						prent.removeView(t3);
					}
					prent = (ViewGroup) tvt.get(nm).getParent();
					prent.addView(t3);
					t3.setText(snm);
				}
				else{
					inpb = new ArrayList<String>(inp);
					ll0.removeView(gla);
					gla = new GridLayout(this);
					gla = gl;
					ViewGroup pck = (ViewGroup) gla.getParent();
					if(!(pck==null)){
						pck.removeView(gla);
					}
					ll0.addView(gla);
					generate(gl, inp);
					ViewGroup prent = (ViewGroup) eti.get(nm).getParent();
					if(prent==null){
						prent = (ViewGroup) tvt.get(nm).getParent();
						prent.addView(eti.get(nm));
					}
				}
				setContentView(svv);
				break;

			case("del"):
				int ref, trf;
				switch(slh){

					case("ALL"):
						ref = delin.getTag();
						trf = ref;
						gla = gl;
						break;

					default:
						trf = delin.getTag();
						ref = inpbrf.get(trf);
						gla = glb;
						break;
				}
				gla.removeView(delin);
				for(int i=0; i<clmn; i++){
					View chld = gla.getChildAt(trf+clmn-i);
					if(chld instanceof EditText){
						EditText eclr = (EditText) chld;
						et.remove(eclr);
					}
					if(chld instanceof TextView){
						TextView tclr = (TextView) chld;
						tve.remove(tclr);
					}
					gla.removeView(chld);
					inp.remove(ref-i);
					if(!slh.equals("ALL")){
						inpb.remove(trf-i);
						inpbrf.remove(trf-i);
					}
				}
				for(int i=trf-clmn+1; i<gla.getChildCount(); i++){
					int rd = i/clmn;
					int cd = i - rd*clmn;
					View chld = gla.getChildAt(i);
					glp.add(new GridLayout.LayoutParams(
								GridLayout.spec(rd), GridLayout.spec(cd)));
					glp.get(glp.size()-1).setGravity(Gravity.FILL);
					chld.setLayoutParams(glp.get(glp.size()-1));
				}
				break;
		}
		focus = true;
	}

	@Override
	public void onFocusChange(View v, boolean p2)
	{
		int i = -1;
		EditText fc = (EditText) v;
		if(v instanceof EditText){
			i = et.indexOf(fc);
		}
		if(focus&&i>-1){
			//inpb = new ArrayList<String>(inpb);
			//inpb.clear();
			//inpbrf.clear();
			int cref, trf;
			ViewGroup dpar = (ViewGroup) delin.getParent();
			if(!(dpar==null)){
				dpar.removeView(delin);
			}
			if(slh.equals("ALL")){
				gla = gl;
				inpa = inp;
				cref = gl.indexOfChild(v)-clmn;
				trf = cref;
			}
			else{
				gla = glb;
				inpa = inpb;
				trf = glb.indexOfChild(v)-clmn;
				cref = inpbrf.get(trf);
			}
			int ji=0, je=0;
			int rc = gla.getRowCount(), cc = gla.getColumnCount()-1;
			rc = gla.getRowCount()-1;
			cc = gla.getColumnCount()-1;
			int r = trf/cc;
			int c = trf-r*cc;
			if(c==nm&&!slh.equals("ALL")&&!fc.getText().toString().equals(inpa.get(trf))){
				fc.setText(inpa.get(trf));
			}
			inp.set(cref, fc.getText().toString());
			inpa.set(trf, fc.getText().toString());

			cref = cref-c;
			trf = trf-c;
			je = r*(dt.size()-2);
			ji = r*2;
			for(int j=0; j<clmn; j++){
				switch(dt.get(j)){

					case("TOTAL"):
					case("DUE"):
						eti.get(j).setText(inpa.get(trf+j));
						ji++;
						break;

					default:
						eti.get(j).setText(inpa.get(trf+j));
						je++;
						break;
				}
			}
			nmh = eti.get(nm).getText().toString();
			calc(eti);
			je = r*(et.size()/rc);
			je = et.indexOf(fc)/(et.size()/(gl.getRowCount()+glb.getRowCount()));
			je = i/(clmn-2);
			je *= (clmn-2);
			ji = r*(tve.size()/rc);
			ji = et.indexOf(fc)/(et.size()/(gl.getRowCount()+glb.getRowCount()));
			ji = i/(clmn-2);
			ji*= 2;
			for(int j=0; j<clmn; j++){

				switch(dt.get(j)){

					case("DUE"):
						Double rg = Double.valueOf(eti.get(j).getText().toString().substring(1, eti.get(j).getText().toString().length()));
						if(rg>0.){tve.get(ji).setTextColor(Color.RED);}
						if(rg<=0.){tve.get(ji).setTextColor(Color.GREEN);}
					case("TOTAL"):
						tve.get(ji).setText(eti.get(j).getText().toString());
						inpa.set(trf+j, eti.get(j).getText().toString());
						inp.set(cref+j, eti.get(j).getText().toString());
						ji++;
						break;

					default:
						et.get(je).setText(eti.get(j).getText().toString());
						inpa.set(trf+j, eti.get(j).getText().toString());
						inp.set(cref+j, eti.get(j).getText().toString());
						je++;
						break;
				}
			}

			eti.get(da).setText("");
			eti.get(pd).setText("");
			eti.get(nt).setText("");

			sumt();

			rw.add(GridLayout.spec(r+1));
			cl.add(GridLayout.spec(clmn));
			GridLayout.LayoutParams lpd = new GridLayout.LayoutParams(
				rw.get(rw.size()-1), cl.get(cl.size()-1));
			delin.setLayoutParams(lpd);
			gla.addView(delin);
			delin.setTag((r+1)*clmn-1);

			inpa = new ArrayList<String>(inpa);
		}
		if(focus&&v==eti.get(nm)){
			if(et.size()>0){sumt();}
			if(eti.get(nm).getText().toString().equals(nmh)){
				eti.get(nm).setText("");
			}
			else{
				nmh = eti.get(nm).getText().toString();
			}
		}
		else{

		}
	}
	//EndOnFocusChange

	public void calc(List<EditText> etc){
		String cur = etc.get(rt).getText().toString();
		if(cur.equals("")){
			cur="$0";
			etc.get(rt).setText(cur);
		}
		cur = cur.substring(0, 1);
		if(!cur.equals("$")){
			etc.get(rt).setText("$"+etc.get(rt).getText().toString());
		}
		cur = etc.get(pd).getText().toString();
		if(cur.equals("")){
			cur="$0";
			etc.get(pd).setText(cur);
		}
		cur = cur.substring(0, 1);
		if(!cur.equals("$")){
			etc.get(pd).setText("$"+etc.get(pd).getText().toString());
		}
		cur = etc.get(tm).getText().toString();
		if(cur.equals("")){
			cur="0";
			etc.get(tm).setText(cur);
		}
		cur = etc.get(tl).getText().toString();
		if(cur.equals("")){
			cur="0";
			etc.get(tl).setText(cur);
		}
		try{
			Double dtm, drt, dtl, dpd, ddu, tot;
			//dtm = Double.valueOf(etc.get(tm).getText().toString());
			drt = Double.valueOf(etc.get(rt).getText().toString().substring(1, etc.get(rt).getText().toString().length()));
			//dtl = Double.valueOf(etc.get(tl).getText().toString());
			dpd = Double.valueOf(etc.get(pd).getText().toString().substring(1, etc.get(pd).getText().toString().length()));

			tot = drt;
			String con = Double.toString(tot);
			int se = con.indexOf(".")+3;
			if(se>con.length()-1){se = con.length();}
			con = "$"+con.substring(0, se);
			etc.get(tt).setText(con);

			ddu = tot - dpd;
			con = Double.toString(ddu);
			se = con.indexOf(".")+3;
			if(se>con.length()-1){se = con.length();}
			con = "$"+con.substring(0, se);
			etc.get(du).setText(con);
		}
		catch(Exception e){

		}
	}

	public void namec(List<String> inpn){
		int rc = inp.size()/clmn;

		List<String> namei = new ArrayList<String>();
		for(int i=0; i<rc; i++){
			int ei = nm + i*clmn;
			namei.add(inpn.get(ei));
			int ni = namef.indexOf(namei.get(i));
			if(ni<0&&!namei.get(i).equals("")){
				namef.add(namei.get(i));
			}
		}
	}

	public void sumt(){
		namec(inp);

		String namer = eti.get(nm).getText().toString();
		int rc = (inp.size()-1)/clmn, cc = gl.getColumnCount()-1;
		List<Double> toti = new ArrayList< Double>();
		Double totf=0.;
		for(int i=0; i<rc; i++){
			if(namer.equals(inp.get(nm+i*clmn))&&!namer.equals("")){
				toti.add(Double.valueOf(inp.get(du+i*clmn).substring(1, inp.get(du+i*clmn).length())));
				totf += toti.get(toti.size()-1);
			}
		}
		t2.setText("$"+Double.toString(totf));
		if(totf>0){t2.setTextColor(Color.RED);}
		if(totf<=0){t2.setTextColor(Color.GREEN);}
	}

	//@Override
	public void save(){
		int ji=0, je=0;
		int rc = gl.getRowCount(), cc = gl.getColumnCount()-1;
		try{
			FileOutputStream fos = openFileOutput(filename, MODE_WORLD_WRITEABLE);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			osw.write(inp.toString());
			osw.close();
			//Toast.makeText(getBaseContext(), "File Saved", Toast.LENGTH_LONG).show();
		}catch(Exception e){
			Toast.makeText(getBaseContext(), "Save Error", Toast.LENGTH_LONG).show();
		}
	}

	//@Override
	public void read(){
		try{
			FileInputStream fis = openFileInput(filename);
			InputStreamReader isr = new InputStreamReader(fis);

			int READ_BLOCK_SIZE = 1000;
			char[] inputBuffer= new char[READ_BLOCK_SIZE];
			String s="";
			int charRead;

			while ((charRead=isr.read(inputBuffer))>0) {
				// char to string conversion
				String readstring=String.copyValueOf(inputBuffer,0,charRead);
				s +=readstring;					
			}
			isr.close();
			s = s.replaceAll("[\\[\\]]", "");
			s = s.replaceAll(", ", ",");
			String[] sa = s.split("[,]");
			inp.clear();
			inpb.clear();
			inpbrf.clear();
			inp.addAll(Arrays.asList(sa));
			if(inp.size()<dt.size()+1){
				inp.clear();
			}
			inpb = new ArrayList<String>(inp);
			for(int i=0; i<inp.size(); i++){
				inpbrf.add(i);
			}
			/*for(int ir=0; ir<inp.size(); ir++){
			 if(inp.get(ir).equals(null)){
			 inp.set(ir, "");
			 }
			 inp.set(ir, sa[ir]);
			 }*/
			Toast.makeText(getBaseContext(), "File Reopened", Toast.LENGTH_LONG).show();
		} catch(Exception e){
			Toast.makeText(getBaseContext(), "Error Reopening File", Toast.LENGTH_LONG).show();
		}
	}

	//@Override
	public void clear(){
		AlertDialog.Builder alert = new AlertDialog.Builder(Expenses.this);
		final AlertDialog ad = alert.create();
		alert.setTitle("Clear All Contents?");
		alert.setMessage("Are you sure you want to Clear?");
		DialogInterface.OnClickListener yaha = new  DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int x){
				ad.dismiss();
			}
		};
		DialogInterface.OnClickListener yahb = new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int x){
				focus = false;
				if(slh.equals("ALL")){
					inp.clear();
				}
				else{
					for(int i=gla.getChildCount()-1; i>8; i--){
						View vr = gla.getChildAt(i);
						gla.removeView(vr);
					}
					//String[] srt = new String[]{};
					//srt = inpbrf.toArray(srt);
					for(int i=inpb.size()-2; i>-1; i--){
						int tg = inpbrf.get(i);
						inp.remove(tg);
					}
					inpb.clear();
					inpbrf.clear();
				}
				gl.removeAllViews();
				generate(gl, inp);
				et.clear();
				tve.clear();
				cv.clear();
				focus = true;
			}
		};
		alert.setNegativeButton("No\nCancel", yaha);
		alert.setPositiveButton("Yes\nClear", yahb).show();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		save();

	}

	@Override
	public void onBackPressed()
	{
		AlertDialog.Builder alert = new AlertDialog.Builder(Expenses.this);
		final AlertDialog ad = alert.create();
		alert.setTitle("Really Exit?");
		alert.setMessage("Are you sure you want to exit?");
		DialogInterface.OnClickListener yaha = new  DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int x){
				ad.dismiss();
			}
		};
		DialogInterface.OnClickListener yahb = new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int x){
				Expenses.super.onBackPressed();
			}
		};
		DialogInterface.OnClickListener yahc = new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int x){
				save();
				Expenses.super.onBackPressed();
			}
		};
		alert.setNegativeButton("No\nCancel", yaha);
		alert.setPositiveButton("Yes\nSave & Exit", yahc);
		alert.setNeutralButton("Yes\nExit", yahb).show();
	} 
}
