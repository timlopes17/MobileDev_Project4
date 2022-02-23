package edu.temple.timlopes_project4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(_imageObjects : Array<ImageObject>, _myFunc : (ImageObject)->Unit) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){

    val imageObjects = _imageObjects
    val myEventHandlingFunc = _myFunc

    // Create view holder (defined as 'inner' class to access members of outer class
    inner class ImageViewHolder(_view: View) : RecyclerView.ViewHolder(_view) {
        //val imageTextView = _view.findViewById<TextView>(R.id.imageTextView)
        val imageImageView = _view.findViewById<ImageView>(R.id.imageImageView)

        // Initialized when new binding is invoked
        lateinit var imageObject: ImageObject
        init {
            _view.setOnClickListener{myEventHandlingFunc(imageObject)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        // Inflate layout file instead of creating views in code
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_layout, parent, false)
        return ImageViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        // Manipulate view attributes based on item at 'position'
        //holder.imageTextView.text = imageObjects[position].title
        /*
        if(position == 0)
            holder.imageImageView.setImageResource(R.drawable.avatar)
        else if(position == 1)
            holder.imageImageView.setImageResource(R.drawable.babydriver)
        else if(position == 2)
            holder.imageImageView.setImageResource(R.drawable.darkknight)
        else if(position == 3)
            holder.imageImageView.setImageResource(R.drawable.et)
        else if(position == 4)
            holder.imageImageView.setImageResource(R.drawable.fightclub)
        else if(position == 5)
            holder.imageImageView.setImageResource(R.drawable.parasite)
            */
         holder.imageImageView.setImageResource(imageObjects[position].title)


        //holder.colorDisplayView.setBackgroundColor(Color.parseColor(colorObjects[position].code))

        // Add object at 'position' to ViewHolder
        //holder.colorObject = colorObjects[position]
        holder.imageObject = imageObjects[position]
    }

    override fun getItemCount(): Int {
        return imageObjects.size
    }
}