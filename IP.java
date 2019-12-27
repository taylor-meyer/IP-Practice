
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
     * Get octet array.
     * @return 
     */
    public int[] getOctets() {
        return this.octets;
    }
    
    /**
     * Get first octet.
     * @return 
     */
    public int getFirstOctet() {
        return this.octets[0];
    }
    
    /**
     * Get second octet.
     * @return 
     */
    public int getSecondOctet() {
        return this.octets[1];
    }
    
    /**
     * Get third octet.
     * @return 
     */
    public int getThirdOctet() {
        return this.octets[2];
    }
    
    /**
     * Get fourth octet.
     * @return 
     */
    public int getFourthOctet() {
        return this.octets[3];
    }
    
    /**
     * Function to test this class.
     * @param args 
     */
    public static void main(String[] args) {
        IP ip = new IP();
        int[] testArray = ip.getOctets();
        
        System.out.println(ip.toString());
        System.out.println("---");
        
        
        for(int i : testArray)
            System.out.println(i);
        
        System.out.println("---");
        System.out.println(ip.getFirstOctet());
        System.out.println(ip.getSecondOctet());
        System.out.println(ip.getThirdOctet());
        System.out.println(ip.getFourthOctet());
    }
}
