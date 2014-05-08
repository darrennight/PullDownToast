package com.dk.util;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		PullDownToastUtil.init();
		PullDownToastUtil.setBackgroundResource(R.drawable.bg_toast);

		findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				//dock to something, maybe a title or actionbar
				PullDownToastUtil.showMessage(findViewById(R.id.something),
						"Hello,World!");
			}
		});
	}

}
