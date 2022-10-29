/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:OptIn(ExperimentalCoroutinesApi::class)

package land.sungbin.apilibrary.data.test

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import land.sungbin.apilibrary.data.datasource.local.LocalMockDatasource
import land.sungbin.apilibrary.data.datasource.local.room.ApiLibraryDao
import land.sungbin.apilibrary.data.datasource.local.room.ApiLibraryMockDatabase
import land.sungbin.apilibrary.data.datasource.remote.FakeResponse
import land.sungbin.apilibrary.data.repository.ApiLibraryMockRepository
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import strikt.api.expectThat
import strikt.assertions.isEqualTo

@RunWith(AndroidJUnit4::class)
class LocalTest {
    private lateinit var db: ApiLibraryMockDatabase
    private lateinit var dao: ApiLibraryDao
    private val localDatasource by lazy {
        LocalMockDatasource(dao = dao)
    }
    private val repository by lazy {
        ApiLibraryMockRepository(dao = dao)
    }

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = ApiLibraryMockDatabase.getDatabase(context = context)
        db.clearAllTables()
        dao = db.dao()
    }

    @Test
    fun save_five_apis() = runTest {
        val apis = FakeResponse.ApiItems
        localDatasource.saveAllApis(apis = apis)

        expectThat(localDatasource.fetchAllApis()) {
            isEqualTo(apis)
        }
    }

    @Test
    fun remote_fetch_and_save_local() = runTest {
        db.clearAllTables()

        val apis = FakeResponse.ApiItems
        repository.fetchAllApis(isOfflineMode = false)

        expectThat(localDatasource.fetchAllApis()) {
            isEqualTo(apis)
        }
    }

    @Test
    fun online_fetch_and_offline_fetch_result_is_same() = runTest {
        db.clearAllTables()

        val fetchResponse = repository.fetchAllApis(isOfflineMode = false)
        val localResponse = repository.fetchAllApis(isOfflineMode = true)

        expectThat(fetchResponse) {
            isEqualTo(localResponse)
        }
    }

    @Test
    fun empty_table_load_is_empty_list() = runTest {
        db.clearAllTables()

        expectThat(localDatasource.fetchAllApis()) {
            isEqualTo(emptyList())
        }
    }

    @After
    fun closeDb() {
        db.close()
    }
}
