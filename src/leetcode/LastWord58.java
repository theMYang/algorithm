package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


public class LastWord58 {
	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	    
	    public String toString() {
			String res = "";
			ListNode tmp = this;
			while(tmp!=null) {
				res += tmp.val;
				res += " ";
				tmp = tmp.next;
			}
			return res;
		}
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)   return head;
        ListNode point = head;
        int len = 1;
        while(point.next != null){
            len++;
            point = point.next;
        }
        ListNode last = point;
        
        k = (len-(k%len))%len;
        
        
        point.next = head;
        while(k-->0){
            point = point.next;
        }
        ListNode res = point.next;
        point.next = null;
        last.next = head;
        return res;
    }
	
	
	
	public static void main(String[] args){
//		String[] chars2 = {"4", "13", "5", "*", "+"};
		HashMap<Integer, String> map = new HashMap<>();
		map.put(2, "qwe");
		map.put(0, "asd");
		map.put(1, "zxc");
		map.put(8, "rty");
//		for (Entry<Integer, String> i : map.entrySet()) {
//			System.out.println(i.getKey());
//			System.out.println(i.getValue());
//		}
//		Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
//		while(iterator.hasNext()) {
//			Entry<Integer, String> entry = iterator.next();
//			System.out.println(entry.getKey());
//			System.out.println(entry.getValue());
//		}
		for(Integer i : map.keySet()) {
			System.out.println(i);
			System.out.println(map.get(i));
		}
		
		
		
		
		Integer aInteger;
		LastWord58 a = new LastWord58();
		ListNode aListNode  = new ListNode(1);
		ListNode bListNode  = new ListNode(2);
		ListNode cListNode  = new ListNode(3);
		ListNode dListNode  = new ListNode(4);
		ListNode eListNode  = new ListNode(5);
		ListNode fListNode  = new ListNode(7);
		ListNode gListNode  = new ListNode(7);
//		ListNode hListNode  = new ListNode(8);
		aListNode.next = bListNode;
		bListNode.next = cListNode;
		cListNode.next = dListNode;
		dListNode.next = eListNode;
//		eListNode.next = fListNode;
//		fListNode.next = gListNode;
//		gListNode.next = hListNode;
//		ListNode a1 = rotateRight(aListNode, 5);
//		System.out.println(a1);
		String aString = null;
//		System.out.println(aString);
    }
}
