/**
 * Copyright (c) 2011 by Studio Classics. All Rights Reserved.
 * Author: Brian Kurzius
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */
package ti.admob;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.TiContext.OnLifecycleEvent;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.util.Log;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;

@Kroll.proxy(creatableInModule=AdmobModule.class)
public class ViewProxy extends TiViewProxy implements OnLifecycleEvent
{
	private View adMob;
	private static final String LCAT = "AdMobViewProxy";

	public ViewProxy(TiContext tiContext)
	{
		super(tiContext);
		tiContext.addOnLifecycleEventListener(this);
	}

	@Override
	protected KrollDict getLangConversionTable() {
		KrollDict table = new KrollDict();
		table.put("title","titleid");
		return table;
	}

	@Override
	public TiUIView createView(Activity activity){
		adMob = new View(this);
		return adMob;
	}
	
	@Kroll.method
	public void requestAd() {
		Log.d(LCAT, "requestAd()");
		adMob.requestAd();
	}
	@Kroll.method
	public void requestTestAd() {
		Log.d(LCAT, "requestTestAd(): ");
		adMob.requestTestAd();
	}

	@Override
	public void onDestroy(Activity arg0) {
		adMob.destroy();
	}

	@Override
	public void onPause(Activity arg0) {
	}

	@Override
	public void onResume(Activity arg0) {
	}

	@Override
	public void onStart(Activity arg0) {
	}

	@Override
	public void onStop(Activity arg0) {
	}
	
}
