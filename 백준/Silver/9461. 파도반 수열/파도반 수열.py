tc = int(input())


P = [0 for i in range(101)]
P[1] = 1
P[2] = 1
P[3] = 1
for x in range(4, 101):
    P[x] = P[x-3] + P[x-2]

for _ in range(tc):
    n = int(input())
    print(P[n])

