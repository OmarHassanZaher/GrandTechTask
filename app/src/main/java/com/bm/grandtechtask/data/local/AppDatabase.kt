package com.bm.grandtechtask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bm.grandtechtask.data.model.response.AwayTypeConverter
import com.bm.grandtechtask.data.model.response.GroupTypeConverter
import com.bm.grandtechtask.data.model.response.HomeTypeConverter
import com.bm.grandtechtask.data.model.response.MatchesResponse
import com.bm.grandtechtask.data.model.response.OddsTypeConverter
import com.bm.grandtechtask.data.model.response.ScoreTypeConverter
import com.bm.grandtechtask.data.model.response.SeasonTypeConverter

@Database(entities = [MatchesResponse.Matche::class], version = 1, exportSchema = false)
@TypeConverters(SeasonTypeConverter::class, ScoreTypeConverter::class,
    AwayTypeConverter::class, HomeTypeConverter::class, OddsTypeConverter::class,
    GroupTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDap(): AppDao
}