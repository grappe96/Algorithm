var threeSum = function (nums) {
  nums = nums.sort((a, b) => {
    return a - b;
  });
  const len = nums.length,
    answer = [];
  for (let i = 0; i < len - 2; i++) {
    if (i > 0 && nums[i - 1] === nums[i]) continue;
    let j = i + 1,
      k = len - 1,
      opposite = -nums[i];
    while (j < k) {
      if (nums[j] + nums[k] === opposite) {
        answer.push([nums[i], nums[j], nums[k]]);
        while (j < --k && nums[k] === nums[k + 1]);
        while (++j < k && nums[j - 1] === nums[j]);
      } else if (nums[j] + nums[k] > opposite) k--;
      else j++;
    }
  }
  return answer;
};

console.log(threeSum([-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4]));
