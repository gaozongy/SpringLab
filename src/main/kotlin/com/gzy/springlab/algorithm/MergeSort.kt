/**
 * 归并排序
 */
fun mergeSort(arr: IntArray): IntArray {
    if (arr.size <= 1) {
        return arr
    }

    // 找到中间点
    val middle = arr.size / 2

    // 分割数组为左右两部分
    val left = arr.sliceArray(0 until middle)
    val right = arr.sliceArray(middle until arr.size)

    // 递归排序左右两部分并合并
    return merge(mergeSort(left), mergeSort(right))
}

// 合并两个有序数组
fun merge(left: IntArray, right: IntArray): IntArray {
    val merged = IntArray(left.size + right.size)
    var i = 0 // 左数组指针
    var j = 0 // 右数组指针
    var k = 0 // 合并数组指针

    // 比较左右数组中的元素，将较小的插入合并数组
    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            merged[k] = left[i]
            i++
        } else {
            merged[k] = right[j]
            j++
        }
        k++
    }

    // 处理剩余元素（如果有）
    while (i < left.size) {
        merged[k] = left[i]
        i++
        k++
    }

    while (j < right.size) {
        merged[k] = right[j]
        j++
        k++
    }

    return merged
}

fun main() {
    val arr = intArrayOf(38, 27, 43, 3, 9, 82, 10)
    println("排序前的数组: ${arr.joinToString(", ")}")

    val sortedArray = mergeSort(arr)

    println("排序后的数组: ${sortedArray.joinToString(", ")}")
}