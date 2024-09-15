package com.net.alkye.utils.images

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size

open class ImageUtils {

    companion object {
        @Composable
        fun imageDefaultFutureCarFromDrawable(imageId: Int): AsyncImagePainter {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(imageId) // Replace with your drawable resource ID
                    .size(Size.ORIGINAL)
                    .build()
            )
            return painter
        }

        fun getDrawableResourceId(context: Context, drawableName: String): Int {
            return context.resources.getIdentifier(
                drawableName,
                "drawable",
                context.packageName
            )
        }
    }
}