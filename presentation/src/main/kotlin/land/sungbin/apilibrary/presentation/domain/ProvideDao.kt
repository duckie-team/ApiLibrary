/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation.domain

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import land.sungbin.apilibrary.data.datasource.local.room.ApiLibraryDao
import land.sungbin.apilibrary.data.datasource.local.room.ApiLibraryDatabase

@Module
@InstallIn(SingletonComponent::class)
internal object ProvideDao {
    @Provides
    fun provideApiLibraryDao(
        @ApplicationContext context: Context,
    ): ApiLibraryDao {
        return ApiLibraryDatabase.getDatabase(
            context = context,
        ).dao()
    }
}
