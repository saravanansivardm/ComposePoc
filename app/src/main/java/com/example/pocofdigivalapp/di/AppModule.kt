package com.example.pocofdigivalapp.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pocofdigivalapp.api.Rest
import com.example.pocofdigivalapp.forgotpassword.ForgotPasswordViewModel
import com.example.pocofdigivalapp.forgotpassword.ForgotPasswordViewModelLatest
import com.example.pocofdigivalapp.mycourse.CourseListViewModel
import com.example.pocofdigivalapp.profile.basicdetails.ProfileScreenViewModel
import com.example.pocofdigivalapp.profile.profiledetailsscreen.ProfileDetailsScreenViewModel
import com.example.pocofdigivalapp.repository.*
import com.example.pocofdigivalapp.signup.SignUpViewModel
import com.example.pocofdigivalapp.signup.SignUpViewModelLatest
import com.example.pocofdigivalapp.studentmycourses.StudentCourseListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {
    private val viewModelModules = module {
        viewModel { SignUpViewModel(get()) }
        viewModel { ForgotPasswordViewModel(get()) }
        viewModel { CourseListViewModel(get()) }
        viewModel { StudentCourseListViewModel(get()) }
        viewModel { ProfileScreenViewModel(get()) }
        viewModel { SignUpViewModelLatest(get()) }
        viewModel { ProfileDetailsScreenViewModel() }
        viewModel { ForgotPasswordViewModelLatest(get()) }
    }

    private val repoModules = module {
        single { AuthRepo(androidContext()) }
        single { NewAuthRepository(androidContext(), get(), get()) }
        single { NewAuthApiManager(get()) }
        single { get<Rest>().getApi(NewAuthService::class.java) }
    }

    private val dashboardRepoModules = module {
        single { DashboardRepo(androidContext()) }
    }


    fun appModules() = viewModelModules + repoModules

}