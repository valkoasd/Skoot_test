package com.valko.scoot.datamodels

class Car(
    val regNumber: String,
    val logoUrl: String,
    val type: String,
    val regDate: String,
    val color: String,
    val tax: Boolean,
    val taxExpDate: String,
    val MOT: Boolean,
    val MOTExpDate: String
)