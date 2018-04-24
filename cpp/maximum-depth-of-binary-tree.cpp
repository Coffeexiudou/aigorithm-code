/*
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
//非递归版本
class Solution {
public:
    int maxDepth(TreeNode *root) {
        if(!root) return 0;
 		int max = 0;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            max++;
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode* t = q.front();
                q.pop();
                if(t->left)q.push(t->left);
                if(t->right)q.push(t->right);
            }
        }
        return max;
    }
};
//递归版本
class Solution {
public:
    int maxDepth(TreeNode *root) {
        if(root==NULL)
        return 0;
        int ldepth = maxDepth(root->left);
        int rdepth = maxDepth(root->right);
        return 1+(ldepth>rdepth?ldepth:rdepth);
    }
};
