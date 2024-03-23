package com.sunny.pdf.pdfutility.code;

public class TreeLongestZigZag {

    public int treeLongestZigZag(Tree T) {
        // Implement your solution here
        int[] c = new int[1];
        f(T, c);
        return c[0] - 1;
    }

    public int[] f(Tree node, int[] count) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] a = f(node.l, count);
        int[] b = f(node.r, count);
        count[0] = Math.max(count[0], Math.max(1 + a[1], 1 + b[0]));
        return new int[]{1 + a[1], 1 + b[0]};
    }

    public int solution2(Tree T) {
        // Implement your solution here
        return dfs(T).length;
    }

    private int[] dfs(Tree node) {
        if (node == null) return new int[]{-1, -1};
        int[] left = dfs(node.l);
        int[] right = dfs(node.r);
        int max = 0;
        max = Math.max(max, Math.max(Math.max(left[0], left[1]), Math.max(right[0], right[1])));
        max = Math.max(max, left[1] + 1);
        max = Math.max(max, right[0] + 1);
        return new int[]{left[1] + 1, right[0] + 1};
    }

}
