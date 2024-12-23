package com.gzy.springlab.algorithm

/**
 * 堆排序
 */
fun heapSort(arr: IntArray) {
    val n = arr.size

    // 构建初始大顶堆
    for (i in n / 2 - 1 downTo 0) {
        heapify(arr, n, i)
    }

    // 提取元素并调整堆
    for (i in n - 1 downTo 1) {
        arr.swap(0, i) // 将堆顶（最大值）与末尾元素交换
        heapify(arr, i, 0) // 调整堆，确保剩余部分仍为大顶堆
    }
}

// 调整堆，使其满足大顶堆性质
fun heapify(arr: IntArray, heapSize: Int, root: Int) {
    var largest = root // 当前根节点作为最大值
    val left = 2 * root + 1 // 左子节点索引
    val right = 2 * root + 2 // 右子节点索引

    // 如果左子节点大于根节点，则将左子节点作为最大值
    if (left < heapSize && arr[left] > arr[largest]) {
        largest = left
    }

    // 如果右子节点大于当前最大值，则将右子节点作为最大值
    if (right < heapSize && arr[right] > arr[largest]) {
        largest = right
    }

    // 如果最大值不是根节点，则交换并递归调整子树
    if (largest != root) {
        arr.swap(root, largest)
        heapify(arr, heapSize, largest)
    }
}

// 交换函数
fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun main() {
    val arr = intArrayOf(12, 11, 13, 5, 6, 7)
    println("排序前的数组: ${arr.joinToString(", ")}")

    heapSort(arr)

    println("排序后的数组: ${arr.joinToString(", ")}")
}