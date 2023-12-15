package ru.easycode.zerotoheroandroidtdd

interface LoadResult {

    fun show(updateLiveData: LiveDataWrapper.Update)

    object Progress : LoadResult {

        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowProgress)
        }
    }

    data class Success(val data: SimpleResponse) : LoadResult {

        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(data.text))
        }
    }

    data class Error(val noConnection: Boolean) : LoadResult {

        private val text = if (noConnection) "No internet connection" else "Something went wrong"

        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(text))
        }
    }
}