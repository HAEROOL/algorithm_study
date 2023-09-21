N, M = map(int, input().split())

nums = list(map(int, input().split()))
nums.sort()

s = []

def dfs():
    if len(s) == M:
        print(*s)
        return
    for i in range(0, N):
        if nums[i] not in s:
            s.append(nums[i])
            dfs()
            s.pop()

dfs()