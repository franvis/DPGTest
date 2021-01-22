package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RegularItemTest {

    @Test
    fun updateRegularItemQuality_withTopQualityAndPositiveSellIn_updatesTheSellInAndTheQualityLoweringBy1() {
        val items = arrayOf(
                Item(REGULAR_ITEM_NAME, 10, 50)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(49, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun updateNormalItemQuality_withZeroQualityAndPositiveSellIn_updatesTheSellInWithoutUpdatingTheQuality() {
        val items = arrayOf(
                Item(REGULAR_ITEM_NAME, 10, 0)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(0, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun updateNormalItemQuality_withTopQualityAndZeroSellIn_updatesTheSellInLoweringTheQualityBy2() {
        val items = arrayOf(
                Item(REGULAR_ITEM_NAME, 0, 50)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(48, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun updateNormalItemQuality_withOneUnitOfQualityAndZeroSellIn_updatesTheSellInSettingTheQualityToZero() {
        val items = arrayOf(
                Item(REGULAR_ITEM_NAME, 0, 1)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun updateNormalItemQuality_withTwoUnitOfQualityAndZeroSellIn_updatesTheSellInLoweringTheQualityToZero() {
        val items = arrayOf(
                Item(REGULAR_ITEM_NAME, 0, 2)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    companion object {
        const val REGULAR_ITEM_NAME = "This is a regular item"
    }
}