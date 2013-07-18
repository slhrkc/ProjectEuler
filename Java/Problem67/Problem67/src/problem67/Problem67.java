/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problem67;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author salih
 */
public class Problem67 {

    static int nodeAdded = 0;
    static int floor = 1;
    

    static class Node {

        Node(int value, int floor) {
            this.value = value;
            this.floor = floor;
        }
        int value;
        int floor;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(null);
        try {
            Scanner in = new Scanner(new FileReader("triangle.txt"));
            while (in.hasNext()) {
                if (nodeAdded == floor) {
                    nodeAdded = 0;
                    floor++;
                }

                nodes.add(new Node(in.nextInt(), floor));
                nodeAdded++;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
            System.out.println(nodes.get(1).value);
            
            for(int i = floor-1 ; i>= 1; i--){
                int startCell = getStartingCellOfFloor(i);
                for(int j = 0; j < i ; j++){
                
                    if(nodes.get(startCell+j+i).value > nodes.get(startCell+j+i+1).value){
                        nodes.get(startCell+j).value += nodes.get(startCell+j+i).value;
                    }
                    else{
                        nodes.get(startCell+j).value += nodes.get(startCell+j+i+1).value;

                    }
                }
            }
            
            System.out.println(nodes.get(1).value);
        


    }

    public static int getStartingCellOfFloor(int floor) {

        int temp = 1;
        for (int i = 1; i < floor; i++) {
            temp = temp + i;
        }
        
        return temp;
    }
}
