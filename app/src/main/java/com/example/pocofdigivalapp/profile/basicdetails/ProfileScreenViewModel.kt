package com.example.pocofdigivalapp.profile.basicdetails

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocofdigivalapp.CourseListState
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.api.CustomResponse
import com.example.pocofdigivalapp.data.basicdetailupdate.*
import com.example.pocofdigivalapp.data.userdetailsget.BasicDetail
import com.example.pocofdigivalapp.repository.AuthRepo
import com.example.pocofdigivalapp.utils.rawString
import com.example.pocofdigivalapp.utils.resourceString
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ProfileScreenViewModel(private val authRepo: AuthRepo) : ViewModel() {

    private val viewModelState = MutableStateFlow(
        ProfileViewModelState(isLoading = false)
    )
    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())

    private val _myCourseListState: MutableState<CourseListState> =
        mutableStateOf(CourseListState.Loading)
    private val basicDetails: ArrayList<BasicDetail> = arrayListOf()
    private var cacheBasicDetailsMap: MutableMap<String, String> = mutableMapOf()
    private var cachedProfileDetailsUpdateList = listOf<BasicDetailsUpdateResponse>()

    init {
        getBasicDetails()
    }

    private fun getBasicDetails() {
        viewModelScope.launch {
            _myCourseListState.value = CourseListState.Loading
            when (val response = authRepo.getUserDetails()) {
                is CustomResponse.Success -> {
                    basicDetails.addAll(response.data.data.labels.labelDetails[0].basicDetails)
//                    Log.e("bbbb_logg", basicDetails.toString())
                    val basicDetailMap = mutableMapOf<String, String>()
                    val basicDetailsIsActiveMap = mutableMapOf<String, String>()
                    basicDetails.forEach { basicDetail ->
                        basicDetailMap.put(basicDetail.name, "")
                    }
                    basicDetails.forEach { basicDetailActive ->
//                        Log.e("_id_log", basicDetailActive.id)
//                        Log.e("_name_log", basicDetailActive.name)
//                        Log.e("_isActive_log", basicDetailActive.isActive.toString())
                        basicDetailsIsActiveMap.put(basicDetailActive.isActive.toString(), "")
                    }
                    viewModelState.update {
                        it.copy(
                            isLoading = false,
                            basicDetailsMap = basicDetailMap,
                            basicDetailsIsActiveMap = basicDetailsIsActiveMap,
                        )
                    }
                }
                is CustomResponse.Failure -> {
                    _myCourseListState.value = CourseListState.Failed(response.error)
                }
            }
        }
    }

    fun onValueEntered(map: MutableMap<String, String>) {
//        Log.e("get_Log", map.getValue("First Name"))
        viewModelState.update {
            it.copy(
                basicDetailsMap = map,
                lastUpdated = System.currentTimeMillis(),
            )
        }
        cacheBasicDetailsMap = map
    }

    private fun validateInputFields(): Pair<Boolean, Int?> {
        var position: Int?
        Log.e("cacheBasicDetailsMap_log", cacheBasicDetailsMap.values.toString())
        cacheBasicDetailsMap.values.forEachIndexed { index, item ->
            if (item.isBlank() || item.isEmpty()) {
                position = index
                return false to position
            }
        }
        return true to null
    }

    fun onSubmitClicked() {
        val value = validateInputFields()
        Log.e("first_log", value.first.toString())
        Log.e("second_log", value.second.toString())
        if (!value.first || cacheBasicDetailsMap.values.isEmpty()) {
            viewModelState.update {
                it.copy(
                    position = value.second ?: 0,
                )
            }
        } else {
            Log.e("sfkk_log", "true")
        }
    }

    private fun onErrorFound(message: String) {
        viewModelState.update { it.copy(isLoading = false) }
        val value = if (message.isEmpty()) resourceString(R.string.provide_valid_credentials)
        else rawString(message)
        Log.e("error_value", value.toString())
//        setMessage(value)
    }

    private fun getBasicDetailsCredentials(
        email: String?,
        name: BasicDetailsName,
        gender: String?,
        mobile: BasicDetailsMobile,
    ) =
        BasicDetailsCredentialsModel(
            user_type = "staff",
            setMode = "basic-details",
            data = BasicDetailsData(
                email = email.toString(),
                gender = gender.toString(),
                mobile = mobile,
                name = name
            )
        )
}

data class ProfileViewModelState(
    val isLoading: Boolean? = false,
    val position: Int? = null,
    val basicDetailsMap: MutableMap<String, String> = mutableMapOf(),
    val basicDetailsIsActiveMap: MutableMap<String, String> = mutableMapOf(),
    val lastUpdated: Long = System.currentTimeMillis(),
) {
    fun toUiState() =
        ProfileUiState(
            isLoading = isLoading,
            basicDetailsMap = basicDetailsMap,
            basicDetailsIsActiveMap = basicDetailsIsActiveMap,
            lastUpdated = lastUpdated,
            position = position,
        )
}


data class ProfileUiState(
    val isLoading: Boolean?,
    val basicDetailsMap: MutableMap<String, String>,
    val basicDetailsIsActiveMap: MutableMap<String, String> = mutableMapOf(),
    val lastUpdated: Long,
    val position: Int?,
)
