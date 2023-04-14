package project20280.tree;

import project20280.interfaces.Position;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Concrete implementation of a binary tree using a node-based, linked
 * structure.
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    static java.util.Random rnd = new java.util.Random();
    /**
     * The root of the binary tree
     */
    protected Node<E> root = null; // root of the tree

    // LinkedBinaryTree instance variables
    /**
     * The number of nodes in the binary tree
     */
    private int size = 0; // number of nodes in the tree

    /**
     * Constructs an empty binary tree.
     */
    public LinkedBinaryTree() {
    } // constructs an empty binary tree
 

    // accessor methods (not already implemented in AbstractBinaryTree)


    public static void main(String [] args) {
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<Integer>();

        //Integer[] arr = new Integer[]{1,
        //                               2, 3, 
                                       //4, 5, 6, 7, 
                                       //8, 9, 10, 11, 12, 13, 14, 15};
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        bt.createLevelOrder(arr);
        System.out.println("size: " + bt.size() + " isEmpty: " + bt.isEmpty());
        System.out.println(bt.toBinaryTreeString());
        System.out.println(bt.positions());
    }

    public static void main_old(String[] args) {
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<Integer>();

        // Direct construction of Tree
        Position<Integer> root = bt.addRoot(12);
        Position<Integer> p1 = bt.addLeft(root, 25);
        Position<Integer> p2 = bt.addRight(root, 31);

        Position<Integer> p3 = bt.addLeft(p1, 58);
        bt.addRight(p1, 36);

        Position<Integer> p5 = bt.addLeft(p2, 42);
        bt.addRight(p2, 90);

        Position<Integer> p4 = bt.addLeft(p3, 62);
        bt.addRight(p3, 75);

        System.out.println("bt inorder: " + bt.size() + " " + bt.inorder());
        System.out.println("bt preorder: " + bt.size() + " " + bt.preorder());
        System.out.println("bt preorder: " + bt.size() + " " + bt.postorder());

        System.out.println(bt.toBinaryTreeString());
    }


    /**
     * Factory function to create a new node storing element e.
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    /**
     * Verifies that a Position belongs to the appropriate class, and is not one
     * that has been previously removed. Note that our current implementation does
     * not actually verify that the position belongs to this particular list
     * instance.
     *
     * @param p a Position (that should belong to this tree)
     * @return the underlying Node instance for the position
     * @throws IllegalArgumentException if an invalid position is detected
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of nodes in the tree.
     *
     * @return number of nodes in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the root Position of the tree (or null if tree is empty).
     *
     * @return root Position of the tree (or null if tree is empty)
     */
    @Override
    public Position<E> root() {
        return root;
    }

    // update methods supported by this class

    /**
     * Returns the Position of p's parent (or null if p is root).
     *
     * @param p A valid Position within the tree
     * @return Position of p's parent (or null if p is root)
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        // TODO        
        return validate(p).parent;
    }

    /**
     * Returns the Position of p's left child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the left child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {

        return validate(p).left;
    }

    /**
     * Returns the Position of p's right child (or null if no child exists).
     *
     * @param p A valid Position within the tree
     * @return the Position of the right child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        // TODO
        return validate(p).right;
    }

    /**
     * Places element e at the root of an empty tree and returns its new Position.
     *
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        //if(this.root != null)
        if(!isEmpty()) {
            throw new IllegalStateException("tree already has a root!");
        }

        this.root = createNode(e, null, null, null);
        size++;
        return this.root;
    }

    public void insert(E e) {
        // TODO
        // ignore this method
    }

    // recursively add Nodes to binary tree in proper position
    private Node<E> addRecursive(Node<E> p, E e) {
        // TODO
        return null; // ignore this method
    }

    /**
     * Creates a new left child of Position p storing element e and returns its
     * Position.
     *
     * @param p the Position to the left of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p already has a left child
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        // TODO
        Node<E> parent = validate(p);
        if(parent.getLeft() != null) throw new IllegalArgumentException("left child already exists");

        Node<E> child = createNode(e, parent, null, null);
        parent.left = child; // parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * Creates a new right child of Position p storing element e and returns its
     * Position.
     *
     * @param p the Position to the right of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p already has a right child
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getRight() != null) throw new IllegalArgumentException("right child already exists");

        Node<E> child = createNode(e, parent, null, null);
        parent.right = child; 
        size++;
        return child;
    }

    /**
     * Replaces the element at Position p with element e and returns the replaced
     * element.
     *
     * @param p the relevant Position
     * @param e the new element
     * @return the replaced element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        // TODO
        Node<E> node = validate(p);
        E old = node.getElement();
        node.setElement(e);
        return old;
    }

    /**
     * Attaches trees t1 and t2, respectively, as the left and right subtree of the
     * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
     *
     * @param p  a leaf of the tree
     * @param t1 an independent tree whose structure becomes the left child of p
     * @param t2 an independent tree whose structure becomes the right child of p
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p is not a leaf
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        // TODO
    }

    /**
     * Removes the node at Position p and replaces it with its child, if any.
     *
     * @param p the relevant Position
     * @return element that was removed
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p has two children.
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        // TODO
        //      C
        //     /
        //    A
        //  /    
        // B      
        // get the child of p
        Node<E> n = validate(p);

        if(numChildren(p) > 1) throw new IllegalArgumentException("can't remove node with >1 children");

        Node<E> child = (n.left != null) ? n.left : n.right;
        
        //Node<E> child = n.right;
        //if(n.left != null) child = n.left;
        if(child != null) {
            child.parent = n.parent;
        }
        if(n == root) {
            root = child;
        } else {
            Node<E> parent = n.parent;
            if(n == parent.left) {
                parent.left = child;
            }
            else {
                parent.right = child;
            }
        }

        size--;
        return n.element;
    }

    public String toString() {
        return positions().toString();
    }

    public void createLevelOrder(ArrayList<E> l) {
        // TODO
    }

    public void constructBinaryTree(E[] inorder, E[] preorder) {
        this.root = constructBinaryTreeHelper(inorder, preorder, 0, preorder.length, 0);
    }

    private Node<E> constructBinaryTreeHelper(E[] inorder, E[] preorder, int start, int end, int preindex) {
        if(start >= end || preindex >= inorder.length) {
            return null;
        }
        //
        int rootIndex = 0;
        for(; rootIndex < inorder.length; ++rootIndex) {
            if(inorder[rootIndex] == preorder[preindex]) {
                break;
            }
        }
        //int rootIndex = findIndex(inorder, preorder[preindex++]);
        preindex++;

        Node<E> n = createNode(inorder[rootIndex], null, null, null);//new Node<E>(inorder[rootIndex]);
        // set the parents....
        size++;

        n.left = constructBinaryTreeHelper(inorder, preorder, start, rootIndex-1, preindex);
        n.right = constructBinaryTreeHelper(inorder, preorder, rootIndex+1, end, preindex);
        return n;
    }

    private Node<E> createLevelOrderHelper(java.util.ArrayList<E> l, Node<E> p, int i) {
        // TODO
        return null;
    }

    public void createLevelOrder(E[] arr) {
        root = createLevelOrderHelper(arr, root, 0);
    }

    private Node<E> createLevelOrderHelper(E[] arr, Node<E> p, int i) {
        if(i < arr.length) {
            if(arr[i] == null) return null;
            Node<E> n = createNode(arr[i], p, null, null);
            size++;
            n.left = createLevelOrderHelper(arr, n.left, 2*i + 1);
            n.right = createLevelOrderHelper(arr, n.right, 2*i + 2);
            return n;            
        }
        return p;
    }

    public String toBinaryTreeString() {
        BinaryTreePrinter<E> btp = new BinaryTreePrinter<>(this);
        return btp.print();
    }

    /**
     * Nested static class for a binary tree node.
     */
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> left, right, parent;

        public Node(E e, Node<E> p, Node<E> l, Node<E> r) {
            element = e;
            left = l;
            right = r;
            parent = p;
        }

        // accessor
        public E getElement() {
            return element;
        }

        // modifiers
        public void setElement(E e) {
            element = e;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> n) {
            left = n;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> n) {
            right = n;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> n) {
            parent = n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (element == null) {
                sb.append("\u29B0");
            } else {
                sb.append(element);
            }
            return sb.toString();
        }
    }
}
