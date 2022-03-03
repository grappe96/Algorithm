var twoSum = function (nums, target) {
  let answer = [];
  let hashMap = new Map();
  const len = nums.length;

  for (let i = 0; i < len; i++) {
    const diff = target - nums[i];

    if (hashMap.has(diff)) {
      answer.push(i);
      answer.push(hashMap.get(diff));
      break;
    }
    hashMap.set(nums[i], i);
  }

  return answer;
};
