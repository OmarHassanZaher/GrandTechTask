package com.bm.grandtechtask.data.model.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class MatchesResponse(
        @SerializedName("competition")
        val competition: Competition? = null,
        @SerializedName("count")
        val count: Int? = null,
        @SerializedName("filters")
        val filters: Filters? = null,
        @SerializedName("matches")
        val matches: List<Matche?>? = null
) {
    data class Competition(
            @SerializedName("area")
            val area: Area? = null,
            @SerializedName("code")
            val code: String? = null,
            @SerializedName("id")
            val id: Int? = null,
            @SerializedName("lastUpdated")
            val lastUpdated: String? = null,
            @SerializedName("name")
            val name: String? = null,
            @SerializedName("plan")
            val plan: String? = null
    ) {
        data class Area(
                @SerializedName("id")
                val id: Int? = null,
                @SerializedName("name")
                val name: String? = null
        )
    }

    class Filters
    @Entity(tableName = "matches")
    data class Matche(
            @SerializedName("awayTeam")
            val awayTeam: AwayTeam? = null,
            @SerializedName("group")
            val group: Any? = null,
            @SerializedName("homeTeam")
            val homeTeam: HomeTeam? = null,
            @PrimaryKey
            @SerializedName("id")
            val id: Int? = null,
            @SerializedName("lastUpdated")
            val lastUpdated: String? = null,
            @SerializedName("matchday")
            val matchday: Int? = null,
            @SerializedName("odds")
            val odds: Odds? = null,
            @SerializedName("referees")
            val referees: List<Any?>? = null,
            @SerializedName("score")
            val score: Score? = null,
            @SerializedName("season")
            val season: Season? = null,
            @SerializedName("stage")
            val stage: String? = null,
            @SerializedName("status")
            val status: String? = null,
            @SerializedName("utcDate")
            val utcDate: String? = null
    ) {
        data class AwayTeam(
                @SerializedName("id")
                val id: Int? = null,
                @SerializedName("name")
                val name: String? = null
        )

        data class HomeTeam(
                @SerializedName("id")
                val id: Int? = null,
                @SerializedName("name")
                val name: String? = null
        )

        data class Odds(
                @SerializedName("msg")
                val msg: String? = null
        )

        data class Score(
                @SerializedName("duration")
                val duration: String? = null,
                @SerializedName("extraTime")
                val extraTime: ExtraTime? = null,
                @SerializedName("fullTime")
                val fullTime: FullTime? = null,
                @SerializedName("halfTime")
                val halfTime: HalfTime? = null,
                @SerializedName("penalties")
                val penalties: Penalties? = null,
                @SerializedName("winner")
                val winner: Any? = null
        ) {
            data class ExtraTime(
                    @SerializedName("awayTeam")
                    val awayTeam: Any? = null,
                    @SerializedName("homeTeam")
                    val homeTeam: Any? = null
            )

            data class FullTime(
                    @SerializedName("awayTeam")
                    val awayTeam: Any? = null,
                    @SerializedName("homeTeam")
                    val homeTeam: Any? = null
            )

            data class HalfTime(
                    @SerializedName("awayTeam")
                    val awayTeam: Any? = null,
                    @SerializedName("homeTeam")
                    val homeTeam: Any? = null
            )

            data class Penalties(
                    @SerializedName("awayTeam")
                    val awayTeam: Any? = null,
                    @SerializedName("homeTeam")
                    val homeTeam: Any? = null
            )
        }

        data class Season(
                @SerializedName("currentMatchday")
                val currentMatchday: Int? = null,
                @SerializedName("endDate")
                val endDate: String? = null,
                @SerializedName("id")
                val id: Int? = null,
                @SerializedName("startDate")
                val startDate: String? = null
        )
    }
}
class SeasonTypeConverter {
    @TypeConverter
    fun fromString(value: String?): MatchesResponse.Matche.Season? {
        // Implement conversion logic from String to Season object
        // Return null if the value is null or conversion fails
        // Example:
        return Gson().fromJson(value, MatchesResponse.Matche.Season::class.java)
    }

    @TypeConverter
    fun toString(season: MatchesResponse.Matche.Season?): String? {
        // Implement conversion logic from Season object to String
        // Return null if the season is null or conversion fails
        // Example:
        return Gson().toJson(season)
    }
}

class ScoreTypeConverter {
    @TypeConverter
    fun fromString(value: String?): MatchesResponse.Matche.Score? {
        // Implement conversion logic from String to Score object
        // Return null if the value is null or conversion fails
        // Example:
        return Gson().fromJson(value, MatchesResponse.Matche.Score::class.java)
    }

    @TypeConverter
    fun toString(score: MatchesResponse.Matche.Score?): String? {
        // Implement conversion logic from Score object to String
        // Return null if the score is null or conversion fails
        // Example:
        return Gson().toJson(score)
    }
}
class AwayTypeConverter {
    @TypeConverter
    fun fromString(value: String?): MatchesResponse.Matche.AwayTeam? {
        // Implement conversion logic from String to Score object
        // Return null if the value is null or conversion fails
        // Example:
        return Gson().fromJson(value, MatchesResponse.Matche.AwayTeam::class.java)
    }

    @TypeConverter
    fun toString(away: MatchesResponse.Matche.AwayTeam?): String? {
        // Implement conversion logic from Score object to String
        // Return null if the score is null or conversion fails
        // Example:
        return Gson().toJson(away)
    }
}
class HomeTypeConverter {
    @TypeConverter
    fun fromString(value: String?): MatchesResponse.Matche.HomeTeam? {
        // Implement conversion logic from String to Score object
        // Return null if the value is null or conversion fails
        // Example:
        return Gson().fromJson(value, MatchesResponse.Matche.HomeTeam::class.java)
    }

    @TypeConverter
    fun toString(home: MatchesResponse.Matche.HomeTeam?): String? {
        // Implement conversion logic from Score object to String
        // Return null if the score is null or conversion fails
        // Example:
        return Gson().toJson(home)
    }
}
class OddsTypeConverter {
    @TypeConverter
    fun fromString(value: String?): MatchesResponse.Matche.Odds? {
        // Implement conversion logic from String to Score object
        // Return null if the value is null or conversion fails
        // Example:
        return Gson().fromJson(value, MatchesResponse.Matche.Odds::class.java)
    }

    @TypeConverter
    fun toString(odds: MatchesResponse.Matche.Odds?): String? {
        // Implement conversion logic from Score object to String
        // Return null if the score is null or conversion fails
        // Example:
        return Gson().toJson(odds)
    }
}
class GroupTypeConverter {
    @TypeConverter
    fun fromString(value: String?): Any? {
        // Implement conversion logic from String to Any object
        // Return null if the value is null or conversion fails
        // Example:
        return Gson().fromJson(value, Any::class.java)
    }

    @TypeConverter
    fun toString(group: Any?): String? {
        // Implement conversion logic from Any object to String
        // Return null if the group is null or conversion fails
        // Example:
        return Gson().toJson(group)
    }
}