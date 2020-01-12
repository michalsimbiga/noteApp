package com.application.model

import java.util.Date

data class Note(
    var created: Date,
    var title: String,
    var content: String
)