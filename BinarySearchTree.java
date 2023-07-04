public class BinarySearchTree {
    
    private Node root;
    
    private class Node {
        int key;
        Node left, right;
        
        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }
    
    public BinarySearchTree() {
        root = null;
    }
    
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        
        Node current = root;
        Node parent = null;
        
        while (true) {
            parent = current;
            
            if (key < current.key) {
                current = current.left;
                if (current == null) {
                    parent.left = new Node(key);
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = new Node(key);
                    return;
                }
            }
        }
    }
    
    public boolean search(int key) {
        Node current = root;
        
        while (current != null) {
            if (key == current.key) {
                return true;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        
        return false;
    }
    
    public void inorderTraversal() {
        inorderTraversal(root);
    }
    
    private void inorderTraversal(Node node) {
        if (node == null) {
            //System.out.println();
            return;
        }
        
        inorderTraversal(node.left);
        System.out.print(node.key + " ");
        inorderTraversal(node.right);
    }
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(9);
        bst.inorderTraversal(); // 1 3 5 7 9
        System.out.println();
        System.out.println(bst.search(7)); // true
        System.out.println(bst.search(4)); // false
    }
}
