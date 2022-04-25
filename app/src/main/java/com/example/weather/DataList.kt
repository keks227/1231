package com.example.weather

class DataList(val data: List<ListItem>)

data class ListItem(
    val description: String,
    val temp: String
)