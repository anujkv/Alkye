package com.net.alkye.data.remote.config

import androidx.room.Entity

@Entity(tableName = "config_menu")
data class ConfigMenu(
    val menu_list: List<Menu>
)

@Entity(tableName = "menu")
data class Menu(
    val article_img: String,
    val menu_id: Int,
    val menu_name: String
)