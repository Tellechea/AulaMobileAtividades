package ifrn.edu.agendatelefones02;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NovoContatoActivity extends Activity {
	
	private Button btnOk;
	private Button btnCancel;
	private EditText editNome;
	private EditText editFone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_novo_contato);
		btnOk = (Button) findViewById(R.id.nc_btnOk);
		btnCancel = (Button) findViewById(R.id.nc_btnCancel);
		editNome = (EditText) findViewById(R.id.nc_editNome);
		editFone = (EditText) findViewById(R.id.nc_editFone);
	}
	
	public void buttonClick(View v) {
		if (v == btnOk) {
			Intent ret = new Intent();
			String nome = editNome.getText().toString();
			String fone = editFone.getText().toString();
			ret.putExtra("nome", nome);
			ret.putExtra("fone", fone);
			setResult(RESULT_OK, ret);
			finish(); }
		if (v == btnCancel) {
			setResult(RESULT_CANCELED);
			finish(); }
	}

	
	

}
