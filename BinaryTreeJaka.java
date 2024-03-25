public class BinaryTreeJaka<Type extends Comparable<? super Type>> {
    private class Node {
        Type data;
        Node left, right;

        public Node (Type data)
        {
            this.data = data;
            left = right = null;
        }

        public Node getLeft()
        {
            return left;
        }
        public void setLeft(Node left)
        {
            this.left = left;
        }

        public Node getRight()
        {
            return right;
        }
        public void setRight(Node right)
        {
            this.right = right;
        }

        public Type getData()
        {
            return data;
        }
        public void setData(Type data)
        {
            this.data = data;
        }
        }

        Node root;
        int height;
        public BinaryTreeJaka()
        {
            this.root = null;
            height = 0;
        }

        private Node add(Node root, Node newNode) {
            if (root == null) 
            {
                return newNode;
            } 
            else if (root.getData().compareTo(newNode.getData()) < 0)
            {
                root.setRight(add(root.getRight(), newNode));
            }
            else if (root.getData().compareTo(newNode.getData()) > 0) 
            {
                root.setLeft(add(root.getLeft(), newNode));
            }
            return root;
        }
        

        public void add(Type data)
        {
            this.root = add(this.root, new Node(data));
        }

        private void inOrder(Node newRoot)
        {
            if(newRoot == null) return;
            inOrder(newRoot.getLeft());
            System.out.println(newRoot.getData());
            inOrder(newRoot.getRight());
        }

        public void inOrder()
        {
            inOrder(this.root);
        }

        private void postOrder(Node newRoot)
        {
            if(newRoot == null) return;
            postOrder(newRoot.getLeft());
            postOrder(newRoot.getRight());
            System.out.println(newRoot.getData());
        }

        public void postOrder()
        {
            postOrder(this.root);
        }

        private void preOrder(Node newRoot)
        {
            if(newRoot == null) return;
            System.out.println(newRoot.getData());
            preOrder(newRoot.getLeft());
            preOrder(newRoot.getRight());
        }

        public void preOrder()
        {
            preOrder(this.root);
        }

        private boolean findElement(Node root, Type data) {
            if(root == null) {
                return false;
            }

            if(root.getData() != null && root.getData().compareTo(data) == 0) {
                return true; 
            } else if(root.getData() != null && root.getData().compareTo(data) > 0) {
                return findElement(root.getLeft(), data); 
            } else {
                return findElement(root.getRight(), data); 
            }
        }
        
        public boolean findElement(Type data) {
            return findElement(this.root, data); 
        }
        
        private Node delete(Node root, Type data) {
            if (root == null) {
                return null;
            }
        
            if (root.getData().compareTo(data) > 0) {
                root.setLeft(delete(root.getLeft(), data));
            } else if (root.getData().compareTo(data) < 0) {
                root.setRight(delete(root.getRight(), data));
            } else {
                if (root.getLeft() == null) {
                    return root.getRight();
                } else if (root.getRight() == null) {
                    return root.getLeft();
                } else {
                    Node successor = findMin(root.getRight());
                    root.setData(successor.getData());
                    root.setRight(delete(root.getRight(), successor.getData()));
                }
            }
            return root;
        }
        
        private Node findMin(Node node) {
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
            return node;
        }
        
        public void delete(Type data) {
            this.root = delete(this.root, data);
        }
        
        

        
        
    }

