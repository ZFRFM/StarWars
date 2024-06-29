package ru.faimizufarov.starwars.screens.character_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.faimizufarov.starwars.databinding.FragmentCharactersBinding
import ru.faimizufarov.starwars.screens.character_screen.adapter.CharactersAdapter

class CharactersFragment : Fragment() {
    private lateinit var binding: FragmentCharactersBinding
    private val charactersAdapter = CharactersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.filmNameStatusBar
        binding.contentCharacters.characterRecyclerView.adapter = charactersAdapter
    }

    companion object {
        fun newInstance() = CharactersFragment()
    }
}