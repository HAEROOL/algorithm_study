import heapq

def solution(scoville, K):
    answer = 0
    heap = scoville
    heapq.heapify(heap)
    while heap[0] < K:
        if len(heap) <= 1:
            return -1
        a = heapq.heappop(heap)
        b = heapq.heappop(heap)
        answer += 1
        heapq.heappush(heap, a + b*2)
    return answer