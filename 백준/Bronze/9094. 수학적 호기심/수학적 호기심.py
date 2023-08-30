tc = int(input())

for _ in range(tc):
    count = 0
    n, m = map(int, input().split())
    for a in range(1, n):
        for b in range(a+1, n):
            if (a**2 + b**2 + m) % (a * b) == 0:
                count += 1
    print(count)