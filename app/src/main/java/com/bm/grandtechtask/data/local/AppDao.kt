package com.bm.grandtechtask.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bm.grandtechtask.data.model.response.MatchesResponse

@Dao
interface AppDao {
    @Insert
    suspend fun insertMatch(match: MatchesResponse.Matche)
}