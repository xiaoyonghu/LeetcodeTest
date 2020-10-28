# LeetcodeTest
---
菜就得多看书，多学习

# 刷题

**评价   记住多刷题，多刷题，多刷题！！！！！重要的事情说3遍**

------

### 剑指Offer部分

#### PartitionOne

1. 数组中重复的数字

2. 二维数组中的查找

3. 替换空格

4. 从头到尾打印链表

5. 从建二叉树：

   - 思想：主要的是看如何选择前序和中序的点，很简单

             

#### PartitionFour

44、[ 数字序列中某一位的数字](https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/)  找规律题目

45、[把数组排成最小的数](https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)    创新类型的题目（创新定义规则，但是有数学证明）

46、[把数字翻译成字符串](https://leetcode-cn.com/problems/decode-ways/)      动态规划的题目

47、[礼物的最大值](https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/submissions/) 动态规划（写的一维数组没看懂）

48、[最长不含重复字符的子字符串](https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/) 滑动窗口（涉及一点思路方面的东西）官方给的思路比较清晰，官方的2中思路都已经实现（1、第一种是移动head直到不包含right多对应的值；2、是采用hashmap来存储第i个元素在的位置的下一个位置）

49、[丑数](https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) 后面的数基于前面的数 2,3,5 每次选最小的数，然后移动相应的指针

50、[第一个只出现一次的字符的位置](https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) hashmap，2次遍历   第一次遍历直接把字母和次数统计下来 第二次直接找出次数出现一次的字符

51、[数组中的逆序对]()

---

### Leetcode部分

##### **链表**

[lc 108 将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/)二叉搜索

[lc 109 有序链表转换二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/) 二叉搜索、快慢指针



##### **字符串**

[lc 647 回文子串](https://leetcode-cn.com/problems/palindromic-substrings/)

[lc 214 最短回文串](https://leetcode-cn.com/problems/shortest-palindrome/) KMP Manacher 难受

[lc 557 反转字符串中的单词III](https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/)

[lc 491 最长上升子序列](https://leetcode-cn.com/problems/increasing-subsequences/)  回溯    Rabin-Karp编码



##### **堆**

[lc 239 滑动窗口问题](https://leetcode.com/problems/sliding-window-maximum/) 1、堆  2、二分查找



##### **栈**

[lc 20--有效的括号 (easy)](https://leetcode-cn.com/problems/valid-parentheses/) 



##### **DFS/BFS**

DFS-BFS  [lc 200--岛屿问题](https://leetcode-cn.com/problems/number-of-islands/)   并查集也可以解决

BFS-DFS  [lc 207 课程表](https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/)  邻接表问题   **拓扑排序** 判断此课程安排图是否是 **有向无环图(DAG)** 

BFS-DFS [lc 133 克隆图](https://leetcode-cn.com/problems/clone-graph/)  采用BFS做的



##### **DP**

[lc 5 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)  dp、中心扩散（变体）、Manacher

[lc 72 编辑距离](https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/)

[lc 120  三角形最小路径和](https://leetcode-cn.com/problems/triangle/)

[lc 300  最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/submissions/)  1、dp  2、二分查找

[lc 354 俄罗斯套娃信封问题](https://leetcode-cn.com/problems/russian-doll-envelopes/submissions/)

[lc 152  乘积最大子数组 ](https://leetcode-cn.com/problems/maximum-product-subarray/submissions/)

[lc 121 K为一次的股票买卖](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/submissions/) 非DP解法

[lc 309 最佳买卖股票时机含冷冻期（只需要额外的一维即可） 但是K=1](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/)


[lc 322 零钱兑换  类似爬台阶](https://leetcode-cn.com/problems/coin-change/submissions/)

[lc 337 打家劫舍III](https://leetcode-cn.com/submissions/detail/95025063/) DP思想

[lc 198 打家劫舍 I](https://leetcode-cn.com/problems/house-robber/submissions/)  DP

[lc 213 打家劫舍II](https://leetcode-cn.com/problems/house-robber-ii/submissions/) 环形数组



##### **回溯**

[lc 79 单词搜索][https://leetcode-cn.com/problems/word-search/] 写完可以去看一下212

[lc 46 全排列][https://leetcode-cn.com/problems/permutations/submissions/]

[lc 93 复原IP地址][https://leetcode-cn.com/problems/restore-ip-addresses/]

[lc 679 24点游戏][https://leetcode-cn.com/problems/24-game/]  这个是回溯的增强版



##### **位运算**

需要记住一些常规的位运算的操作

[lc 338 比特位数][https://leetcode-cn.com/problems/counting-bits/] 动态规划的思想，讨论区的人才真是多



##### **字典树**

[lc 212 单词搜索II][https://leetcode-cn.com/problems/word-search-ii/submissions/]  回溯 + 字典树

[lc 336 回文对][https://leetcode-cn.com/problems/palindrome-pairs/submissions/]  字典树/Map  这个评论区的节点我看的想吐





##### **树Tree**

[lc 98 验证二叉搜索树][https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/]

[lc 101 对称的二叉树][https://leetcode-cn.com/problems/symmetric-tree/submissions/]

[lc 538 把二叉树搜索树转换为累加树][https://leetcode-cn.com/problems/convert-bst-to-greater-tree/] 变形的中序遍历

[lc 94 二叉树的中序遍历][https://leetcode-cn.com/problems/binary-tree-inorder-traversal/]递归、迭代（栈）

[lc 99 恢复二叉搜索树][https://leetcode-cn.com/problems/recover-binary-search-tree/] 中序遍历

[lc 124 二叉树中的最大路径和][https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/]

[lc 543 二叉树的直径][https://leetcode-cn.com/problems/diameter-of-binary-tree/]

[lc 104 二叉树的最大深度][https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/submissions/]

[lc 111 二叉树的最小深度][https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/]

[c 105 前序、中序 构造二叉树][https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/] 这个lc什么鸡毛的测试，我吐了

[lc 102 二叉树的层次遍历][https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/]  BFS/DFS

[lc 236 二叉树的最近公共祖先 ][https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/]

[lc 235 二叉搜索树的最近公共祖先][https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/]

[lc 96 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/submissions/)  卡特兰数  G(n)=G(0)∗G(n−1)+G(1)∗G(n−2)+...+G(n−1)∗G(0)

[lc 14 二叉树展开为一个单链表][https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/submissions/] 变形的后序递归

[lc 226 翻转二叉树][https://leetcode-cn.com/problems/invert-binary-tree/submissions/]  先序遍历 

[lc 617 合并二叉树][https://leetcode-cn.com/problems/merge-two-binary-trees/] 先序遍历

[lc 297 二叉树的序列化与反序列化][https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/]  先序/层次遍历



##### **Map**

[lc 1 l两数之和][https://leetcode-cn.com/problems/two-sum/submissions/]

[lc 15 三数之和 ][https://leetcode-cn.com/problems/3sum/]  非map类型



##### **递归**

[lc 22 括号生成][https://leetcode-cn.com/submissions/detail/95359447/]



##### **前缀和**

[lc 560 和为K的子数组][https://leetcode-cn.com/problems/subarray-sum-equals-k/]

[lc 437 路径总结III  前缀和][https://leetcode-cn.com/problems/path-sum-iii/] 回溯+前缀树



##### 其他

[lc 43 字符串相乘][https://leetcode-cn.com/problems/multiply-strings/] 这题目真是耗费我的时间

[lc 146  LRU][https://leetcode-cn.com/problems/lru-cache/submissions/]




### 各种排序算法

#### 快排

```
/*
** 这是快排的partition函数
*/
public static void quickSort(int[] L) {
   QuickSort(L, 0, L.length - 1);
}

public static void QuickSort(int[] L, int low, int high) {
    int pivot;
    if (low < high) {
    
    //将L[low,high]一分为二,算出枢轴值pivot,该值得位置固定,不用再变化
    pivot = partition(L, low, high);

    //对两边的数组分别排序
    QuickSort(L, low, pivot - 1);
    QuickSort(L, pivot + 1, high);
    }
}

private int partition(int[] nums,int l,int r){
	int p = nums[l];//以最左边的为基准
	int i=l,j=r+1;
	while(true){
		while(i!=r && nums[++i]<p);//找到一个大于等于p,注意条件i!=r
		while(j!=l && nums[--j]>p);//找到一个小于等于p,注意条件j!=l
		if(i>=j)
			break;
		swap(nums,i,j);
	}
	swap(nums,l,j);//注意这里是l和j的位置交换
	return j;
}

/**
* 交换2元素
*/
private void swap(int[] nums,int i,int j){
 	int t=nums[i];
 	nums[i]=nums[j];
 	nums[j]=t;
}


/*
** 这是来自极客时间的笔记
*/
递推公式：
quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1, r)
终止条件：
p >= r

// 快速排序，A 是数组，n 表示数组的大小
quick_sort(A, n) {
 quick_sort_c(A, 0, n-1)
}
// 快速排序递归函数，p,r 为下标
quick_sort_c(A, p, r) {
 if p >= r then return   //3步曲 1、先判断结束条件

 q = partition(A, p, r) // 获取分区点 2、进行运算
 quick_sort_c(A, p, q-1)		3、返回值
 quick_sort_c(A, q+1, r)
}

快速排序的性能分析：

1.时间复杂度分析：T(n) 在大部分情况下的时间复杂度都可以做到 O(nlogn)，只有在极端（数组完全有序）情况下，才会退化到 O(n2 )。

2.空间复杂度分析：原地排序算法

3.快速排序并不是一个稳定的排序算法
```



#### 归并排序

```
递推公式：
merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
终止条件：
p >= r 不用再继续分解

// 归并排序算法, A 是数组，n 表示数组大小
merge_sort(int[] arr, n) {
 merge_sort_c(arr, 0, n-1)
}
// 递归调用函数
merge_sort_c(int[] arr,int l,int h) {
 // 递归终止条件
 if l >= h then return
 // 取 l 到 h 之间的中间位置 m
 m = (l+h) / 2
 // 分治递归
 merge_sort_c(arr, l, m)
 merge_sort_c(arr, m+1, h)
 // 将 A[p...q] 和 A[q+1...r] 合并为 A[p...r]
 merge(arr,l,m,h)
}

//merge函数的伪代码  可以用哨兵模式简化
merge(int[] arr,int start,int mid,int end) {
 int i = start，j = mid+1，k = 0 // 初始化变量 i, j, k
 int[] tmp := new int[end-start+1] // 申请一个大小跟 A[start-end] 一样的临时数组
 while (i<=mid AND j<=end){
 if arr[i] <= arr[j] {
 	tmp[k++] = arr[i++]; // i++ 等于 i:=i+1
 } else {
 	tmp[k++] = arr[j++];
 		}				//求逆序对的时候可以在这里进行计数
 }

 // 判断第一个数组是否有剩余
while(i<=mid){
	tmp[k++]=arr[i++];
}

 // 判断第二个数组是否有剩余
while(j<=mid){
	tmp[k++]=arr[j++];
}

 // 将 tmp 中的数组拷贝回 A[start end]
for(int l=0;l<tmp.length;i++){
	arr[start+l]=tmp[l];
}
}
```



#### 二分查找

```
left，right =0, len(array) -1
//注意结束条件
while left<=right:
	mid = left + (right - left) >1
	if array[mid] = target;
		break or return result
	elif array[mid] < target:
		left = mid +1
	else
		right = mid - 1
		
//
```



### Tree

#### BFS

```
查找一个数是否存在，应用特性可以直接进行左右选择
void BST(TreeNode root, int target) {
    if (root.val == target)
        // 找到目标，做点什么
    if (root.val < target) 
        BST(root.right, target);
    if (root.val > target)
        BST(root.left, target);
}

删除操作
TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    if (root.val == key) {
        // 这两个 if 把情况 1 和 2 都正确处理了
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        // 处理情况 3
        TreeNode minNode = getMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, minNode.val);
    } else if (root.val > key) {
        root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
        root.right = deleteNode(root.right, key);
    }
    return root;
}

TreeNode getMin(TreeNode node) {
    // BST 最左边的就是最小的
    while (node.left != null) node = node.left;
    return node;
} 



```

[参照labuladong的BST的一系列操作](https://github.com/labuladong/fucking-algorithm/blob/master/数据结构系列/二叉搜索树操作集锦.md)



#### Pre-In-Post

```
二叉树的前-中-后序  通用框架
void traverse(TreeNode root) {
    // 前序遍历
    traverse(root.left)
    // 中序遍历
    traverse(root.right)
    // 后序遍历
}



//二叉树的前序遍历-迭代算法模板

栈S;
p= root;
while(p || S不空){
    while(p){
        访问p节点；
        p的右子树入S;  //访问左子树之前，先将右子树入栈
        p = p的左子树;
    }
    p = S栈顶弹出;
}


//二叉树中序遍历的-迭代算法模板
栈S;
p= root;
while(p || S不空){
    while(p){
        p入S;
        p = p的左子树;
    }
    p = S.top 出栈;
    访问p;
    p = p的右子树;
}


//二叉树后序遍历的-迭代算法模板
//每到一个节点 A，就应该立即访问它。 然后将左子树压入栈，再次遍历右子树。
栈S;
p= root;
while(p || S不空){
    while(p){
        访问p节点；
        p的左子树入S;
        p = p的右子树;
    }
    p = S栈顶弹出;
}
结果序列逆序;

```



### 多叉树

```
void traverse(TreeNode root) {
    for (TreeNode child : root.childern)
        // 前序遍历需要的操作
        traverse(child);
        // 后序遍历需要的操作
}
```





### 遍历：

#### BFS

```
BFS通用模板
def BFS(graph，start,end):
	//BFS实现一般都需要用到一个队列
	queue = []
	
	queue.append([start])
	//个人感觉这里多加了一次root节点
	visited.add(start)
	
	//1、判断queue
	while queue：
		//2 取出最前面的节点
		node = queue.pop()
		
		//3、process current node
		process（node）
		
		//4、generated_nodes
		nodes = generate_related_nodes(node)
		
		//5、把相关的节点放入queue里面
		queue.push(nodes)
		
	....
	
	
需要记层数的模板
level = 0
while queue 不空：
    size = queue.size()
    while (size --) {
        cur = queue.pop()
        for 节点 in cur的所有相邻节点：
            if 该节点有效且未被访问过：
                queue.push(该节点)
    }
    level ++;

```



#### DFS

```
DFS模板
visited = set()

def dfs(node,visited):
	//1、做标记
	visited.add(node)
	
	//2、process current node here
	...
	//3、处理子节点
	for next_node in node.chirldren():
		if not next_node in visited:
			//4、递归调用子节点
			self.dfs(next_node,visited)
```



### DP

```
思路：
	1、定义状态变量
	2、状态转移方程

1、状态定义（状态定义的好坏决定题目是否能正常解决），一般一维（情况）不能解决那就增加维度（增加额外的情况）
dp = new int [m+1][n+1]

2、初始状态定义
dp[0][0] = x
dp[0][1] = y  //这里只是模拟，实际情况比这个复杂的多

//DP状态的推导
for i=0 i<= n; ++i{
	for j=0; j<=m; ++j{
		//1、发生状态的条件
		//2、状态的转移方程
		dp[i][j] = min{dp[i-1][j],dp[i][j-1]}  //这里的状态转移方程只是一个示范
	}
}

return dp[m][n];  //这里的返回值只是一个示范


```



### 递归

```
//很重要，暴力解法很重要
def recursion（level， param1, param2...）:
	//1、终止条件
	if level>Max_level:
		print result
		return
		
	//2、处理逻辑在当前层
	process(level,data...)
	
	//3、调用下一层递归
	self.recursion(level+1,param1,param2....)
	
	//4、reverse the current level status if needed
	reverse_state(level) //看具体情况去进行要不要

```



### 回溯

```
//和上面的递归一样
//结束条件可以用 i， list.size等，看具体情况
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
 

```



### 位运算

```
比较常用的位运算
X & 1 ===1 OR == 0 判断奇偶

X = X & (X - 1) --> 清楚最低位的1

X & (-X) --> 得到最低位的1



```



![1595168566259](C:\Users\xiaoyong\AppData\Roaming\Typora\typora-user-images\1595168566259.png)

![1595168112967](C:\Users\xiaoyong\AppData\Roaming\Typora\typora-user-images\1595168112967.png)





### Manacher

```
马拉车算法
//只看过B站视频


```



### KMP

```
KMP算法
//只看过B站视频


```



### 串哈希算法

```
Rabin-Karp 编码
```


##### LIS问题

```
/* 返回 nums 中 LIS 的长度 */
public int lengthOfLIS(int[] nums) {
    int size = 0, n = nums.length;
    int[] top = new int[n];
    for (int i = 0; i < n; i++) {
        // 要处理的扑克牌
        int poker = nums[i];
        int left = 0, right = size;
        // 二分查找插入位置
        while (left < right) {
            int mid = (left + right) / 2;
            if (top[mid] >= poker)
                right = mid;
            else
                left = mid + 1;
        }
        if (left == size) size++;
        // 把这张牌放到牌堆顶
        top[left] = poker;
    }
    // 牌堆数就是 LIS 长度
    return size;
}


//第二种解法
    private int lengtOfLIS(int[] height) {
        int[] tails = new int[height.length];
        int size = 0;
        for (int x : height) {
            int i = Arrays.binarySearch(tails, 0, size, x);
            if (i < 0)
                i = -(i + 1);//这里i的值就为-1
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

```





**匈牙利算法**用来求匹配对的问题
