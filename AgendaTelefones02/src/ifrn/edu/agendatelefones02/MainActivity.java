package ifrn.edu.agendatelefones02;



import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.TableLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	private final int ITEM_NOVOCONTATO = Menu.FIRST;
	private final int ITEM_SOBRE = Menu.FIRST + 1;
	private TableLayout tableLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	menu.add(Menu.NONE, ITEM_NOVOCONTATO, Menu.NONE, R.string.novoContato);
    			menu.add(Menu.NONE, ITEM_SOBRE, Menu.NONE, R.string.sobre);
    	
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()) {
    	case ITEM_NOVOCONTATO :
    		Intent novo_contato = new Intent(this, NovoContatoActivity.class);
    		startActivityForResult(novo_contato, 0); break;
    	case ITEM_SOBRE : 
    		Intent sobre = new Intent(this, SobreActivity.class); 
    		startActivity(sobre); break;
    	case R.id.action_fechar : 
    		finish(); break; 
    	}
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) 
    {
    	if (requestCode == 0) {
    		if (resultCode == RESULT_OK) {
    			String nome = data.getCharSequenceExtra("nome").toString();
    			String fone = data.getCharSequenceExtra("fone").toString();
    			inserirContato(nome, fone); 
    		}
    	}
    }
    
    private void inserirContato(String aNome, String aFone) {
    	LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    	View row = inflater.inflate(R.layout.tablerow_novo_contato, null);
    	EditText editNome = (EditText) row.findViewById(R.id.row_editNome);
    	EditText editFone = (EditText) row.findViewById(R.id.row_editFone);
    	Button button = (Button) row.findViewById(R.id.row_button);
    	editNome.setText(aNome);
    	editFone.setText(aFone);
    	button.setOnClickListener(buttonListener);
    	tableLayout.addView(row);
    }
    
    
    private OnClickListener buttonListener = new OnClickListener() {
    	@Override
    	public void onClick(View v) {
    		TableRow row = (TableRow) v.getParent();
    		EditText editFone = (EditText) row.findViewById(R.id.row_editFone);
    		String s = "tel:" + editFone.getText().toString();
    		Uri uri = Uri.parse(s);
    		Intent fone = new Intent(Intent.ACTION_CALL, uri);
    		startActivity(fone);
    	}
    }
    
}
