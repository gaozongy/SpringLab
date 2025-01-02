package com.gzy.springlab.algorithm

/**
 * 二分搜索树
 */
class BinarySearchTree<T : Comparable<T>> {

    private var root: Node<T>? = null

    // 定义节点
    private data class Node<T>(
        var value: T,
        var left: Node<T>? = null,
        var right: Node<T>? = null
    )

    // 插入元素
    fun insert(value: T) {
        root = insertRecursively(root, value)
    }

    private fun insertRecursively(node: Node<T>?, value: T): Node<T> {
        if (node == null) {
            return Node(value) // 如果为空位置，则创建新节点
        }
        if (value < node.value) {
            node.left = insertRecursively(node.left, value) // 插入左子树
        } else if (value > node.value) {
            node.right = insertRecursively(node.right, value) // 插入右子树
        }
        return node
    }

    // 查找元素
    fun contains(value: T): Boolean {
        return containsRecursively(root, value)
    }

    private fun containsRecursively(node: Node<T>?, value: T): Boolean {
        if (node == null) return false
        return when {
            value < node.value -> containsRecursively(node.left, value) // 查找左子树
            value > node.value -> containsRecursively(node.right, value) // 查找右子树
            else -> true // 找到元素
        }
    }

    // 中序遍历（递归方式）
    fun inOrderTraversal(): List<T> {
        val result = mutableListOf<T>()
        inOrderTraversalRecursively(root, result)
        return result
    }

    private fun inOrderTraversalRecursively(node: Node<T>?, result: MutableList<T>) {
        if (node != null) {
            inOrderTraversalRecursively(node.left, result) // 遍历左子树
            result.add(node.value) // 访问当前节点
            inOrderTraversalRecursively(node.right, result) // 遍历右子树
        }
    }
}

// 测试二分搜索树
fun main() {
    val bst = BinarySearchTree<Int>()
    
    // 插入元素
    bst.insert(50)
    bst.insert(30)
    bst.insert(70)
    bst.insert(20)
    bst.insert(40)
    bst.insert(60)
    bst.insert(80)
    
    // 打印中序遍历结果
    println("中序遍历结果: ${bst.inOrderTraversal()}")
    
    // 查找元素
    println("是否包含 40: ${bst.contains(40)}")
    println("是否包含 25: ${bst.contains(25)}")
}