package edu.temple.timlopes_project4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find layout (root element)
        val layout = findViewById<View>(R.id.layout)
        val image = findViewById<ImageView>(R.id.imageView)

        // Create array of color objects
        val images = arrayOf(
            ImageObject(1, R.drawable.avatar),
            ImageObject(2, R.drawable.babydriver),
            ImageObject(3, R.drawable.darkknight),
            ImageObject(4, R.drawable.et),
            ImageObject(5, R.drawable.fightclub),
            ImageObject(9, R.drawable.parasite),
            ImageObject(10, R.drawable.pulpfiction),
            ImageObject(11, R.drawable.shrek),
            ImageObject(6, R.drawable.thegodfather),
            ImageObject(7, R.drawable.thelorax),
            ImageObject(8, R.drawable.thematrix),
        )


        val myRecyclerViewFunc = {
            imageObject:ImageObject ->
                image.setImageResource(imageObject.title)
                // colorObject:ColorObject -> layout.setBackgroundColor(Color.parseColor(colorObject.code))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Assign a Grid layout manager with 4 columns
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // Initialize adapter with lambda for event listening
        recyclerView.adapter = ImageAdapter(images, myRecyclerViewFunc)
    }
}