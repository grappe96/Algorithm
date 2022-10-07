function solution(n) {
  let dp = [0],
    target = n / 2,
    num = 1000000007;

  if (n % 2 != 0) return 0;

  dp.push(3); // n = 2
  for (let i = 2; i <= target; i++) {
    dp[i] = dp[i - 1] * dp[1] + 2; // 직전 타일에 두 칸이 추가 된 경우 + 양 끝을 제외하고 가로로 채운 경우
    for (let j = i - 2; j >= 1; j--) dp[i] += dp[j] * 2; // 양 끝을 제외하고 가로로 채운 경우는 나머지 칸을 앞 뒤로 붙인 경우가 동일하므로 한 번 더 더해준다
    dp[i] %= num;
  }

  return dp[target];
}
