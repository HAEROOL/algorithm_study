def solution(cap, n, deliveries, pickups):
    deliveries = deliveries[::-1]
    pickups = pickups[::-1]
    answer = 0
    
    targetDil = 0
    targetPick = 0
    

    for i in range(n):
        targetDil += deliveries[i]
        targetPick += pickups[i]
        while targetDil > 0 or targetPick > 0:
            targetDil -= cap
            targetPick -= cap
            answer += (n - i) * 2

    return answer