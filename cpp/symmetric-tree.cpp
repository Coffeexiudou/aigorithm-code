/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:
    1
   / \
  2   2
   \   \
   3    3
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

//递归版本 
class Solution {
public:
    bool isSymmetric(TreeNode *root) {
        if(!root)return true;
        return compare(root->left,root->right);
    }
private:
    bool compare(TreeNode *node1,TreeNode *node2){
        if(!node1&&!node2)return true;
        if(!node1||!node2)return false;
        if(node1->val!=node2->val)return false;
        return compare(node1->left,node2->right)&&compare(node1->right,node2->left);
    }
};

//非递归版本
class Solution {
public:
    bool isSymmetric(TreeNode *root) {
        if(!root)return true;
        queue<TreeNode* > q;
        q.push(root->left);
        q.push(root->right);
        while(!q.empty()){
            int n = q.size();
            while(n){
                TreeNode* left = q.front();
                q.pop();
                TreeNode* right = q.front();
                q.pop();
                n-=2;
                if(!left&&!right)continue; 
                if(!left||!right)return false;
                if(left->val != right->val)return false;
                 
                q.push(left->left);
                q.push(right->right);
                q.push(left->right);
                q.push(right->left);
            }
        }
        return true;
    }
};
