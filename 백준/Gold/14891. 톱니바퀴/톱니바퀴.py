from collections import deque


def right(idx,d):
    if idx > 3:
        return
    if magnets[idx - 1][2] != magnets[idx][6]:
        right(idx + 1, -d)
        magnets[idx].rotate(d)
def left(idx, d):
    if idx < 0:
        return
    if magnets[idx + 1][6] != magnets[idx][2]:
        left(idx - 1, -d)
        magnets[idx].rotate(d)
magnets = []

for _ in range(4):
    magnets.append(deque(list(map(int, list(input())))))

K = int(input())

for _ in range(K):
    idx, d = map(int, input().split())
    idx -= 1
    left(idx - 1, -d)
    right(idx + 1, -d)
    magnets[idx].rotate(d)

answer = 0
for x in range(4):
    if magnets[x][0] == 1:
        answer += 2**x
print(answer)