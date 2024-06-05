package com.example.mvvmshoppinglistapp.data.di

import android.app.Application
import com.example.mvvmshoppinglistapp.data.db.ShoppingDatabase
import com.example.mvvmshoppinglistapp.data.db.ShoppingListDAO
import com.example.mvvmshoppinglistapp.data.repositories.ShoppingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun getAppDatabase(application: Application) : ShoppingDatabase {
        return ShoppingDatabase.getAppDbInstance(application)
    }

    @Singleton
    @Provides
    fun getAppDAO(database: ShoppingDatabase) : ShoppingListDAO {
        return database.getShoppingDao()
    }

    @Singleton
    @Provides
    fun provideRepository(database: ShoppingDatabase) : ShoppingRepository {
        return ShoppingRepository(database)
    }
}