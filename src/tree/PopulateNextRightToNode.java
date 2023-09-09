package tree;

public class PopulateNextRightToNode {
    public static void main(String[] args) {
        Node node = new Node(2, new Node(1, new Node(0, new Node(2), null),
                new Node(7, new Node(1), new Node(0, new Node(7), null))),
                new Node(3, new Node(9), new Node(1, new Node(8), new Node(8))));
        Node res = connect(node);
        System.out.println(res);
    }

    public static Node connect(Node root) {
        if (root != null && (root.left != null || root.right != null)) {
            if (root.left != null)
                root.left.next = root.right;
            if (root.next != null) {
                Node cur = root.next;
                while (cur.next != null && cur.left == null && cur.right == null) {
                    cur = cur.next;
                }
                Node to = cur.left == null ? cur.right : cur.left;
                Node from = root.right == null ? root.left : root.right;
                from.next = to;
            }
            connect(root.right);
            connect(root.left);
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                (left != null ? ", left=" + left : "") +
                (right != null ? ", right=" + right : "") +
                (next != null ? ", next=" + next : "") +
                "}";
    }
};
