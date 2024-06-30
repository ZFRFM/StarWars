package ru.faimizufarov.starwars.screens.character_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.faimizufarov.starwars.data.repositories.CharacterRepository
import ru.faimizufarov.starwars.data.repositories.FilmRepository
import ru.faimizufarov.starwars.databinding.FragmentCharactersBinding
import ru.faimizufarov.starwars.screens.character_screen.adapter.CharactersAdapter

class CharactersFragment : Fragment() {
    private lateinit var binding: FragmentCharactersBinding
    private val charactersAdapter = CharactersAdapter()

    private val characterRepository: CharacterRepository by lazy {
        CharacterRepository(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.contentCharacters.characterRecyclerView.adapter = charactersAdapter

        setFragmentResultListener(FILM_POSITION_RESULT) { _, bundle ->
            val filmName = bundle.getString(FILM_NAME)

            binding.filmNameStatusBar.text = filmName

            lifecycleScope.launch {

            }
        }
    }

    companion object {
        const val FILM_NAME = "FILM_NAME"
        const val CHARACTER_URLS = "CHARACTER_URLS"
        const val FILM_POSITION_RESULT = "FILM_POSITION_RESULT"

        fun newInstance() = CharactersFragment()
    }
}