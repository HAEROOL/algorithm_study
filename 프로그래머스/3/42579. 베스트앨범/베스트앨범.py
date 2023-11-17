def solution(genres, plays):
    answer = []
    songs = {}
    for x in range(len(genres)):
        if genres[x] not in songs:
            songs[genres[x]] = {'song':[(x, plays[x])], 'total': plays[x]}
        else:
            songs[genres[x]]['song'] += [(x, plays[x])]
            songs[genres[x]]['total'] += plays[x]
    songs = sorted(songs.items(), key = lambda x : x[1]['total'], reverse=True)
    for x in range(len(songs)):
        songs[x][1]['song'] = sorted(songs[x][1]['song'], key = lambda x : x[1], reverse=True)
        for y in range(2):
            if len(songs[x][1]['song']) == 1:
                answer.append(songs[x][1]['song'][0][0])
                break
            answer.append(songs[x][1]['song'][y][0])
    return answer