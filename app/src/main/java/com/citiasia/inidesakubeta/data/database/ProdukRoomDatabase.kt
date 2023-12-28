package com.citiasia.inidesakubeta.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Produk::class], version = 1, exportSchema = false)
abstract class ProdukRoomDatabase : RoomDatabase() {
    abstract fun produkDao(): ProdukDao

    companion object {
        @Volatile
        private var INSTANCE: ProdukRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): ProdukRoomDatabase {
            if (INSTANCE == null) {
                synchronized(ProdukRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ProdukRoomDatabase::class.java, "produk_database")
                        .build()
                }
            }
            return INSTANCE as ProdukRoomDatabase
        }
    }
}