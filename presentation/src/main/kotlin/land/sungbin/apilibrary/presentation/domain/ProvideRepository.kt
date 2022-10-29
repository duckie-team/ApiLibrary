/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation.domain

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import land.sungbin.apilibrary.data.repository.ApiLibraryRepositoryImpl
import land.sungbin.apilibrary.domain.datasource.ApiLibraryDatasource
import land.sungbin.apilibrary.domain.repository.ApiLibraryRepository

@Module
@InstallIn(SingletonComponent::class)
object ProvideRepository {
    @Provides
    fun provideApiLibraryRepository(
        @ApplicationContext context: Context,
        @Named(ProvideDataSource.Local) localDatasource: ApiLibraryDatasource,
        @Named(ProvideDataSource.Remote) remoteDatasource: ApiLibraryDatasource,
    ): ApiLibraryRepository {
        return ApiLibraryRepositoryImpl(
            calcIsOfflineMode = {
                !isNetworkAvailable(context = context)
            },
            localDatasource = localDatasource,
            remoteDatasource = remoteDatasource,
        )
    }

    private fun isNetworkAvailable(context: Context) =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            getNetworkCapabilities(activeNetwork)?.run {
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            } ?: false
        }
}
