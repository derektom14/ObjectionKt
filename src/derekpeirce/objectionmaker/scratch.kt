package derekpeirce.objectionmaker

import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.valueParameters

data class Item(val foo: Int, val bar: Int): Comparable<Item> {
    override fun compareTo(other: Item): Int {
        return compareValuesBy(this, other, { foo }, { bar })
    }
}