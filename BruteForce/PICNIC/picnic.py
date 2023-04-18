N  = int(input())
answer = []
def pairing(finished):
    if all(finished):
        return 1

    firstPeople = finished.index(False)
    count = 0

    for i in range(firstPeople+1, len(finished)):
        if not finished[i] and areFreind[firstPeople][i]:
            finished[i] = True
            finished[firstPeople] = True
            count += pairing(finished)
            finished[i] = False
            finished[firstPeople] = False
    return count

for _ in range(N):
    temp = input().split()
    n = int(temp[0])
    m = int(temp[1])
    pairs = []
    line = list(map(int, input().split()))

    for i in range(0, m*2, 2):
        pairs.append(line[i:i+2])
    
    areFreind = [[False for _ in range(n)] for _ in range(n)]

    for pair in pairs:
        areFreind[pair[0]][pair[1]] = True
        areFreind[pair[1]][pair[0]] = True
    
    finished = [False for _ in range(n)]
    
    answer.append(pairing(finished))

for x in answer:
    print(x)
