N, M, K = map(int, input().split())

A = [[{'trees':[]} for _ in range(N)] for _ in range(N)]
MEALS = [[0 for _ in range(N)] for _ in range(N)]

for x in range(N):
    row = list(map(int, input().split()))
    for y in range(N):
        A[x][y]['meal'] = 5
        MEALS[x][y] = row[y]
for _ in range(M):
    x, y, age = map(int, input().split())
    A[x - 1][y - 1]['trees'] += [age]
    
def spring():
    for x in range(N):
        for y in range(N):
            block = A[x][y]
            trees = block['trees']
            meal = block['meal']
            temp = []
            for z in range(len(trees)):
                if meal - trees[z] >= 0:
                    meal -= trees[z]
                    trees[z] += 1
                else:
                    temp = trees[z:]
                    trees = trees[:z]
                    break
            A[x][y]['trees'] = trees
            A[x][y]['meal'] = meal
            A[x][y]['dead'] = temp

def summer():
    for x in range(N):
        for y in range(N):
            for tree in A[x][y]['dead']:
                A[x][y]['meal'] += tree // 2
                A[x][y]['dead'] = []

def fall():
    for x in range(N):
        for y in range(N):
            for tree in A[x][y]['trees']:
                if tree > 0 and tree % 5 == 0:
                    dx = [-1, -1, -1, 0, 0, 1, 1, 1]
                    dy = [-1, 0, 1, -1, 1, -1, 0, 1]
                    for i in range(8):
                        nx = x + dx[i]
                        ny = y + dy[i]
                        if 0 <= nx < N and 0 <= ny < N:
                            A[nx][ny]['trees'].insert(0, 1)

def winter():
    for x in range(N):
        for y in range(N):
            A[x][y]['meal'] += MEALS[x][y]

for a in range(K):
    spring()
    summer()
    fall()
    winter()

answer = 0
for x in range(N):
    for y in range(N):
        answer += len(A[x][y]['trees'])
print(answer)