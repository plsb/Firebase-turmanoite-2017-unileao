package br.edu.unileao.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReference = FirebaseDatabase.
                                                        getInstance().getReference();
    private DatabaseReference clientesReference = databaseReference.child("clientes");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cliente cliente = new Cliente();
        cliente.setNome("José");
        cliente.setEndereco("Rua D");
        cliente.setCpf("9944169");

        clientesReference.child("02").setValue(cliente);
    }
}
