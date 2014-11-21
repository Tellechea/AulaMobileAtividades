package ifrn.edu.aula2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
	
	private Button button1; 
	private EditText editText1;
	private EditText editText2;
	private EditText editText3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button1 = (Button) findViewById(R.id.button1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        button1.setOnClickListener(button1Listener);
    
    }
    
	public OnClickListener button1Listener = new OnClickListener()
    {
    @Override
    public void onClick(View v) {
    double base = Double.parseDouble(editText1.getText().toString());
    double altura = Double.parseDouble(editText2.getText().toString());
    double area = base * altura / 2;
    editText3.setText(String.format("%f", area));
    }
    };

    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
