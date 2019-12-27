
package ippractice;

import java.util.Random;

/**
 *
 * @author Taylor Meyer
 */
public class IP {
    
    // Array of 4 octets (8 bytes) to represent the ip
    private int[] octets = new int[4];
    
    // CIDR
    private int cidr;
    
    /**
     * Default constructor. Generates 4 random octets, 0-255 each.
     */
    public IP() {
        
        // New Random
        Random rand = new Random();
        
        // Random numbers 0-255 per octet
        for (int i = 0; i < 4; i++)
            octets[i] = rand.nextInt(256);
        
        // Generate a number 0-3
        int cidrGen = rand.nextInt(3);
        
        // If 0, CIDR = 8
        if (cidrGen == 0)
            this.cidr = 8;
        // If 1, CIDR = 16
        else if (cidrGen == 1)
            this.cidr = 16;
        // If 2, CIDR = 24;
        else
            this.cidr = 24;
        
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
        
        s += "/" + Integer.toString(this.cidr);
        
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
     * Get CIDR.
     * @return 
     */
    public int getCidr() {
        return cidr;
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
