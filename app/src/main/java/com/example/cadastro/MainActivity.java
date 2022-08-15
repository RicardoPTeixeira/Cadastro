package com.example.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.cadastro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding amb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.getRoot());

        amb.limpar.setOnClickListener(v -> {
            amb.nameEt.setText(null);
            amb.cidadeEt.setText(null);
            amb.emailEt.setText(null);
            amb.phoneEt.setText(null);
            amb.checkBox.setChecked(false);
            amb.inicialRg.clearCheck();
            amb.spinner.setSelection(0);
        });
        amb.enviar.setOnClickListener(v -> {
            var nome = amb.nameEt.getText().toString();
            var phone = amb.phoneEt.getText().toString();
            var email = amb.emailEt.getText().toString();
            var emailList = amb.checkBox.isChecked();
            var gender = ((RadioButton) findViewById(amb.inicialRg.getCheckedRadioButtonId())).getText();
            var city = amb.cidadeEt.getText().toString();
            var uf = String.valueOf(amb.spinner.getSelectedItem());
            String formValues =
                    "    Nome: " + nome + "\n" +
                    "    Telefone: " + phone + "\n" +
                    "    Email: " + email + "\n" +
                    "    Email na lista: " + emailList + "\n" +
                    "    Gênero: " + gender + "\n" +
                    "    Cidade: " + city + "\n" +
                    "    UF: " + uf;
            Toast.makeText(getBaseContext(), formValues.toString(), Toast.LENGTH_SHORT).show();
        });
    }
}