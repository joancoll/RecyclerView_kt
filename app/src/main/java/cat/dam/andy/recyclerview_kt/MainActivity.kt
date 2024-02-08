package cat.dam.andy.recyclerview_kt

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    //member variables
    private lateinit var rvItems: RecyclerView
    // Obté les dades de l'objecte DataRepository,
    // així separem la lògica de negoci relacionada amb les dades
    // i la gestió de la lògica de la interfície d'usuari a l'aplicació.
    private val dataRepository = DataRepository()
    private val items: List<Item> by lazy { dataRepository.getDataItems() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initDataAdapter()
    }

    private fun initViews() {
        rvItems = findViewById(R.id.rv_items)
    }


    private fun initDataAdapter() {
        //Establim l'adaptador i el layout manager
        val myAdapter = CustomRecyclerView(items)
        rvItems.adapter = myAdapter
        rvItems.layoutManager = LinearLayoutManager(this)
    }

    //Gestionem el click de l'usuari en un item del RecyclerView gràcies al ViewHolder
    fun itemClick(view: View, position: Int) {
        val itemName = items[position].name
        Toast.makeText(this, getString(R.string.haspressed, itemName), Toast.LENGTH_SHORT).show()
    }
}