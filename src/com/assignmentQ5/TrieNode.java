package com.assignmentQ5;

public class TrieNode {
	TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // 26 letters in the alphabet
        isEndOfWord = false;
    }
}
