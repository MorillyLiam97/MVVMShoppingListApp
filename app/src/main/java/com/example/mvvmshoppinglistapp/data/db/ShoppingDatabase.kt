package com.example.mvvmshoppinglistapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmshoppinglistapp.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingListDAO

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null

        // Called everytime we create an instance of the ShoppingDatabase
        // returns: instance
        fun getAppDbInstance(context : Context) : ShoppingDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoppingDatabase::class.java,
                    "ShoppingDB.db")
                    .build()
            }
            return instance!!
        }
    }
}