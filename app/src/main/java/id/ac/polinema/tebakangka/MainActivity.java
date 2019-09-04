package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText nameInput;
	private Button cek;
	int acak;
	int x;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		nameInput = findViewById(R.id.number_input);
		cek = findViewById(R.id.guess_button);
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random rand = new Random();
		x = rand.nextInt(100);
		acak = x;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		String ambil = nameInput.getText().toString();
		int tebak = Integer.parseInt(ambil);
		if(tebak < acak){
			Toast.makeText(this, "Angka Terlalu kecil", Toast.LENGTH_SHORT).show();
		}
		else if(tebak > acak){
			Toast.makeText(this, "Angka Terlalu Besar", Toast.LENGTH_SHORT).show();
		}
		else{
			Toast.makeText(this, "Tebakan Anda Benar", Toast.LENGTH_SHORT).show();
			cek.setEnabled(false);
			nameInput.setEnabled(false);
		}
	}
	public void handleReset(View view) {
		// TODO: Reset tampilan
		initRandomNumber();
		cek.setEnabled(true);
		nameInput.setEnabled(true);
		nameInput.setText("");
	}
}
