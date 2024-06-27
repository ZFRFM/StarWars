package ru.faimizufarov.starwars.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.faimizufarov.starwars.data.network.AppApi
import ru.faimizufarov.starwars.data.network.toFilm
import ru.faimizufarov.starwars.databinding.FragmentFilmsBinding
import ru.faimizufarov.starwars.screens.adapter.FilmsAdapter

class FilmsFragment : Fragment() {
    private lateinit var binding: FragmentFilmsBinding
    private val filmsAdapter = FilmsAdapter()

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
            val films = AppApi.retrofitService.getFilms().results.map { it.toFilm() }
            withContext(Dispatchers.Main) {
                filmsAdapter.submitList(films)
            }
        }
    }

    companion object {
        fun newInstance() = FilmsFragment()
    }
}