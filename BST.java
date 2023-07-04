public class BST {
    private static Node root;

    private class Node {
        private int key;
        private Node left, right;

        public Node(int key) {
            this.key = key;
        }
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    // void inorder(node n)
    // {
    //     inorder(n.left);
    //     System.out.print(n.key+" ");
    //     inorder(n.right);
    // }

    public boolean contains(int key) {
        return contains(root, key);
    }

    private boolean contains(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (key == root.key) {
            return true;
        } else if (key < root.key) {
            return contains(root.left, key);
        } else {
            return contains(root.right, key);
        }
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    private Node remove(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = remove(root.left, key);
        } else if (key > root.key) {
            root.right = remove(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            Node minNode = findMin(root.right);
            root.key = minNode.key;
            root.right = remove(root.right, minNode.key);
        }
        return root;
    }

    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static Node inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.key+" ");
            inorder(node.right);
        }return node;
    }
    public static Node postorder(Node node){
        if(node != null){
            System.out.print(node.key+" ");
            postorder(node.left);
            postorder(node.right);
        }return node;
    }
    public static Node preorder(Node node){
        if(node != null){
            preorder(node.left);
            preorder(node.right);
            System.out.print(node.key+" ");
        }return node;
    }
    public static Node deorder(Node node){
        if(node != null){
            deorder(node.right);
            System.out.print(node.key+" ");
            deorder(node.left);
        }
        if(node == root)    System.out.println();
        return node;
    }
    public static void main(String args[])
    {
        BST tree = new BST();
        tree.insert(3);
        tree.insert(2);
        tree.insert(01);
        tree.insert(4);
        tree.insert(05);
        // System.out.println(tree.contains(3));
        int num;
        // System.out.println();
        // System.out.println(num);
        // num = postorder(tree.root).key;
        // System.out.println();
        // System.out.println(num);
        // num = preorder(tree.root).key;
        // System.out.println();
        // System.out.println(num);
        num = deorder(BST.root).key;
        // System.out.println();
        System.out.println(num);
    }
}
