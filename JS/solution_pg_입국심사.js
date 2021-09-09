function solution(n, times) {
  times.sort((a, b) => {
    return a - b;
  });
  let start = 1,
    end = times[times.length - 1] * n,
    min = end;
  while (start <= end) {
    let mid = Math.floor((start + end) / 2);
    let count = 0;

    for (let time of times) count += Math.floor(mid / time);

    if (count < n) start = mid + 1;
    else {
      min = Math.min(min, mid);
      end = mid - 1;
    }
  }
  return min;
}
