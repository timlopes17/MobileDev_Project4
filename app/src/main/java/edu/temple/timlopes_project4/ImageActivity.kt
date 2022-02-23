package edu.temple.timlopes_project4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find layout (root element)
        val layout = findViewById<View>(R.id.layout)
        val image = findViewById<ImageView>(R.id.imageView)
        val text = findViewById<TextView>(R.id.textView)

        // Create array of color objects
        val images = arrayOf(
            ImageObject("Avatar", R.drawable.avatar),
            ImageObject("Baby Driver", R.drawable.babydriver),
            ImageObject("The Dark Knight", R.drawable.darkknight),
            ImageObject("E.T.", R.drawable.et),
            ImageObject("Fight Club", R.drawable.fightclub),
            ImageObject("Parasite", R.drawable.parasite),
            ImageObject("Pulp Fiction", R.drawable.pulpfiction),
            ImageObject("Shrek", R.drawable.shrek),
            ImageObject("The Godfather", R.drawable.thegodfather),
            ImageObject("The Lorax", R.drawable.thelorax),
            ImageObject("The Matrix", R.drawable.thematrix),
        )


        val myRecyclerViewFunc = {
            imageObject:ImageObject ->
                image.setImageResource(imageObject.resourceId)
                text.text = imageObject.title
                // colorObject:ColorObject -> layout.setBackgroundColor(Color.parseColor(colorObject.code))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Assign a Grid layout manager with 4 columns
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // Initialize adapter with lambda for event listening
        recyclerView.adapter = ImageAdapter(images, myRecyclerViewFunc)
    }
}