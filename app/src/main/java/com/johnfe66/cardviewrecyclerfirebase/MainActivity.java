package com.johnfe66.cardviewrecyclerfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.johnfe66.cardviewrecyclerfirebase.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv;

    List<Persona> personas;

    Adapter adapter;

    DatabaseReference personaRef ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv= findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));

        personas = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        personaRef =  database.getReference("personas");

        adapter = new Adapter(personas);

        rv.setAdapter(adapter);

        personaRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                personas.removeAll(personas);

                for (DataSnapshot dataSnapshotHijo : dataSnapshot.getChildren()) {

                    Persona persona = dataSnapshotHijo.getValue(Persona.class);

                    System.out.println("****************: " );
                    System.out.println("nombre Recycler: "+persona.getNombre() );
                    System.out.println("documento Recycler : "+persona.getDocumento() );
                    System.out.println("telefono Recycler: "+persona.getTelefono() );

                    //Persona per = dataSnapshotHijo.getValue(Persona.class);

                    personas.add(persona);


                }


                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });






    }
}
