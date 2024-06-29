package ru.faimizufarov.starwars.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.faimizufarov.starwars.data.repositories.FilmRepository
import ru.faimizufarov.starwars.databinding.FragmentFilmsBinding
import ru.faimizufarov.starwars.screens.adapter.FilmsAdapter

class FilmsFragment : Fragment() {
    private lateinit var binding: FragmentFilmsBinding
    private val filmsAdapter = FilmsAdapter()

    private val filmRepository: FilmRepository by lazy {
        FilmRepository(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.filmRecyclerView.adapter = filmsAdapter
        lifecycleScope.launch {
            val films = filmRepository.getFilms()
            filmsAdapter.submitList(films)
        }
    }

    companion object {
        fun newInstance() = FilmsFragment()
    }
}