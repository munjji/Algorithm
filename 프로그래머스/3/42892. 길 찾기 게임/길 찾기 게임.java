import java.util.*;

class Solution {
    
    static class Node {
        int x;
        int y;
        int num;
        
        Node left;
        Node right;
        
        Node (int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer;
        
        List<Node> nodes = new ArrayList<>();
        
        for (int i = 0; i < nodeinfo.length; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            int num = i + 1;
            
            nodes.add(new Node(x, y, num));
        }
        
        Collections.sort(nodes, (a, b) -> {
            if (a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });
        
        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            insert(root, nodes.get(i));
        }
        
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        preorder(root, pre);
        postorder(root, post);
        
        answer = new int[2][nodes.size()];
        
        for (int i = 0; i < nodes.size(); i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        
        return answer;
    }
    
    static void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
    
    static void preorder(Node node, List<Integer> result) {
        if (node == null) return;
        
        result.add(node.num);
        preorder(node.left, result);
        preorder(node.right, result);
    }
    
    static void postorder(Node node, List<Integer> result) {
        if (node == null) return;
        
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.num);
    }
}