N = int(input())

lengths = list(map(int, input().split()))
oils = list(map(int, input().split()))

answer = oils[0] * lengths[0]

minCost = oils[0]

for x in range(1, N-1):
    if minCost > oils[x]:
        minCost = oils[x]
    answer += minCost * lengths[x]
print(answer)