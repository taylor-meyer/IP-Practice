
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
        
        switch (cidrGen) {
            // If 0, CIDR = 8
            case 0:
                this.cidr = 8;
                break;
            // If 1, CIDR = 16
            case 1:
                this.cidr = 16;
                break;
            // If 2, CIDR = 24;
            case 2:
                this.cidr = 24;
                break;
            default:
        } 
    }
    
    /**
     * Returns a string of the IP.
     * @return String in form of 255.255.255.255.
     */
    @Override
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
     * Returns true if first octet is 1-126 and CIDR is 8.
     * @return 
     */
    public boolean isClassA() {
        if (this.octets[0] >= 1 && this.octets[0] <= 126 && this.cidr == 8)
            return true;
        return false;
    }
    
    /**
     * Returns true if first octet is 128-191 and CIDR is 16.
     * @return 
     */
    public boolean isClassB() {
        if (this.octets[0] >= 128 && this.octets[0] <= 191 && this.cidr == 16)
            return true;
        return false;
    }
    
    /**
     * Returns true if first octet is 192-223 and CIDR is 24.
     * @return 
     */
    public boolean isClassC() {
        if (this.octets[0] >= 192 && this.octets[0] <= 223 && this.cidr == 24)
            return true;
        return false;
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
        return this.cidr;
    }
    
    /**
     * Returns subnet mask as a string in form of "255.255.255.255".
     * Currently only works with mask of CIDR /8, /16, /24.
     * Will need to be modified once masks other than 8/16/24 are generated.
     * @return 
     */
    public String getSubnetMask() {
        switch (this.cidr) {
            case 8:
                return "255.0.0.0";
            case 16:
                return "255.255.0.0";
            case 24:
                return "255.255.255.0";
            default:
                return "ERR";
        }
    }
    
    /**
     * Function to test this class.
     * @param args 
     */
    public static void main(String[] args) {
        
        for (int i = 0; i < 100; i++) {
            IP ip = new IP();
            System.out.println("IP: " + ip.toString());
            System.out.println("Subnet Mask: " + ip.getSubnetMask());
            if (ip.isClassA())
                System.out.println("  This IP is Class A.\n");
            else if (ip.isClassB())
                System.out.println("  This IP is Class B.\n");
            else if (ip.isClassC())
                System.out.println("  This IP is Class C.\n");
            else
                System.out.println();
        }
    }
}
