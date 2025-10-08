    import java.util.ArrayList;
    import java.util.Stack;

    class Node{
    int value;
    Node left, right;

    public Node(int value){
    this.value = value;
    left = null;
    right = null;
    }

    }

    class BinarySearchTree{

    Node root;


    /**
    recursive insert method
    */
    public Node insert(Node root, int value){
    //base case
    if(root == null){
     root = new Node(value);
     return root;
    }

    //recursive step
    if(value < root.value){
     root.left = insert(root.left, value);
    }else{
     root.right = insert(root.right, value);
    }

    return root;
    }



    /**
    pre-order traversal
    */
    public void preOrderTraversal(Node root){
    //implement me
    }



    /**
    in-order traversal
    */
    public void inOrderTraversal(Node root){
        Stack<Node> stack = new Stack<>();
        
    }



    /**
    post-order traversal
    */
    public void postOrderTraversal(Node root){
    if (root == null) {
        System.out.println("EMPTY ROOT");
    }

    Stack<Node> stack = new Stack<Node>();
    Stack<Integer> stackCtr = new Stack<Integer>();
    ArrayList<Integer> orderList = new ArrayList<Integer>();

    stack.push(root);
    stackCtr.push(0);

    while (!stack.empty())
    {
        int ctr = stackCtr.pop();
        Node node = stack.peek();

        if (ctr == 0)
        {
            // First visit.
            stackCtr.push(1);

            if (node.left != null)
            {
                stack.push(node.left);
                stackCtr.push(0);
            }
        }
        else if (ctr == 1)
        {
            // Second visit.
            // Left subtree done.
            stackCtr.push(2);

            if (node.right != null)
            {
                stack.push(node.right);
                stackCtr.push(0);
            }
        }
        else // ctr >= 2
        {
            // Third visit.
            // Right subtree done.
            stack.pop();
            orderList.add(node.value);
        }
    }

    StringBuilder output =  new StringBuilder();
    for (int i = 0; i < orderList.size()-1; i++)
    {
        output.append(orderList.get(i) + "-");
    }
    output.append(orderList.getLast());

    System.out.println(output);
    }



    /**
    a method to find the node in the tree
    with a specific value
    */
    public boolean find(Node root, int key){
    //implement me
    return false;
    }



    /**
    a method to find the node in the tree
    with the smallest key
    */
    public int getMin(Node root){
    //implement me
    return 0;
    }



    /**
    a method to find the node in the tree
    with a largest key
    */
    public int getMax(Node root){
    //implement me
    return 0;
    }



        /**
        this method will not compile until getMax
        is implemented
        */
        public Node delete(Node root, int key){

            if (root == null) {
                return root;
            } else if (key < root.value) {
                root.left = delete(root.left, key);
            } else if (key > root.value) {
                root.right = delete(root.right, key);
            } else {
                //node has been found
                if(root.left==null && root.right==null){
                    //case #1: leaf node
                    root = null;
                } else if (root.right == null) {
                    //case #2 : only left child
                    root = root.left;
                }  else if(root.left == null){
                    //case #2 : only right child
                    root = root.right;
                }  else  {
                    //case #3 : 2 children
                    root.value = getMax(root.left);
                    root.left = delete(root.left, root.value);
                }
            }

            return root;
        }


        public Node insert(int value) {
            //base case
            if(root == null){
                root = new Node(value);
                return root;
            }

            //recursive step
            if(value < root.value){
                root.left = insert(root.left, value);
            } else {
                root.right = insert(root.right, value);
            }

            return root;
        }
    }



    public class TreeDemo{
        public static void main(String[] args){
            BinarySearchTree t1  = new BinarySearchTree();
            t1.insert(24);
            t1.insert(80);
            t1.insert(18);
            t1.insert(9);
            t1.insert(90);
            t1.insert(22);

            System.out.print("in-order :   ");
            t1.inOrderTraversal(t1.root);
            System.out.print("post-order :    ");
            t1.postOrderTraversal(t1.root);
            System.out.println();
        }
    }