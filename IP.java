
package ippractice;

import java.util.Random;

/**
 *
 * @author Taylor Meyer
 */
public class IP {
    
    // Array of 4 octets (8 bytes) to represent the ip
    private int[] octets = new int[4];
    
    /**
     * Default constructor. Generates 4 random octets, 0-255 each.
     */
    public IP() {
        
        // New Random
        Random rand = new Random();
        
        // Random numbers 0-255 per octet
        for (int i = 0; i < 4; i++)
            octets[i] = rand.nextInt(256);
        
    }
    
    /**
     * Returns a string of the IP.
     * @return String in form of 255.255.255.255.
     */
    public String toString() {
        
        // String to return, initalize to first octet
        String s = Integer.toString(this.octets[0]) + ".";
        
        // Build IP as a string in form of 255.255.255.255
        for (int i = 1; i < 4; i++) {
            s += Integer.toString(this.octets[i]);
            if (i != 3)
                s += ".";
        }
        
        // Return
        return s;
    }
    
    /**
     * Function to test this class.
     * @param args 
     */
    public static void main(String[] args) {
        
        for (int i = 0; i < 100; i++)
            System.out.println(new IP().toString());
    }
}
