a = [False, False] + [True for _ in range(4000001)]
primes = []

for x in range(1, len(a)):
    if a[x]:
        primes.append(x)
        for y in range(x*2, len(a), x):
            a[y] = False
N = int(input())

answer = 0
for x in range(0, len(primes)):
    total = 0
    for y in range(x, len(primes)):
        if total + primes[y] < N:
            total += primes[y]
        elif total + primes[y] == N:
            answer += 1
            break
        else:
             break
print(answer)