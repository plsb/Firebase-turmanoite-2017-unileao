package br.edu.unileao.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReference = FirebaseDatabase.
                                                        getInstance().getReference();
    private DatabaseReference clientesReference = databaseReference.child("clientes");
    private EditText edtNome, edtEndereco, edtCPF;
    private Button btSalvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEndereco = (EditText) findViewById(R.id.edtEnd);
        edtCPF = (EditText) findViewById(R.id.edtCpf);
        btSalvar = (Button) findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente cliente = new Cliente();
                cliente.setNome(edtNome.getText().toString());
                cliente.setEndereco(edtEndereco.getText().toString());
                cliente.setCpf(edtCPF.getText().toString());

                clientesReference.child(edtCPF.getText().toString()).setValue(cliente);

                edtNome.setText("");
                edtCPF.setText("");
                edtEndereco.setText("");
            }
        });

        clientesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(MainActivity.this, "Houve alteração",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
















