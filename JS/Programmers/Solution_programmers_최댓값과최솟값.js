function solution(s) {
  let nums = s.split(' ');
  nums.sort((a, b) => {
    return a - b;
  });
  return nums[0] + ' ' + nums[nums.length - 1];
}
