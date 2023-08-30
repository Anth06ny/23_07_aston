package com.example.a23_07_aston

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a23_07_aston.databinding.RowDogsBinding
import com.squareup.picasso.Picasso

class DogsListAdapter : ListAdapter<DogBean, DogsListAdapter.ViewHolder>(Comparator()) { //3

    //1 Class référençant les composants graphiques
    class ViewHolder(val bind: RowDogsBinding) : RecyclerView.ViewHolder(bind.root)

    //2 Permet de comparer des listes pour les animations
    class Comparator : DiffUtil.ItemCallback<DogBean>() {
        override fun areItemsTheSame(oldItem: DogBean, newItem: DogBean)
                = oldItem === newItem

        override fun areContentsTheSame(oldItem: DogBean, newItem: DogBean)
                = oldItem.id == newItem.id
    }

    //Instanciation d'une ligne de row_Dogs.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(RowDogsBinding.inflate(LayoutInflater.from(parent.context)))


    //Remplissage des composants graphiques
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind.textView.text = current.breed
        Picasso.get().load(current.img).into( holder.bind.imageView2)
    }
}
