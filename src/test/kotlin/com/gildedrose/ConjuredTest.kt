package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConjuredTest {

    @Test
    fun updateConjuredQuality_withTopQualityAndPositiveSellIn_updatesTheSellInAndTheQualityLoweringBy2() {
        val items = arrayOf(
                Item(GildedRose.CONJURED_ID, 10, 50)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(48, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun updateConjuredQuality_withQualityOneAndPositiveSellIn_updatesTheSellInAndTheQualityAs0() {
        val items = arrayOf(
                Item(GildedRose.CONJURED_ID, 10, 1)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(0, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun updateConjuredQuality_withLowestQualityAndPositiveSellIn_updatesTheSellInAndLeavesTheQualityAs0() {
        val items = arrayOf(
                Item(GildedRose.CONJURED_ID, 10, 0)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(0, app.items[0].quality)
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun updateConjuredQuality_withLowestQualityAndNegativeSellIn_updatesTheSellInAndLeavesTheQualityAs0() {
        val items = arrayOf(
                Item(GildedRose.CONJURED_ID, -2, 0)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(0, app.items[0].quality)
        assertEquals(-3, app.items[0].sellIn)
    }

    @Test
    fun updateConjuredQuality_withTopQualityAndNegativeSellIn_updatesTheSellInAndTheQualityLoweringBy4() {
        val items = arrayOf(
                Item(GildedRose.CONJURED_ID, -1, 50)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(46, app.items[0].quality)
        assertEquals(-2, app.items[0].sellIn)
    }

    @Test
    fun updateConjuredQuality_withTopQualityAnd1SellIn_updatesTheSellInAndTheQualityLoweringBy2() {
        val items = arrayOf(
                Item(GildedRose.CONJURED_ID, 1, 50)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(48, app.items[0].quality)
        assertEquals(0, app.items[0].sellIn)
    }

    @Test
    fun updateConjuredQuality_withTopQualityAndZeroSellIn_updatesTheSellInAndTheQualityLoweringBy4() {
        val items = arrayOf(
                Item(GildedRose.CONJURED_ID, 0, 50)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(46, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun updateConjuredQuality_withTwoQualityAndZeroSellIn_updatesTheSellInAndTheQualityTo0() {
        val items = arrayOf(
                Item(GildedRose.CONJURED_ID, 0, 2)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun updateConjuredQuality_withTwoQualityAndPositiveSellIn_updatesTheSellInAndTheQualityTo0() {
        val items = arrayOf(
                Item(GildedRose.CONJURED_ID, 2, 2)
        )
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(0, app.items[0].quality)
        assertEquals(1, app.items[0].sellIn)
    }
}