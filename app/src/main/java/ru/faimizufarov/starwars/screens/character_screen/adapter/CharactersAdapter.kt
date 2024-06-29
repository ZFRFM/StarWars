package ru.faimizufarov.starwars.screens.character_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.faimizufarov.starwars.data.models.Character
import ru.faimizufarov.starwars.databinding.ItemCharacterBinding

class CharactersAdapter: ListAdapter<Character, CharactersViewHolder>(ItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val itemBinding =
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )

        return CharactersViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val character = currentList[position]
        holder.bind(character)
    }

    companion object ItemCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(
            oldItem: Character,
            newItem: Character,
        ) = oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: Character,
            newItem: Character,
        ) = oldItem == newItem
    }
}