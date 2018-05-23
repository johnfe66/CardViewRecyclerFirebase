package com.johnfe66.cardviewrecyclerfirebase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.johnfe66.cardviewrecyclerfirebase.model.Persona;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by johnfelipevargas on 3/21/18.
 */

public class Adapter extends  RecyclerView.Adapter<Adapter.PersonaViewHolder>{

    List<Persona> personaList;

    public Adapter(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_datos, parent, false);
        PersonaViewHolder holder = new PersonaViewHolder(v);

        return holder;

    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {

        Persona persona = personaList.get(position);

        holder.nombre.setText(persona.getNombre());
        holder.telefono.setText(persona.getTelefono());
        holder.documento.setText(persona.getDocumento());
        Picasso.get()
                .load("https://firebasestorage.googleapis.com/v0/b/storagefirebase-29558.appspot.com/o/All_Image_Uploads%2F1527098642974.jpg?alt=media&token=8159a3cf-3de2-49ce-a0ad-e6760a482091")
                .resize(350, 300)
                .centerCrop()
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
         return personaList.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder {


        TextView nombre, telefono, documento;
        ImageView img;

        public PersonaViewHolder(View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.txtNombreRow);
            telefono= itemView.findViewById(R.id.txtTelefonoRow);
            documento = itemView.findViewById(R.id.txtDocumentoRow);
            img = itemView.findViewById(R.id.img);

        }



    }
}
