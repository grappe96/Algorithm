var removeDuplicates = function (nums) {
  let len = nums.length,
    idx = 0;

  for (let i = 1; i < len; i++) {
    if (nums[idx] === nums[i]) continue;
    else if (i < len - 1 && nums[i] === nums[i + 1]) continue;

    nums[++idx] = nums[i];
  }

  return idx + 1;
};

console.log(removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 4]));
