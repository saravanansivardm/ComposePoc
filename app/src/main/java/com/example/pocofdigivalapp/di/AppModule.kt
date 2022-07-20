package com.example.pocofdigivalapp.di

import com.example.pocofdigivalapp.forgotpassword.ForgotPasswordViewModel
import com.example.pocofdigivalapp.mycourse.CourseListViewModel
import com.example.pocofdigivalapp.repository.AuthRepo
import com.example.pocofdigivalapp.repository.DashboardRepo
import com.example.pocofdigivalapp.signup.SignUpViewModel
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
    }

    private val repoModules = module {
        single { AuthRepo(androidContext()) }
    }

    private val dashboardRepoModules = module {
        single { DashboardRepo(androidContext()) }
    }


    fun appModules() = viewModelModules + repoModules
}