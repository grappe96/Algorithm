var strStr = function (haystack, needle) {
  if (needle === '') return 0;
  const len = needle.length,
    last = haystack.length - len;
  for (let i = 0; i <= last; i++) {
    if (haystack.substring(i, i + len) === needle) return i;
  }
  return -1;
};
