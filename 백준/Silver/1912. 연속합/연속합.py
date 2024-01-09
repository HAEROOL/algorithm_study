n = int(input())

nums = list(map(int, input().split()))


for x in range(1, len(nums)):
    nums[x] = max(nums[x], nums[x] + nums[x-1])

print(max(nums))