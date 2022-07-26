package com.example.pocofdigivalapp.profile

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocofdigivalapp.CourseListState
import com.example.pocofdigivalapp.api.CustomResponse
import com.example.pocofdigivalapp.data.basicdetailupdate.*
import com.example.pocofdigivalapp.data.userdetailsget.BasicDetail
import com.example.pocofdigivalapp.repository.AuthRepo
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
                    val basicDetailMap = mutableMapOf<String, String>()
                    basicDetails.forEach { basicDetail ->
                        basicDetailMap.put(basicDetail.name, "")
                    }
                    viewModelState.update {
                        it.copy(
                            isLoading = false,
                            basicDetailsMap = basicDetailMap
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

    fun onSubmitClicked() {
        Log.e("onSubmitClicked_log", cacheBasicDetailsMap.values.toString())
        val basicDetailKeyList = arrayListOf<String>()
        basicDetailKeyList.addAll(cacheBasicDetailsMap.values)
        if (basicDetailKeyList.isEmpty()) {

        }

        /*cacheBasicDetailsMap.values.forEachIndexed { index, item ->
            if (basicDetailKeyList.isEmpty()) {
                Log.e("list_empty_log", "empty")
            } else if (index == 0 && item.isEmpty()) {
                Log.e("first_name_empty_log", "empty")
                viewModelState.update {
                    it.copy(
                        isError = true
                    )
                }
            } else if (index == 1 && item.isEmpty()) {
                Log.e("middle_name_empty_log", "empty")
            } else if (index == 2 && item.isEmpty()) {
                Log.e("last_name_empty_log", "empty")
            } else if (index == 3 && item.isEmpty()) {
                Log.e("gender_empty_log", "empty")
            } else if (index == 4 && item.isEmpty()) {
                Log.e("phone_number_empty_log", "empty")
            } else if (index == 5 && item.isEmpty()) {
                Log.e("emp_id_empty_log", "empty")
            } else if (index == 6 && item.isEmpty()) {
                Log.e("email_id_empty_log", "empty")
            } else {
            }
        }*/

        viewModelScope.launch {
            _myCourseListState.value = CourseListState.Loading
            val email = cacheBasicDetailsMap["Email Id"]
            val gender = cacheBasicDetailsMap["Gender"]
            val firstName = cacheBasicDetailsMap["First Name"]
            val middleName = cacheBasicDetailsMap["Middle Name"]
            val lastName = cacheBasicDetailsMap["Last Name"]
            val countryCode = cacheBasicDetailsMap["+91"]
            val mobileNumber = cacheBasicDetailsMap["Phone Number"]
            val basicDetailsMobile =
                BasicDetailsMobile(code = "+91", no = mobileNumber.toString())
            val basicDetailsName = BasicDetailsName(firstName, middleName, lastName, "family")
            Log.e("basicDetailsMobile_logg", basicDetailsMobile.toString())
            Log.e("basicDetailsName_logg", basicDetailsName.toString())

            when (val response = authRepo.getBasicDetailUpdate(
                getBasicDetailsCredentials(
                    email = email,
                    name = basicDetailsName,
                    gender = gender,
                    mobile = basicDetailsMobile
                )
            )) {
//            when (val response = authRepo.getBasicDetailUpdate()) {
                is CustomResponse.Success -> {
                    cachedProfileDetailsUpdateList = listOf(response.data)
                    Log.e(
                        "cachedProfileDetailsUpdateList_logg",
                        cachedProfileDetailsUpdateList.get(0).message
                    )
                    viewModelState.update {
                        it.copy(
                            isLoading = true,
                        )
                    }
                }
                is CustomResponse.Failure -> {
                    _myCourseListState.value = CourseListState.Failed(response.error)
                }
            }
        }
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
    val isError: Boolean? = false,
    val basicDetailsMap: MutableMap<String, String> = mutableMapOf(),
    val lastUpdated: Long = System.currentTimeMillis(),
) {
    fun toUiState() =
        ProfileUiState(
            isLoading = isLoading,
            basicDetailsMap = basicDetailsMap,
            lastUpdated = lastUpdated,
            isError = isError,
        )
}


data class ProfileUiState(
    val isLoading: Boolean?,
    val basicDetailsMap: MutableMap<String, String>,
    val lastUpdated: Long,
    val isError: Boolean? = false,
)
