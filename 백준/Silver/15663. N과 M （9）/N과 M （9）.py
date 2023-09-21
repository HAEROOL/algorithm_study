N, M = map(int, input().split())

nums = list(map(int, input().split()))
nums.sort()
visited = [False for _ in range(N)]

s = []

def dfs():
    if len(s) == M:
        print(*s)
        return
    overlap = 0
    for i in range(N):
        if not visited[i] and overlap != nums[i]:
            s.append(nums[i])
            visited[i] = True
            overlap = nums[i]
            dfs()
            s.pop()
            visited[i] = False

dfs()