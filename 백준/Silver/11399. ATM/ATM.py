N = int(input())

nums = list(map(int, input().split()))
nums.sort()
dp = []
dp.append(nums[0])
for x in range(1, N):
    dp.append(nums[x] + dp[x - 1])
print(sum(dp))