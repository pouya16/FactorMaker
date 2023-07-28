package com.example.farshfactor

import android.content.Context
import androidx.room.Room
import com.example.farshfactor.database.FactorRoomDatabase

/*

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,FactorRoomDatabase::class.java,"factorDb")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideUserDao(db: FactorRoomDatabase) = db.userDao()

    @Provides
    @Singleton
    fun provideFactor(db: FactorRoomDatabase) = db.factorDao()

    @Provides
    @Singleton
    fun provideFactorDetail(db: FactorRoomDatabase) = db.factorDetailDao()

    @Provides
    @Singleton
    fun provideSetting(db:FactorRoomDatabase) = db.itemSettingsDao()

    @Provides
    @Singleton
    fun provideAddresses(db:FactorRoomDatabase) = db.addressesDao()


}*/
