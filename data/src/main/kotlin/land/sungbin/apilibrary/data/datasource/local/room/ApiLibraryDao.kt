/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.datasource.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import land.sungbin.apilibrary.data.model.ApiItem

@Dao
interface ApiLibraryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(apiItems: List<ApiItem>)

    @Query("SELECT * FROM ApiItem")
    suspend fun getAll(): List<ApiItem>
}
