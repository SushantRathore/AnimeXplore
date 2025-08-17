package com.ssr.animexplore.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssr.animexplore.domain.model.Anime
import com.ssr.animexplore.domain.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeListViewModel @Inject constructor(
    private val repository: AnimeRepository
) : ViewModel() {

    private val _animeList = MutableStateFlow<List<Anime>>(emptyList())
    val animeList: StateFlow<List<Anime>> = _animeList

    init {
        loadTopAnime()
    }

    fun loadTopAnime(forceRefresh: Boolean = false) {
        viewModelScope.launch {
            val list = repository.getTopAnime(forceRefresh)
            _animeList.value = list
        }
    }
}
