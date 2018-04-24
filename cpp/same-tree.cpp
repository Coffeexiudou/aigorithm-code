/*
Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
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


//和symmetric-tree基本一样　对应顺序相等即可
class Solution {
public:
    bool isSameTree(TreeNode *p, TreeNode *q) {
        if(!p&&!q)return true;
        return compare(p,q);
    }
private:
    bool compare(TreeNode *node1,TreeNode *node2){
        if(!node1&&!node2)return true;
        if(!node1||!node2)return false;
        if(node1->val!=node2->val) return false;
        return compare(node1->left,node2->left)&&compare(node1->right,node2->right);
    }
};