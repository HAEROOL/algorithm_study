N, M = map(int, input().split())

nums = list(map(int, input().split()))
nums.sort()

s = []

def dfs(x):
    if len(s) == M:
        print(*s)
        return
    for i in range(x, N):
        s.append(nums[i])
        dfs(i)
        s.pop()

dfs(0)