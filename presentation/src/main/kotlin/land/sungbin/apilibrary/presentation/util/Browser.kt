/*
 * Designed and developed by 2022 Ji Sungbin.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/duckie-team/ApiLibrary/blob/trunk/LICENSE
 */

package land.sungbin.apilibrary.presentation.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.ColorInt
import androidx.browser.customtabs.CustomTabsIntent


internal object Browser {
    private val customTabsIntent = CustomTabsIntent.Builder().build()

    fun open(
        context: Context,
        url: Uri,
    ) {
        val pm = context.packageManager
        val intent = pm.getLaunchIntentForPackage("com.android.chrome")
        if (intent == null) {
            val createChooser = Intent.createChooser(
                Intent(Intent.ACTION_VIEW, url),
                "Open with",
            )
            context.startActivity(createChooser)
        } else {
            customTabsIntent.launchUrl(context, url)
        }
    }
}
