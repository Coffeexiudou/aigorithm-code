/*
Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

//递归版本

class Solution {
public:
    int run(TreeNode *root) {
        if(!root)return 0;
        int l = run(root->left);
        int r = run(root->right);
        if(l==0||r==0)return 1+l+r;　//如果只是单侧子树，求得是最大深度。
        return 1+(l<r?l:r);
    }
};


//非递归版　思路：层序遍历，遇到第一个叶子节点即为最小深度
class Solution {
public:
    int run(TreeNode *root) {
       if(!root)return 0;
        queue<TreeNode *> q;
        q.push(root);
        int min = 1;
        TreeNode* last;
        TreeNode* now;
        last = now = root;
        while(!q.empty()){
            now = q.front();
            q.pop();
            int size = q.size();
            if(now->left)q.push(now->left);
            if(now->right)q.push(now->right);
            if(q.size()-size==0)break; //若size没变，则为叶子节点，跳出循环
            if(last==now){    //若该结点是这一层最后一个，则深度加１
                min++;
                if(q.size())last=q.back();//若队列里还有元素，则取出该结点下这一层最后一个元素
            }
            
        }
        return min;
    }
};