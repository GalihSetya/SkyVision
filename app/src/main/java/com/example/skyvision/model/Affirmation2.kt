package com.example.skyvision.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation2(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)