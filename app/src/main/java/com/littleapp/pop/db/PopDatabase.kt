package com.littleapp.pop.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.littleapp.pop.model.PopItem

@Database(entities = [PopItem::class], version = 1, exportSchema = false)
abstract class PopDatabase : RoomDatabase() {
    abstract fun popDao(): PopDao
}