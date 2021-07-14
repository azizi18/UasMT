package me.azizi.daftarbelanja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputBelanjaActivity extends AppCompatActivity {

    public static final String EXTRA_NAME_BELANJA = "nama";
    public static final String EXTRA_BANYAK_BELANJA = "banyak";
    private EditText edtName,edtBanyak;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_belanja);

        edtName=findViewById(R.id.edt_name);
        edtBanyak=findViewById(R.id.edt_banyak);
        btnSave=findViewById(R.id.btn_save);

        btnSave.setOnClickListener(v -> {
            Intent replyIntent = new Intent();

            String name = edtName.getText().toString().trim();
            int banyak = Integer.parseInt(edtBanyak.getText().toString().trim());

            if (TextUtils.isEmpty(edtBanyak.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            }else {
                replyIntent.putExtra(EXTRA_NAME_BELANJA, name);
                replyIntent.putExtra(EXTRA_BANYAK_BELANJA, banyak);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}