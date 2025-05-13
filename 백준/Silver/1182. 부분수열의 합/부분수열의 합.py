N, S = map(int, input().split())

nums = list(map(int, input().split()))
stack = []
answer = 0

def dfs(start):
    global answer
    if sum(stack) == S and len(stack) > 0:
        answer += 1

    for i in range(start, N):
        stack.append(nums[i])
        dfs(i + 1)
        stack.pop()
dfs(0)
print(answer)