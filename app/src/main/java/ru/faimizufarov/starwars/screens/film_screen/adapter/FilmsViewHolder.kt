package ru.faimizufarov.starwars.screens.film_screen.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.faimizufarov.starwars.data.models.Film
import ru.faimizufarov.starwars.databinding.ItemFilmBinding

class FilmsViewHolder(
    private val itemBinding: ItemFilmBinding,
    onItemClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(itemBinding.root) {
    init {
        with(itemBinding) {
            root.setOnClickListener {
                onItemClicked(adapterPosition)
            }
        }
    }

    fun bind(film: Film) {
        with(itemBinding) {
            filmNameTextView.text = film.filmNameText
            directorNameTextView.text = film.directorNameText
            producerNameTextView.text = film.producerNameText
            releaseYearTextView.text = film.releaseYearText.toString()
        }
    }
}