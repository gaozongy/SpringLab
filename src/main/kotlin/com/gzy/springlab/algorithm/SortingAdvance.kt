package com.gzy.springlab.algorithm

import kotlin.random.Random

/**
 * 归并排序
 */
fun main() {
    val array = IntArray(10) { Random.nextInt(0, 10) }
    println("排序前: ${array.joinToString(", ")}")
    val result = mergeSort(array)
    println("排序后: ${result.joinToString(", ")}")
}

fun mergeSort(array: IntArray): IntArray {
    val arrayHolder = ArrayHolder(array)
    val splitArray = splitArray(arrayHolder)
    val sortArray = sortArray(splitArray)
    return sortArray.sortArray.toIntArray()
}

fun sortArray(arrayHolder: ArrayHolder): ArrayHolder {
    if (arrayHolder.left?.sortArray?.isEmpty() == true) {
        sortArray(arrayHolder.left!!)
    }
    if (arrayHolder.right?.sortArray?.isEmpty() == true) {
        sortArray(arrayHolder.right!!)
    }

    var i = 0
    var j = 0
    val l = arrayHolder.left!!.sortArray
    val r = arrayHolder.right!!.sortArray

    while (i < l.size || j < r.size) {
        if (i >= l.size) {
            arrayHolder.sortArray.add(i + j, r[j])
            j++
        } else if (j >= r.size) {
            arrayHolder.sortArray.add(i + j, l[i])
            i++
        } else if (l[i] < r[j]) {
            arrayHolder.sortArray.add(i + j, l[i])
            i++
        } else {
            arrayHolder.sortArray.add(i + j, r[j])
            j++
        }
    }

    return arrayHolder
}

fun splitArray(arrayHolder: ArrayHolder): ArrayHolder {
    val array = arrayHolder.array
    if (array.size > 1) {
        val mid = array.size / 2
        val left = array.sliceArray(0 until mid)
        val right = array.sliceArray(mid until array.size)
        val childLeft = ArrayHolder(left)
        val childRight = ArrayHolder(right)
        arrayHolder.left = childLeft
        arrayHolder.right = childRight
        splitArray(childLeft)
        splitArray(childRight)
    } else if (array.size == 1) {
        arrayHolder.sortArray = arrayHolder.array.toMutableList()
    }
    return arrayHolder
}

data class ArrayHolder(
    val array: IntArray,
    var left: ArrayHolder? = null,
    var right: ArrayHolder? = null,
    var sortArray: MutableList<Int> = intArrayOf().toMutableList()
)
