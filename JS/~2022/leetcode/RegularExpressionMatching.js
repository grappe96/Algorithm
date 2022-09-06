var isMatch = (s, p) => {
  const sLen = s.length,
    pLen = p.length;
  const dp = new Array(sLen + 1);
  for (let i = 0; i <= sLen; i++) {
    dp[i] = new Array(pLen + 1);
    dp[i].fill(false);
  }

  dp[0][0] = true;
  for (let i = 1; i < pLen; i++)
    if (p[i] === '*' && dp[0][i - 1]) dp[0][i + 1] = true;

  for (let i = 0; i < sLen; i++) {
    for (let j = 0; j < pLen; j++) {
      if (p[j] === '.' || p[j] === s[i]) dp[i + 1][j + 1] = dp[i][j];
      else if (p[j] === '*') {
        if (p[j - 1] !== s[i] && p[j - 1] !== '.')
          dp[i + 1][j + 1] = dp[i + 1][j - 1];
        else
          dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
      }
    }
  }
  return dp[sLen][pLen];
};
