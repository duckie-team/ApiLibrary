/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.data.test

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import land.sungbin.apilibrary.data.datasource.local.LocalDatasource
import land.sungbin.apilibrary.data.datasource.local.room.ApiLibraryDao
import land.sungbin.apilibrary.data.datasource.local.room.ApiLibraryDatabase
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LocalTest {
    private lateinit var db: ApiLibraryDatabase
    private lateinit var dao: ApiLibraryDao
    private val localDatasource by lazy {
        LocalDatasource(dao = dao)
    }

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = ApiLibraryDatabase.getDatabase(context)
        dao = db.dao()
    }

    @After
    fun closeDb() {
        db.close()
    }
}
