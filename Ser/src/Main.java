import java.io.*;

public class Main {
    public static void main(String[] args) {
        Node first = new Node(1,"Bappa");
       first.insert(2,"Waliyur");
       first.insert(3,"Kola");
       first.insert(4,"Anas");
        System.out.println(first.get(1).Name);

//       try(ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("nodes.dat")))){
//
//       }catch (IOException e){
//           e.printStackTrace();
//       }
    }
}
