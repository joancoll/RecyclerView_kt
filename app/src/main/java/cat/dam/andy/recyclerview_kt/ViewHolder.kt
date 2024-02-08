package cat.dam.andy.recyclerview_kt

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(private val context: Context, itemView: View) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    //Getters
    //El ViewModel fa de pont amb els Views de la interficie gràfica
    //Members
    val name: TextView
    val desc: TextView
    val price: TextView
    val image: ImageView

    init {
        name = itemView.findViewById(R.id.tv_item_name)
        desc = itemView.findViewById(R.id.tv_item_desc)
        price = itemView.findViewById(R.id.tv_item_price)
        image = itemView.findViewById(R.id.iv_item_image)
        // Defineix clic listener per els elements de la llista
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        //Podem propagar l'esdeveniment a la MainActivity gràcies al context
        //així podem gestionar el click al punt que vulguem de la nostra aplicació
        val mainActivity = context as MainActivity
        mainActivity.itemClick(view, adapterPosition)
    }
}