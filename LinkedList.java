public class LinkedList {

    Node headNode; 

    public LinkedList(Node headNode) {
        this.headNode = headNode; 
    }

    public Node getHeadNode() {
        return this.headNode; 
    }

    public void setNewBeginning(Node newHead) {
        newHead.setNextNode(this.getHeadNode());
        this.headNode = newHead; 
    }

    public String stringifyList() {
        Node currentNode = this.getHeadNode(); 
        String stringList = ""; 

        while(currentNode != null) {

            stringList += currentNode.getValue() + "\n"; 
            currentNode = currentNode.getNextNode(); 
        }

        return stringList; 


    }

    public void removeNode(int val_to_rem) {
        Node currentNode = this.getHeadNode(); 
        if(currentNode.getValue() == val_to_rem) {
            this.headNode = currentNode.getNextNode(); 
        } else {
            while (currentNode != null) {
                Node nextNode = currentNode.getNextNode(); 
                if(nextNode.getValue() == val_to_rem) {
                    currentNode.setNextNode(nextNode.getNextNode());
                    currentNode = null; 
                } else {
                    currentNode = nextNode; 
                }
            }
        }
    }

    public void addNode(int valBefore, Node nodeToAdd) {
        Node currentNode = this.getHeadNode(); 

        while(currentNode != null) {
            Node nextNode = currentNode.getNextNode(); 
            if(currentNode.getValue() == valBefore) {
                currentNode.setNextNode(nodeToAdd);
                nodeToAdd.setNextNode(nextNode);
                currentNode = null; 
            } else {
                currentNode = nextNode; 
            }
        }
    }



    public static void main(String[]  args) {


        Node a = new Node(3, null); 
        Node b = new Node(2, a); 
        Node c = new Node(1, b); 
        Node d = new Node(0, c);
        Node negativeOne = new Node(-1, null);
        Node two = new Node(2, null);   

        LinkedList ll = new LinkedList(d);
        
        ll.setNewBeginning(negativeOne);
        ll.removeNode(-1);
        ll.removeNode(2);
        ll.addNode(1,two );
        System.out.println(ll.stringifyList()); 

    }
}