package cat.dam.andy.recyclerview_kt

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomRecyclerView    //Constructor, aquí passem els ítems que mostrarem, és a dir, el model de dades
    (
    context: Context?, //Aquesta classe és el nostre adaptador, és a dir, el que ens permetrà mostrar les dades
    //Members
    private val dataSet: ArrayList<Item>
) :
    RecyclerView.Adapter<ViewHolder>() {
    //Mètode que només es crida la primera vegada en crear la llista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Creem la vista de cada ítem a partir del nostre layout
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false)
        return ViewHolder(context, view)
    }

    //Es crida cada vegada que es fa scroll a la pantalla i els elements desapareixen i apareixen
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        //Donem valor als views de cada card mitjançant el ViewHolder
        val item = dataSet[position]
        viewHolder.name.setText(item.name)
        viewHolder.desc.setText(item.description)
        val price: String = item.price.toString() + " €"
        viewHolder.price.setText(price)
        viewHolder.image.setImageResource(item.imageResourceID)
    }

    // Torna el nombre d'ítems del nostre arraylist, l'invoca automàticament el layout manager
    override fun getItemCount(): Int {
        return dataSet.size
    }
}