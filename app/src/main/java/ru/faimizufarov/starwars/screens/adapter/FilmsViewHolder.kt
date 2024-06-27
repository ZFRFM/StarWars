package ru.faimizufarov.starwars.screens.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.faimizufarov.starwars.data.models.Film
import ru.faimizufarov.starwars.databinding.ItemFilmBinding

class FilmsViewHolder(
    private val itemBinding: ItemFilmBinding
) : RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(film: Film) {
        with(itemBinding) {
            filmNameTextView.text = film.filmNameText
            directorNameTextView.text = film.directorNameText
            producerNameTextView.text = film.producerNameText
            releaseYearTextView.text = film.releaseYearText
        }
    }
}