package guardiannews.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import guardiannews.model.Favourite
import io.reactivex.Single

@Dao
interface FavouriteDao {
    @Query("SELECT * from favourite")
    fun loadFavorite(): Single<List<Favourite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavourite(favourite: Favourite)
}
