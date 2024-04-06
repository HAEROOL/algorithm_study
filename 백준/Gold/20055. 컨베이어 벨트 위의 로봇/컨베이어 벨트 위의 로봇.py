from collections import deque

n, k = map(int, input().split())

belt = deque(list(map(int, input().split())))

for i in range(2 * n):
    belt[i] = [0, belt[i]]

turn = 1
total = 0
while True:
    if total >= k:
        print(turn - 1)
        break
    #1단계
    belt.rotate()
    if belt[n - 1][0] == 1:
        belt[n - 1][0] = 0
    #2단계
    for x in range(n - 2, -1, -1):
        if belt[x][0] == 1 and belt[x + 1][0] == 0 and belt[x + 1][1] >= 1:
           belt[x + 1][0] = 1
           belt[x + 1][1] -= 1
           if belt[x + 1][1] == 0:
               total += 1
           belt[x][0] = 0
           if x + 1 == n - 1:
               belt[x + 1][0] = 0
    #3단계
    if belt[0][1] >= 1:
        belt[0][0] = 1
        belt[0][1] -= 1
        if belt[0][1] == 0:
            total += 1
    turn += 1
 
