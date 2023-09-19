N = int(input())

nums = list(map(int, input().split()))
op = list(map(int, input().split()))

maximum = -1e9
minimum = 1e9

def dfs(depth, total, plus, minus, multi, div):
    global maximum, minimum
    if depth == N:
        maximum = max(total, maximum)
        minimum = min(total, minimum)

    if plus:
        dfs(depth + 1, total + nums[depth], plus - 1, minus, multi, div)
    if minus:
        dfs(depth + 1, total - nums[depth], plus, minus - 1, multi, div)
    if multi:
        dfs(depth + 1, total * nums[depth], plus, minus, multi - 1, div)
    if div:
        dfs(depth + 1, int(total / nums[depth]), plus, minus, multi, div - 1)
dfs(1, nums[0], op[0],op[1],op[2],op[3])

print(maximum)
print(minimum)