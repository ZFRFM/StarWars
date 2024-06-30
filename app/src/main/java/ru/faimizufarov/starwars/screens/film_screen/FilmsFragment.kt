package ru.faimizufarov.starwars.screens.film_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import ru.faimizufarov.starwars.data.models.Film
import ru.faimizufarov.starwars.data.repositories.FilmRepository
import ru.faimizufarov.starwars.databinding.FragmentFilmsBinding
import ru.faimizufarov.starwars.screens.film_screen.adapter.FilmsAdapter

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
        binding.contentSearch.filmRecyclerView.adapter = filmsAdapter
        lifecycleScope.launch {
            val films = filmRepository.getFilms().sortedBy {  film ->
                film.id
            }
            filmsAdapter.submitList(films)
            getQueryTextChange(films)
        }
    }

    @OptIn(FlowPreview::class)
    private suspend fun getQueryTextChange(films: List<Film>) {
        binding.searchView.getQueryTextChangeStateFlow()
            .debounce(300)
            .collect { query ->
                if (query.isNotEmpty()) {
                    val filteredFilms = films.filter { film ->
                        film.filmNameText.contains(query, ignoreCase = true)
                    }.sortedBy { film -> film.id }

                    filmsAdapter.submitList(filteredFilms)
                } else {
                    filmsAdapter.submitList(films)
                }
            }
    }

    companion object {
        fun newInstance() = FilmsFragment()
    }
}

fun SearchView.getQueryTextChangeStateFlow(): Flow<String> =
    callbackFlow {
        setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    trySend(newText).isSuccess
                    return true
                }
            },
        )

        awaitClose {
            setOnQueryTextListener(null)
        }
    }