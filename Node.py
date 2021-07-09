class Node: 
     
    def __init__(self, value, next_node=None): 
        self.value = value 
        self.next_node = next_node
        
    def get_value(self): 
        return self.value 
    
    def get_next_node(self): 
        return self.next_node 
    
    def set_next_node(self, next_node): 
        self.next_node = next_node 

class LinkedList: 

    def __init__(self, head_node): 
        self.head_node = head_node
    
    def get_head_node(self): 
        return self.head_node 
    
    def set_new_beginning(self, new_head): 
        new_head.set_next_node(self.get_head_node()) 
        self.head_node = new_head 
    
    def stringify_list(self): 
        current_node = self.get_head_node() 
        string_list = "" 

        while current_node: 
            if current_node.get_value() != None: 
                string_list += str(current_node.get_value()) + "\n" 
            
            current_node = current_node.get_next_node() 
        
        return string_list 
    
    def remove_node(self, val_to_rem): 
        current_node = self.get_head_node() 
        if current_node.get_value() == val_to_rem: 
            self.head_node = current_node.get_next_node() 
        else: 
            while current_node: 
                next_node = current_node.get_next_node() 
                if next_node.get_value() == val_to_rem: 
                    current_node.set_next_node(next_node.get_next_node())
                    current_node = None 
                else: 
                    current_node = next_node 
    
    def add_node(self, val_before, node_to_add): 
        current_node = self.get_head_node() 

        while current_node: 
            next_node = current_node.get_next_node() 
            if current_node.get_value() == val_before: 
                current_node.set_next_node(node_to_add) 
                node_to_add.set_next_node(next_node)
                current_node = None 
            else: 
                current_node = next_node

        


a = Node(3)
b = Node(2, a) 
c = Node(1, b) 
d = Node(0, c)
ll = LinkedList(d)
ll.set_new_beginning(Node(-1))
ll.remove_node(-1) 
ll.add_node(2, Node(2.5))
print(ll.stringify_list()) 
    
