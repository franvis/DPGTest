package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BackstagePassesTest {

    @Test
    fun updateBackstagePassesQuality_withTopQuality_updatesTheSellInButNotTheQualityAnymore() {
        val items = arrayOf(
                Item(GildedRose.BACKSTAGE_PASSES_ID, 10, 50)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(50, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun updateAgedBrieQuality_with12SellInAndPositiveQuality_updatesTheSellInAndTheQualityBy1() {
        val items = arrayOf(
                Item(GildedRose.BACKSTAGE_PASSES_ID, 12, 49),
                Item(GildedRose.BACKSTAGE_PASSES_ID, 12, 48),
                Item(GildedRose.BACKSTAGE_PASSES_ID, 12, 47),
                Item(GildedRose.BACKSTAGE_PASSES_ID, 12, 40)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(50, app.items[0].quality)
        assertEquals(11, app.items[0].sellIn)
        assertEquals(49, app.items[1].quality)
        assertEquals(11, app.items[1].sellIn)
        assertEquals(48, app.items[2].quality)
        assertEquals(11, app.items[2].sellIn)
        assertEquals(41, app.items[3].quality)
        assertEquals(11, app.items[3].sellIn)
    }

    @Test
    fun updateAgedBrieQuality_with10SellInAndPositiveQuality_updatesTheSellInAndTheQualityBy2() {
        val items = arrayOf(
                Item(GildedRose.BACKSTAGE_PASSES_ID, 10, 49),
                Item(GildedRose.BACKSTAGE_PASSES_ID, 10, 48),
                Item(GildedRose.BACKSTAGE_PASSES_ID, 10, 47),
                Item(GildedRose.BACKSTAGE_PASSES_ID, 10, 40)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(50, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
        assertEquals(50, app.items[1].quality)
        assertEquals(9, app.items[1].sellIn)
        assertEquals(49, app.items[2].quality)
        assertEquals(9, app.items[2].sellIn)
        assertEquals(42, app.items[3].quality)
        assertEquals(9, app.items[3].sellIn)
    }

    @Test
    fun updateAgedBrieQuality_with6SellInAndPositiveQuality_updatesTheSellInAndTheQualityBy3() {
        val items = arrayOf(
                Item(GildedRose.BACKSTAGE_PASSES_ID, 6, 49),
                Item(GildedRose.BACKSTAGE_PASSES_ID, 6, 48),
                Item(GildedRose.BACKSTAGE_PASSES_ID, 6, 47),
                Item(GildedRose.BACKSTAGE_PASSES_ID, 6, 40)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(50, app.items[0].quality)
        assertEquals(5, app.items[0].sellIn)
        assertEquals(50, app.items[1].quality)
        assertEquals(5, app.items[1].sellIn)
        assertEquals(50, app.items[2].quality)
        assertEquals(5, app.items[2].sellIn)
        assertEquals(43, app.items[3].quality)
        assertEquals(5, app.items[3].sellIn)
    }

    @Test
    fun updateAgedBrieQuality_with0SellInAndPositiveQuality_updatesTheSellInAndTheQualityTo0() {
        val items = arrayOf(
                Item(GildedRose.BACKSTAGE_PASSES_ID, 0, 49),
                Item(GildedRose.BACKSTAGE_PASSES_ID, 0, 48),
                Item(GildedRose.BACKSTAGE_PASSES_ID, 0, 47),
                Item(GildedRose.BACKSTAGE_PASSES_ID, 0, 40)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[1].quality)
        assertEquals(-1, app.items[1].sellIn)
        assertEquals(0, app.items[2].quality)
        assertEquals(-1, app.items[2].sellIn)
        assertEquals(0, app.items[3].quality)
        assertEquals(-1, app.items[3].sellIn)
    }
}