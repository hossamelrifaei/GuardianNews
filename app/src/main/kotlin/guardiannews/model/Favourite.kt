package guardiannews.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by hossam
 */
@Entity(tableName = "favourite")
data class Favourite(@PrimaryKey var image: String
                     , @ColumnInfo var title: String
                     , @ColumnInfo var body: String) {
    constructor() : this("", "", "")
}