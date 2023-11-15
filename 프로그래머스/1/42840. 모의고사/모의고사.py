def solution(answers):
    ONE = [1,2,3,4,5]
    TWO = [2,1,2,3,2,4,2,5]
    THREE = [3,3,1,1,2,2,4,4,5,5]
    scores = [0,0,0,0]
    
    for x in range(len(answers)):
        if answers[x] == ONE[x % len(ONE)]:
            scores[1] += 1
        if answers[x] == TWO[x % len(TWO)]:
            scores[2] += 1
        if answers[x] == THREE[x % len(THREE)]:
            scores[3] += 1
    return [i for i, value in enumerate(scores) if value == max(scores)]