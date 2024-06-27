package ru.faimizufarov.starwars.screens.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.faimizufarov.starwars.data.models.Film
import ru.faimizufarov.starwars.databinding.ItemFilmBinding

class FilmsAdapter: ListAdapter<Film, FilmsViewHolder>(ItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val itemBinding =
            ItemFilmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )

        return FilmsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        val film = currentList[position]
        holder.bind(film)
    }

    companion object ItemCallback : DiffUtil.ItemCallback<Film>() {
        override fun areItemsTheSame(
            oldItem: Film,
            newItem: Film,
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Film,
            newItem: Film,
        ) = oldItem == newItem
    }
}