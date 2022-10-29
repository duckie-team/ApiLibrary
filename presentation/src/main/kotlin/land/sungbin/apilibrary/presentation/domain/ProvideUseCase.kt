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
import land.sungbin.apilibrary.domain.repository.ApiLibraryRepository
import land.sungbin.apilibrary.domain.usecase.ApiLibraryFetchUseCase

@Module
@InstallIn(SingletonComponent::class)
internal object ProvideUseCase {
    @Provides
    fun provideApiLibraryFetchUseCase(
        repository: ApiLibraryRepository,
    ): ApiLibraryFetchUseCase {
        return ApiLibraryFetchUseCase(
            repository = repository,
        )
    }
}
