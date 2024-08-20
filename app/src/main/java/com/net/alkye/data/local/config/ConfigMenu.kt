package com.net.alkye.data.local.config

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "config_menu")
data class ConfigMenu(
    val menu_list: List<Menu>
)

@Entity(tableName = "menu")
data class Menu(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val article_img: String,
    val menu_id: Int,
    val menu_name: String
)