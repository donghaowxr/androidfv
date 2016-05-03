package com.gc.flashview;

import java.util.ArrayList;
import java.util.List;
import com.gc.flashview.constants.EffectConstants;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	private FlashView flashView;
	private List<String>imageUrls;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		flashView=(FlashView) findViewById(R.id.flash_view);
		imageUrls=new ArrayList<String>();
		imageUrls.add("assets://img1.jpg");
		imageUrls.add("assets://img2.jpg");
		imageUrls.add("assets://img3.jpg");
		imageUrls.add("assets://img4.jpg");
		flashView.setImageUris(imageUrls);
		flashView.setEffect(EffectConstants.CUBE_EFFECT);
	}
}
