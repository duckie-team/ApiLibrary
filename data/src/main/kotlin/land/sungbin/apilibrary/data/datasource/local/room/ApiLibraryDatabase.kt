/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.datasource.local.room

import land.sungbin.apilibrary.data.model.ApiItem as DataApiItem
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [DataApiItem::class],
    version = 1,
)
abstract class ApiLibraryDatabase : RoomDatabase() {
    abstract fun dao(): ApiLibraryDao

    companion object {
        private const val DatabaseName = "ApiLibraryDatabase.db"
        private lateinit var database: ApiLibraryDatabase

        fun getDatabase(context: Context) = synchronized(
            lock = this,
        ) {
            if (!::database.isInitialized) {
                database = Room
                    .databaseBuilder(
                        context,
                        ApiLibraryDatabase::class.java,
                        DatabaseName,
                    )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            database
        }
    }
}
