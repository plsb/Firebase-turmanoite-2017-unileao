package br.edu.unileao.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReference = FirebaseDatabase.
                                                        getInstance().getReference();
    private DatabaseReference clientesReference = databaseReference.child("clientes");
    private EditText edtNome;
    private Button btSalvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = (EditText) findViewById(R.id.edtNome);
        btSalvar = (Button) findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente cliente = new Cliente();
                cliente.setNome(edtNome.getText().toString());
                cliente.setEndereco("Rua D");
                cliente.setCpf("9944169");

                clientesReference.child("03").setValue(cliente);

                edtNome.setText("");
            }
        });


    }
}
















