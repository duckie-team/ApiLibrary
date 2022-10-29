/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import land.sungbin.apilibrary.data.datasource.RemoteDatasource
import land.sungbin.apilibrary.data.datasource.local.LocalDatasource
import land.sungbin.apilibrary.data.datasource.local.room.ApiLibraryDao
import land.sungbin.apilibrary.domain.datasource.ApiLibraryDatasource

@Module
@InstallIn(SingletonComponent::class)
internal object ProvideDataSource {
    const val Remote = "remote"
    const val Local = "local"

    @Named(Remote)
    @Provides
    fun provideApiLibraryRemoteDataSource(): ApiLibraryDatasource {
        return RemoteDatasource()
    }

    @Named(Local)
    @Provides
    fun provideApiLibraryLocalDataSource(
        dao: ApiLibraryDao,
    ): ApiLibraryDatasource {
        return LocalDatasource(
            dao = dao,
        )
    }
}
