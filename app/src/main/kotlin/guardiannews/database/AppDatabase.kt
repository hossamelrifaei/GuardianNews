package guardiannews.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import guardiannews.model.Favourite

/**
 * Created by hossam
 */
@Database(entities = [Favourite::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favouriteDao(): FavouriteDao
}