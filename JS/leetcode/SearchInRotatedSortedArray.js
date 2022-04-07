var search = function (nums, target) {
  let left = 0,
    right = nums.length - 1;
  const MAX = Number.MAX_SAFE_INTEGER;
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    const num =
      nums[mid] < nums[0] === target < nums[0]
        ? nums[mid]
        : nums[mid] < target
        ? MAX
        : -MAX;

    if (num < target) left = mid + 1;
    else if (num > target) right = mid - 1;
    else return mid;
  }

  return -1;
};
