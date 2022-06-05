class DPSolution {

    fun jump(nums: IntArray): Int {
        val dp = IntArray(nums.size) { Int.MAX_VALUE - 1 }
        dp[nums.size - 1] = 0

        for (i in nums.size - 2 downTo  0) {
            var localMin = Int.MAX_VALUE - 1
            for (j in nums[i] downTo 1) {
                if (i + j < nums.size) localMin = localMin.coerceAtMost(dp[j + i] + 1)
            }
            dp[i] = localMin
        }
        return dp[0]
    }
}