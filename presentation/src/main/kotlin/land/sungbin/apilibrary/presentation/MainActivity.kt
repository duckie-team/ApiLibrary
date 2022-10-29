/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

@file:OptIn(ExperimentalMaterial3Api::class)

package land.sungbin.apilibrary.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import land.sungbin.apilibrary.presentation.theme.ApiLibraryTheme
import land.sungbin.apilibrary.presentation.ui.ApiList
import land.sungbin.apilibrary.presentation.util.plus
import land.sungbin.apilibrary.presentation.util.systemBarPaddings

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        setContent {
            ApiLibraryTheme {
                val uiState by vm.state.collectAsState()

                LaunchedEffect(key1 = Unit) {
                    vm.loadApis()
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets(0), // remove local WindowInsets consumed by Scaffold
                    floatingActionButton = {
                        if (
                            uiState is ApiLibraryState.Loaded &&
                            (uiState as ApiLibraryState.Loaded).apis.isNotEmpty()
                        ) {
                            FloatingActionButton(
                                modifier = Modifier.padding(
                                    bottom = systemBarPaddings.calculateBottomPadding(),
                                ),
                                onClick = {
                                    Toast.makeText(
                                        applicationContext,
                                        "M3 에서 bottom sheet 가 아직 지원되지 않음",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.round_filter_list_24),
                                    contentDescription = "filter",
                                )
                            }
                        }
                    },
                ) { padding ->
                    ApiList(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                paddingValues = padding + PaddingValues(
                                    horizontal = 16.dp,
                                )
                            ),
                        uiState = uiState,
                    )
                }
            }
        }
    }
}
