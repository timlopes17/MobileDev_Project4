package edu.temple.timlopes_project4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find layout (root element)
        val layout = findViewById<View>(R.id.layout)

        // Create array of color objects
        val colors = arrayOf(
            ImageObject(1, "Avatar.jpeg"),
            ImageObject(2, "BabyDriver.jpg"),
            ImageObject(3, "DarkKnight.jpg"),
            ImageObject(4, "ET.jpg"),
            ImageObject(5, "FightClub.jpg"),
            ImageObject(6, "Parasite.jpg"),
            ImageObject(7, "PulpFiction.jpg"),
            ImageObject(8, "Shrek.jpg"),
            ImageObject(9, "TheGodFather.jpg"),
            ImageObject(10, "TheLorax.jpg"),
            ImageObject(10, "TheMatrix.jpg")
        )


        val myRecyclerViewFunc = {
                // colorObject:ColorObject -> layout.setBackgroundColor(Color.parseColor(colorObject.code))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Assign a Grid layout manager with 2 columns
        recyclerView.layoutManager = GridLayoutManager(this, 4)

        // Initialize adapter with lambda for event listening
        recyclerView.adapter = ColorAdapter(colors, myRecyclerViewFunc)
    }
}