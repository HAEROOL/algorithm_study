n = int(input())
nums = []
for x in range(1, n + 1):
    nums.append(int(input()))

dp = [0] * (n + 1)
dp[1] = nums[0]
if n > 1: 
    dp[2] = nums[1] + dp[1]


for x in range(3, n + 1):
    dp[x] = max(dp[x - 2] + nums[x - 1], nums[x - 1] + nums[x - 2] + dp[x - 3], dp[x - 1])
print(max(dp))