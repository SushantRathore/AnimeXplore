package com.ssr.animexplore.presentation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssr.animexplore.domain.model.AnimeDetail
import com.ssr.animexplore.domain.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val repository: AnimeRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _animeDetail = MutableStateFlow<AnimeDetail?>(null)
    val animeDetail: StateFlow<AnimeDetail?> = _animeDetail

    init {
        val animeId = savedStateHandle.get<Int>("animeId") ?: 0
        Log.d("AnimeDetailVM", "Fetching animeId=$animeId")
        viewModelScope.launch {
            try {
                _animeDetail.value = repository.getAnimeDetail(animeId)
            } catch (e: Exception) {
                Log.e("AnimeDetailVM", "Error fetching detail", e)
                e.printStackTrace()
            }
        }
    }
}

