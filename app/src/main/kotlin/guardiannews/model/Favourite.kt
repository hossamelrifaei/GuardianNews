package guardiannews.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

/**
 * Created by hossam
 */
@Entity(tableName = "favourite")
data class Favourite @Ignore constructor(@PrimaryKey var image: String = ""
                                         , var title: String = ""
                                         , var body: String = "") {
    constructor() : this("")
}