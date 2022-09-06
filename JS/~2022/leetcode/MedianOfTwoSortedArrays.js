var findMedianSortedArrays = (nums1, nums2) => {
  const total = nums1.concat(nums2).sort((a, b) => {
    return a - b;
  });
  const len = total.length;
  const idx = Math.ceil(len / 2);

  if (len % 2 === 0) return (total[idx - 1] + total[idx]) / 2;
  else return total[idx - 1];
};
