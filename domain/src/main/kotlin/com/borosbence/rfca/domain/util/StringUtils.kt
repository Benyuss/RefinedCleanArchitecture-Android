package com.borosbence.rfca.domain.util

import java.text.Collator
import java.util.*

object StringUtils {

    /**
     * Compares the given strings into each other.
     * It's locale sensitive but ignores lower- and uppercase.
     */
    fun compare(arg1: String, arg2: String): Int {
        val collator = Collator.getInstance(Locale.getDefault())
        collator.strength = Collator.PRIMARY
        return collator.compare(arg1.toLowerCase(), arg2.toLowerCase())
    }
}