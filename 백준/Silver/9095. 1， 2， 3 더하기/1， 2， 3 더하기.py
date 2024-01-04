T = int(input())

nums = []
for _ in range(T):
    nums.append(int(input()))

dp = [0] * (max(nums) + 1)
dp[1] = 1
dp[2] = 2
dp[3] = 4

for x in range(4, len(dp)):
    dp[x] = dp[x - 1] + dp[x - 2] + dp[x - 3]

for n in nums:
    print(dp[n])