function solution(distance, rocks, n) {
  rocks.sort(function (a, b) {
    return a - b;
  });

  let gap = [];
  const len = rocks.length;

  gap.push(rocks[0]);
  for (let i = 0; i < len - 1; i++) gap.push(rocks[i + 1] - rocks[i]);
  gap.push(distance - rocks[len - 1]);

  let start = 1,
    end = distance,
    mid = Math.floor((start + end) / 2);

  while (start <= end) {
    let sum = 0,
      count = 0;

    for (let i = 0; i < len + 1; i++) {
      sum += gap[i];
      if (mid > sum) count++;
      else sum = 0;
    }

    if (count > n) end = mid - 1;
    else start = mid + 1;

    mid = Math.floor((start + end) / 2);
  }
  return mid;
}
