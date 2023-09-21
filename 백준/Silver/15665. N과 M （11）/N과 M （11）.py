N, M = map(int, input().split())

nums = list(map(int, input().split()))

nums.sort()

s = []

def dfs():
    if len(s) == M:
        print(*s)
        return
    overlap = 0
    for i in range(0, N):
        if overlap != nums[i]:
            s.append(nums[i])
            overlap = nums[i]
            dfs()
            s.pop()

dfs()