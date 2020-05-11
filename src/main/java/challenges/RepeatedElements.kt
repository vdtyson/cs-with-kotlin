package challenges

private fun repeatedElementsSolution(nums: IntArray): String {
    val numMap = hashSetOf<Int>()
    val list = sortedSetOf<Int>()
    
    for(i in nums.indices) {
        when {
            numMap.contains(nums[i]) -> list.add(nums[i])
            else -> numMap.add(nums[i])
        }
    }

    return list.toString()
}