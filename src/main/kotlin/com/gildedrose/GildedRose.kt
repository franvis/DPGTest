package com.gildedrose

class GildedRose(val items: Array<Item>) {

    /**
     * Updates the quality and sellIn fields of the items.
     * In case that any item has a requirement inconsistency, it leaves it as it is.
     */
    fun updateQuality() {
        items.forEach { item ->
            if (hasNoInconsistencies(item)) {
                with(item.name) { // TODO Identifying selling items by their name or beginning of the name is not the best. Let's add a UUID.
                    if (!startsWith(SULFURAS_ID)) item.sellIn--
                    when {
                        startsWith(SULFURAS_ID) -> return@forEach // Since Sulfuras doesn't suffer any changes we just skip it
                        startsWith(AGED_BRIE_ID) -> updateBrieQuality(item)
                        startsWith(BACKSTAGE_PASSES_ID) -> updateBackstagePassQuality(item)
                        startsWith(CONJURED_ID) -> updateConjuredQuality(item)
                        else -> updateRegularItemQuality(item)
                    }
                }
            }
        }
    }

    /**
     * Checks that the input has no inconsistencies according to the requirements.
     */
    private fun hasNoInconsistencies(item: Item): Boolean =
            (item.quality <= HIGHEST_QUALITY || item.name.contains(SULFURAS_ID)) && item.quality >= LOWEST_QUALITY

    /**
     * Updates the quality of a regular item considering normal everything that doesn't have any special quality treatment.
     * The requirement says quality gets every day lower, but not the amount per day, so we assume a loss of 1 quality unit per day.
     */
    private fun updateRegularItemQuality(item: Item) {
        with(item) {
            if (quality > LOWEST_QUALITY) {
                if (sellIn < LOWEST_QUALITY && quality > 1) {
                    quality -= 2
                } else {
                    quality--
                }
            }
        }
    }

    /**
     * Updates the quality of a conjured item
     */
    private fun updateConjuredQuality(item: Item) {
        with(item) {
            if (quality > LOWEST_QUALITY) {
                if (quality == 1 || (sellIn < 0 && quality < 4)) {
                    quality = LOWEST_QUALITY
                } else if (sellIn < 0 && quality >= 4) {
                    quality -= 4
                } else {
                    quality -= 2
                }
            }
        }
    }

    /**
     * Updates the quality of a backstage pass quality item
     * The requirement says quality increases every day, but not the amount per day, so we assume an increase
     * of 1 quality unit per day as for when the concert is further than 10 days.
     */
    private fun updateBackstagePassQuality(item: Item) {
        with(item) {
            if (quality < HIGHEST_QUALITY) {
                quality = when {
                    sellIn <= -1 -> LOWEST_QUALITY
                    sellIn in 0..5 -> if (quality < 48) quality + 3 else HIGHEST_QUALITY
                    sellIn in 6..10 -> if (quality < 49) quality + 2 else HIGHEST_QUALITY
                    sellIn > 10 -> quality + 1
                    else -> quality
                }
            }
        }
    }

    /**
     * Updates the quality of a aged brie item
     * The requirement says quality increases every day, but not the amount per day, so we assume an increase
     * of 1 quality unit per day.
     */
    private fun updateBrieQuality(item: Item) {
        if (item.quality < HIGHEST_QUALITY) item.quality++
    }

    companion object {
        const val SULFURAS_ID = "Sulfuras, Hand of Ragnaros"
        const val AGED_BRIE_ID = "Aged Brie"
        const val BACKSTAGE_PASSES_ID = "Backstage passes"
        const val CONJURED_ID = "Conjured"
        const val HIGHEST_QUALITY = 50
        const val LOWEST_QUALITY = 0
    }
}
