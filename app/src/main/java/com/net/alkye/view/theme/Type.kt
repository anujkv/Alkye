package com.net.alkye.view.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.net.alkye.R

/*Stawford Font*/
val stawfordFontFamilys = FontFamily(
    Font(R.font.strawford_regular, FontWeight.Normal),
    Font(R.font.strawford_medium, FontWeight.Medium),
    Font(R.font.strawford_bold, FontWeight.Bold),
    Font(R.font.strawford_black, FontWeight.Black),
    Font(R.font.strawford_light, FontWeight.Light),
    Font(R.font.strawford_extralight, FontWeight.ExtraLight),
    Font(R.font.strawford_thin, FontWeight.Thin)
)

/*Scilla Font*/
val scillaFontFamilys = FontFamily(
    Font(R.font.scillanarrow_regularitalic, FontWeight.Normal),
    Font(R.font.scillanarrow_regular, FontWeight.Normal),
    Font(R.font.scillanarrow_regular, FontWeight.Normal)
)

/*Northwell Font*/
val northwellFontFamilys = FontFamily(
    Font(R.font.northwell, FontWeight.Normal),
    Font(R.font.northwellalt, FontWeight.Normal)
)

val CustomTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = scillaFontFamilys,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),

    titleLarge = TextStyle(
        fontFamily = scillaFontFamilys,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    /* Other default text styles to override*/
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)


