package ifrn.edu.aula03agendatelefones;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {


	
	private EditText editText1;
	private EditText editText2;
	private Button button1;
	private Button button2;
	private Button button3;
	private TextView textView1;
	
	private Contatos agenda;
	
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        agenda = new Contatos();
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        textView1 = (TextView) findViewById(R.id.textView1);

    }
	
	public void buttonClick(View v) {
		if (v == button1) {
			agenda.inserir(editText1.getText().toString(), 
					editText2.getText().toString());
			textView1.setText(agenda.toString()); 
		}
		if (v == button2) {
			if (agenda.editar(editText1.getText().toString(), 
					editText2.getText().toString()))
				textView1.setText(agenda.toString()); 
		}
		if (v == button3) {
			if (agenda.excluir(editText1.getText().toString(), 
					editText2.getText().toString()))
				textView1.setText(agenda.toString()); 
		}
	}

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
