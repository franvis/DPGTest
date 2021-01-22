package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AgedBrieTest {

    @Test
    fun updateAgedBrieQuality_withTopQuality_updatesTheSellInButNotTheQualityAnymore() {
        val items = arrayOf(
                Item(GildedRose.AGED_BRIE_ID, 10, 50)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(50, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun updateAgedBrieQuality_withPositiveSellInAndPositiveQualityLowerThan50_updatesTheSellInAndTheQuality() {
        val items = arrayOf(
                Item(GildedRose.AGED_BRIE_ID, 10, 49)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(50, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun updateAgedBrieQuality_withNegativeSellInAndPositiveQualityLowerThan50_updatesTheSellInAndTheQuality() {
        val items = arrayOf(
                Item(GildedRose.AGED_BRIE_ID, -4, 30)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(31, app.items[0].quality)
        assertEquals(-5, app.items[0].sellIn)
    }

    @Test
    fun updateAgedBrieQuality_whenIsSellInDayAndWithLowestQuality_updatesTheSellInAndTheQuality() {
        val items = arrayOf(
                Item(GildedRose.AGED_BRIE_ID, 0, 0)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(1, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }
}