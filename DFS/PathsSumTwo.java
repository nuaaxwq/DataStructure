package Oct_17_2020;
/*113. 路径总和 II leetcode
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

5
/ \
4   8
/   / \
11  13  4
/  \    / \
7    2  5   1
返回:

[
[5,4,11,2],
[5,8,4,5]
]*/

// tree, dfs
// outdoor root == null
// filter condition root.left == null && root.right == null(leaves node)
// save path when sum == 0;
// time complex O(n) space complex O(h)

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    public int val;
    public TreeNode left, right;

    public TreeNode (int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class PathsSumTwo {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), root, sum);
        return result;
    }

    private void dfs(List<List<Integer>> result, ArrayList<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0){
                list.add(root.val);
                result.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
            return;
        }

        list.add(root.val);
        dfs(result, list, root.left, sum);
        dfs(result, list, root.right, sum);
        list.remove(list.size() - 1);
    }
}
