import math

class Solution(object):
    def smallestNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        exp = int(math.log(n, 2))
        result = 0
        for e in range(exp, -1, -1):
            result += 2 ** e
        return result
