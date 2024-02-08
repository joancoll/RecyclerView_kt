package cat.dam.andy.recyclerview_kt

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    //member variables
    private val items: ArrayList<Item> = ArrayList<Item>()
    private var rv_items: RecyclerView? = null
    private var myAdapter: CustomRecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initData()
        initDataAdapter()
    }

    private fun initViews() {
        rv_items = findViewById(R.id.rv_items)
    }

    private fun initData() {
        //Creem els items
        items.add(
            Item(
                1,
                "Pomes",
                "Pomes Fuji! De l'Empordà. Les millors del món!!!",
                R.drawable.apple,
                3.15
            )
        )
        items.add(
            Item(
                2,
                "Plàtans",
                "Platans de Canàries, ideals per recuperar l'energia!!!",
                R.drawable.banana,
                4.45
            )
        )
        items.add(
            Item(
                3,
                "Peres",
                "Molt bones i amb molt de suc, tenim peres per als amants de les fruites de la millor qualitat",
                R.drawable.pear,
                3.12
            )
        )
        items.add(
            Item(
                4,
                "Maduixes",
                "Maduixes amb gran qualitat i a un preu assequible!!!",
                R.drawable.strawberry,
                5.6
            )
        )
        items.add(
            Item(
                5,
                "Taronges",
                "Veritables taronges de València. Boníssimes!!",
                R.drawable.orange,
                1.2
            )
        )
        items.add(Item(6, "Mandarines", "Mandarines molt dolces", R.drawable.mandarin, 1.18))
        items.add(
            Item(
                7,
                "Pomelos",
                "Pomelos de l'Horta. Els has de provar!!!",
                R.drawable.pomelo,
                5.3
            )
        )
        items.add(
            Item(
                8,
                "Prunes",
                "Si t'agraden les prunes, aquestes són les teves, són boníssimes!!!",
                R.drawable.plum,
                3.2
            )
        )
        items.add(
            Item(
                9,
                "Raïms",
                "No cal que esperis al cap d'any a comprar raïms. Aquests són de la millor qualitat!!!",
                R.drawable.grapes,
                2.3
            )
        )
        items.add(
            Item(
                10,
                "Melons",
                "Melons dolços i refrescants amb la qualitat garantida!!!",
                R.drawable.muskmelon,
                1.03
            )
        )
    }

    private fun initDataAdapter() {
        //Creem l'adaptador
        myAdapter = CustomRecyclerView(this, items)
        //Establim l'adaptador i el layout manager
        rv_items!!.adapter = myAdapter
        rv_items!!.layoutManager = LinearLayoutManager(this)
    }

    //Gestionem el click de l'usuari en un item del RecyclerView gràcies al ViewHolder
    fun itemClick(view: View?, position: Int) {
        Toast.makeText(this, getString(R.string.haspressed, position), Toast.LENGTH_SHORT).show()
    }
}