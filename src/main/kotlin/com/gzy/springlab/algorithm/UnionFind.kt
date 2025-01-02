package com.gzy.springlab.algorithm

/**
 * 并查集
 */
class UnionFind(size: Int) {
    private val parent = IntArray(size) { it } // 每个元素的初始父节点是自己
    private val rank = IntArray(size) { 1 }   // 每个集合的初始树高度为 1

    // 查找根节点（路径压缩）
    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x]) // 路径压缩：让当前节点直接指向根节点
        }
        return parent[x]
    }

    // 合并两个集合
    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX != rootY) {
            // 按秩合并：将较小的树挂在较大的树下面
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY
            } else {
                parent[rootY] = rootX
                rank[rootX]++ // 如果高度相同，合并后高度增加 1
            }
        }
    }

    // 判断两个元素是否属于同一个集合
    fun connected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }
}

// 测试并查集
fun main() {
    val uf = UnionFind(10) // 创建包含 10 个元素的并查集 (0 到 9)

    // 合并操作
    uf.union(1, 2)
    uf.union(2, 3)
    uf.union(4, 5)
    uf.union(6, 7)
    uf.union(5, 6)

    // 查询两个元素是否属于同一个集合
    println("1 和 3 是否连接: ${uf.connected(1, 3)}") // 输出: true
    println("4 和 7 是否连接: ${uf.connected(4, 7)}") // 输出: true
    println("1 和 4 是否连接: ${uf.connected(1, 4)}") // 输出: false

    // 查询根节点
    println("元素 3 的根节点是: ${uf.find(3)}")
    println("元素 7 的根节点是: ${uf.find(7)}")
}