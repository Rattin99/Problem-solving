import java.io.Serializable;

public class Node implements Serializable {
    int num;
    String Name;
    Node next;
    long serialVersionUID = 1L;

    public  Node(int num,String name){
        this.Name = name;
        this.num = num;
        this.next = null;
    }

    public void insert(int num, String name){
           Node current = this;
           while(current.next != null){
               current = current.next;
           }
           current.next = new Node(num,name);
    }

    public void print_list(){
        if(next == null){
            System.out.println("Roll: "+ num);
            System.out.println("Name: " + Name);
        }else {
            while (next != null){
                System.out.println("Roll: "+ next.num);
                System.out.println("Name: " + next.Name);
                next = next.next;
            }
        }
    }
    public Node get(int i){
        int j = 0;
        Node current = this;
        while(j<i){
            if(current.next != null){
                current = current.next;
            }
        }
        return  current;
    }

}
