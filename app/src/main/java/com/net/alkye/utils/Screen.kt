package com.net.alkye.utils

sealed class Screen (val rout: String){
data object Splash:Screen("splash")
data object Welcome:Screen("welcome")
data object Signup:Screen("signup")
data object Signin:Screen("signin")
data object Home:Screen("home")
data object Article:Screen("article")
data object BookMark:Screen("bookmark")
data object Tv:Screen("tv")
data object Notification:Screen("notification")
data object UserAccount:Screen("user_account")
}