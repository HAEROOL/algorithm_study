M, N = map(int, input().split())

prime = []
a = [False, False] + [True for _ in range(1000000)]

for x in range(2, len(a)):
    if a[x]:
        prime.append(x)
        for y in range(x * 2, len(a), x):
            a[y] = False

for x in range(M, N + 1):
    if a[x]:
        print(x)