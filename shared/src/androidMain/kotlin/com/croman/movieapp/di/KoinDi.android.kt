package com.croman.movieapp.di

import app.cash.sqldelight.db.SqlDriver
import com.croman.movieapp.dao.sql_delight.DatabaseDriverFactory
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

actual inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier?,
    noinline definition: Definition<T>,
): KoinDefinition<T> = viewModel(qualifier = qualifier, definition = definition)

actual fun Module.sqlDriverDefinition() : KoinDefinition<SqlDriver> =
    single{ DatabaseDriverFactory(applicationContext).createDriver() }