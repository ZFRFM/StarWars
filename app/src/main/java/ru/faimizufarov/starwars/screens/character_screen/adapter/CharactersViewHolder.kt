package ru.faimizufarov.starwars.screens.character_screen.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.faimizufarov.starwars.data.models.Character
import ru.faimizufarov.starwars.databinding.ItemCharacterBinding

class CharactersViewHolder(
    private val itemBinding: ItemCharacterBinding
) : RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(character: Character) {
        with(itemBinding) {
            characterNameText.text = character.name
            characterGenderText.text = character.gender
            characterBirthDateText.text = character.birthDate
        }
    }
}