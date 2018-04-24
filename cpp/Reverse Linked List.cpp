/*
Reverse a singly linked list.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

 //头插法
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(!head||!head->next) return head;
        ListNode* cur = head;
        head = NULL;
        ListNode* temp;
        while(cur){
            temp = cur->next;
            cur->next = head;
            head = cur;
            cur = temp;
        }
        return head;
        
    }
};


class Solution {
public:
    ListNode* reverseList(ListNode* head) {
      if(!head||!head->next) return head;
      ListNode* pre = head;
      ListNode* cur = head->next;
      ListNode* rear;
      while(cur){
          rear = cur->next;
          cur->next = pre;
          pre = cur;
          cur = rear;
      }
      head->next = NULL;
      head = pre;
      return head;
    }
};