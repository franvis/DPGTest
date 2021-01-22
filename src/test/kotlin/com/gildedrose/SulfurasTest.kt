package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SulfurasTest {

    @Test
    fun updateSulfurasQuality_remainsUnchanged() {
        val items = arrayOf(
                Item(GildedRose.SULFURAS_ID, 0, 80)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(80, app.items[0].quality)
        assertEquals(0, app.items[0].sellIn)
    }
}