package ifrn.edu.agendatelefones02;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class SobreActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sobre);
	}
	public void btnFecharClick(View v)
	{
		finish();
	}

}
