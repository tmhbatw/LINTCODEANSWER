package datastructure;

import java.util.NavigableMap;
import java.util.TreeMap;

    public class TrieNode {
        public NavigableMap<Character, TrieNode> children;
        public TrieNode() {
            children = new TreeMap<Character, TrieNode>();
        }
    }

