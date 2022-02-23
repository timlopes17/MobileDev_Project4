package edu.temple.timlopes_project4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(_imageObjects : Array<ImageObject>, _myFunc : (ImageObject)->Unit) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){

    private val imageObjects = _imageObjects
    private val myEventHandlingFunc = _myFunc

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

        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_layout, parent, false)
        return ImageViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        holder.imageImageView.setImageResource(imageObjects[position].resourceId)

        holder.imageObject = imageObjects[position]
    }

    override fun getItemCount(): Int {
        return imageObjects.size
    }
}