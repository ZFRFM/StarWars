package ru.faimizufarov.starwars.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.faimizufarov.starwars.databinding.FragmentFilmsBinding

class FilmsFragment : Fragment() {
    private lateinit var binding: FragmentFilmsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = FilmsFragment()
    }
}