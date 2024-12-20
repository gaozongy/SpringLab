/**
 * 插入排序
 */
fun insertionSort(arr: IntArray) {
    val n = arr.size
    for (i in 1 until n) {
        val current = arr[i]
        var j = i - 1

        while (j >= 0 && arr[j] > current) {
            arr[j + 1] = arr[j]
            j--
        }

        arr[j + 1] = current
    }
}

fun main() {
    val arr = intArrayOf(64, 25, 12, 22, 11)
    println("排序前: ${arr.joinToString(",")}")

    insertionSort(arr)
    println("排序后: ${arr.joinToString(",")}")
}