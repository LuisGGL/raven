package com.raven.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raven.home.data.Result
import com.raven.home.domain.entities.New
import com.raven.home.domain.usecases.GeNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewsUseCase: GeNewsUseCase
) : ViewModel() {

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading
    private val _news: MutableStateFlow<List<New>?> = MutableStateFlow(null)
    val news: StateFlow<List<New>?> get() = _news
    private val _error: MutableStateFlow<String?> = MutableStateFlow(null)
    val error: StateFlow<String?> get() = _error

    fun fetchData() {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            getNewsUseCase.execute().collect {
                if (it is Result.Success) {
                    _news.value = it.data.news
                } else if (it is Result.Error) {
                    _error.value = it.message
                }
            }
        }
        _isLoading.value = false
    }
}
