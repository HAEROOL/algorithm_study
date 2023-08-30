N, K = map(str, input().split())
count = 0

for hour in range(0, int(N) + 1):
    if hour < 10:
        hour = '0'+str(hour)
    for min in range(0, 60):
        if min < 10:
            min = '0'+str(min)
        for sec in range(0, 60):
            if sec < 10:
                sec = '0'+str(sec)
            if K in str(hour) or K in str(min) or K in str(sec):
                count += 1

print(count)