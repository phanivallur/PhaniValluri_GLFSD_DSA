package com.gl.dsa;

import java.util.ArrayList;
import java.util.List;

public class PairWithSum {
	
	private TreeNode root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PairWithSum pws = new PairWithSum ();
        pws.insert(10);
        pws.insert(20);
        pws.insert(30);
        pws.insert(40);
        pws.insert(50);
        pws.insert(60);
        pws.insert(70);

        int sumValue = 130;
        pws.findPairWithSum(sumValue);
	}

	

	private boolean findPairWithSum(int targetSum) {
		
		List<Integer> inOrderList = new ArrayList<>();
        inOrderTraversal(root, inOrderList);

        int left = 0;
        int right = inOrderList.size() - 1;

        while (left < right) {
            int currentSum = inOrderList.get(left) + inOrderList.get(right);

            if (currentSum == targetSum) {
                System.out.println("Pair is (" + inOrderList.get(left) + ", " + inOrderList.get(right) + ")");
                return true;
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("Pair not found.");
        return false;
		
	}



	private void inOrderTraversal(TreeNode root, List<Integer> list) {
		
		if (root == null) {
            return;
        }

        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
		
	}



	private void insert(int i) {
		// TODO Auto-generated method stub
		
		root = insert(root, i);
	}



	private TreeNode insert(TreeNode root, int i) {
		
		if (root == null) {
            return new TreeNode(i);
        }
		
        if (i < root.val) {
            root.left = insert(root.left, i);
        } else if (i > root.val) {
            root.right = insert(root.right, i);
        }
        return root;
	}
}