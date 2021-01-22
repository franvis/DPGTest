package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class InconsistencyInputTest {

    @Test
    fun updateQuality_withPositiveQualityInconsistentInput_doesntUpdateAnything() {
        val items = arrayOf(
                Item(GildedRose.AGED_BRIE_ID, 10, 100)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(100, app.items[0].quality)
        assertEquals(10, app.items[0].sellIn)
    }

    @Test
    fun updateQuality_withNegativeInconsistentInput_doesntUpdateAnything() {
        val items = arrayOf(
                Item(GildedRose.AGED_BRIE_ID, 10, -10)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(-10, app.items[0].quality)
        assertEquals(10, app.items[0].sellIn)
    }
}
