package com.assignmentQ4;

public class Main {
	public static void main(String[] args) {
        Codec codec = new Codec();

        // Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize the tree
        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        // Deserialize the string back to a tree
        TreeNode deserializedRoot = codec.deserialize(serialized);

        // Print the deserialized tree (for verification)
        System.out.println("Deserialized Root: " + deserializedRoot.val);
    }
}
