var maxArea = function (height) {
  let lIdx = 0,
    rIdx = height.length - 1,
    left = height[lIdx],
    right = height[rIdx],
    max = (rIdx - lIdx) * Math.min(left, right);
  while (lIdx < rIdx) {
    if (left < right) {
      while (left >= height[lIdx]) lIdx++;
      left = height[lIdx];
    } else {
      while (right >= height[rIdx]) rIdx--;
      right = height[rIdx];
    }
    if (lIdx < rIdx) max = Math.max(max, (rIdx - lIdx) * Math.min(left, right));
    console.log('lIdx: ', lIdx, 'rIdx: ', rIdx);
  }

  return max;
};

console.log(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]));
console.log(maxArea([1, 1]));
console.log(maxArea([0, 0, 1, 1]));
console.log(maxArea([2, 1, 9, 0, 0, 9, 1, 2]));
