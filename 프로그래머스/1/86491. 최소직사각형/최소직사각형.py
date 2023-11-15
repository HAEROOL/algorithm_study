def solution(sizes):
    wMax = 0
    hMax = 0
    for x in range(len(sizes)):
        sizes[x].sort()
        if sizes[x][0] > wMax:
            wMax = sizes[x][0]
        if sizes[x][1] > hMax:
            hMax = sizes[x][1]
    return wMax * hMax