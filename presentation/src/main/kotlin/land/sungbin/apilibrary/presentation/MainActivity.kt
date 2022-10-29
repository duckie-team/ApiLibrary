/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:OptIn(ExperimentalMaterial3Api::class)

package land.sungbin.apilibrary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import land.sungbin.apilibrary.presentation.theme.ApiLibraryTheme
import land.sungbin.apilibrary.presentation.ui.ApiList

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ApiLibraryTheme {
                val uiState by vm.state.collectAsState()

                LaunchedEffect(key1 = Unit) {
                    vm.loadApis()
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { padding ->
                    ApiList(
                        modifier = Modifier.padding(
                            paddingValues = padding,
                        ),
                        uiState = uiState,
                    )
                }
            }
        }
    }
}
