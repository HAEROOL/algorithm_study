def solution(enroll, referral, seller, amount):
    result = []
    memberRecommender = dict()
    memberProfit = dict()

    for i in range(len(enroll)):
        memberRecommender[enroll[i]] = referral[i]
        memberProfit[enroll[i]] = 0

    for i in range(len(seller)):
        cur = seller[i]
        profit = amount[i]*100
        memberProfit[cur] += amount[i]*100
        while memberRecommender[cur] != '-':
            if profit == 0:
                break
            profit = int(0.1*profit)
            memberProfit[cur] -= profit
            memberProfit[memberRecommender[cur]] += profit
            cur = memberRecommender[cur]    
        if memberRecommender[cur] == '-':
            memberProfit[cur] -= int(profit*0.1)
    for member in enroll:
        result.append(memberProfit[member])
    return result

