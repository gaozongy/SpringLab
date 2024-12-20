/**
 * 快速排序
 */
fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        // 获取分区索引
        val pivotIndex = partition(arr, low, high)

        // 对分区的左右两部分递归进行排序
        quickSort(arr, low, pivotIndex - 1) // 左子数组
        quickSort(arr, pivotIndex + 1, high) // 右子数组
    }
}

// 分区函数
fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high] // 选择最后一个元素作为基准
    var i = low - 1 // 小于基准的元素的索引

    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            // 交换 arr[i] 和 arr[j]
            arr.swap(i, j)
        }
    }

    // 将基准元素放到正确的位置
    arr.swap(i + 1, high)

    return i + 1
}

// 交换函数
fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun main() {
    val arr = intArrayOf(10, 80, 30, 90, 40, 50, 70)
    println("排序前的数组: ${arr.joinToString(", ")}")

    quickSort(arr, 0, arr.size - 1)
    println("排序后的数组: ${arr.joinToString(", ")}")
}