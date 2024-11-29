package com.dilip.common.mapper

fun interface ResultMapper<T, R> {
    fun map(input: T): R
}
