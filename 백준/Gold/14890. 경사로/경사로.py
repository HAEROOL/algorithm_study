n, l = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
result = 0

def pos(now) :
    for j in range(1, n) :
        if abs(now[j] - now[j-1]) > 1 : # 차이가 1이 넘으면 False 반환
            return False
        if now[j] < now[j-1] : # 현재 < 이전 이면 경사로를 만들기 위해 오른쪽을 스캔(낮은 곳에 설치)
            for k in range(l) :
                if j+k >= n or used[j+k] or now[j] != now[j+k] : # 범위가 넘어가거나 이미 설치되어 있거나 높이가 다른 경우 False 반환
                    return False
                if now[j] == now[j+k] : # 높이가 같을 경우 방문 처리
                    used[j+k] = True
        elif now[j] > now[j-1] : # 현재 > 이전 이면 경사로를 만들기 위해 왼쪽을 스캔(낮은 곳에 설치)
            for k in range(l) :
                if j-k-1 < 0 or now[j-1] != now[j-k-1] or used[j-k-1] : # 범위가 넘어가거나 이미 설치되어 있거나 높이가 다른 경우 False 반환
                    return False
                if now[j-1] == now[j-k-1] : # 높이가 같을 경우 방문 처리
                    used[j-k-1] = True
    return True

# 가로 확인
for i in range(n) :
    used = [False for _ in range(n)] # 방문 처리
    if pos(data[i]) :
        result += 1

# 세로 확인
for i in range(n) :
    used = [False for _ in range(n)] # 방문 처리
    if pos([data[j][i] for j in range(n)]) :
        result += 1

print(result)