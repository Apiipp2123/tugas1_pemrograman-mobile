
package com.example.belajarandroidstudio;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubmit = findViewById(R.id.main_btn_submit);
        EditText etNama = findViewById(R.id.main_nama);
        ImageButton btnReset = findViewById(R.id.main_btn_reset);
        CheckBox cbCeklis = findViewById(R.id.main_cb_Ceklis);

        btnSubmit.setOnClickListener(v -> {
            String namaPengguna = etNama.getText().toString();
            if (namaPengguna.trim().isEmpty()) {
                etNama.setError("Tolong isi nama Anda terlebih dahulu");
                etNama.requestFocus();
                Toast.makeText(MainActivity.this, "Tolong isi nama Anda terlebih dahulu", Toast.LENGTH_SHORT).show();
                return;
            }
            if (cbCeklis.isChecked()) {
                Toast.makeText(MainActivity.this, "Hallo " + namaPengguna, Toast.LENGTH_LONG).show();
                Log.d("submit", namaPengguna);
            } else {
                Toast.makeText(MainActivity.this, "Tolong diceklis terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
        });
        btnReset.setOnClickListener(v -> {
            etNama.setText("");
//            etNama.setError(null);
//            etNama.requestFocus();
        });
    }
}
