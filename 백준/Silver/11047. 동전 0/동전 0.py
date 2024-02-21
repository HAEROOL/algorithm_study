N, target = map(int, input().split())
coins = []

for _ in range(N):
    c = int(input())
    coins.append(c)

answer = 0

for x in range(len(coins) - 1, -1, -1):
    if coins[x] <= target:
        answer += target // coins[x]
        target = target - coins[x] * (target // coins[x])
print(answer)