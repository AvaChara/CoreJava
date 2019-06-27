package sixteen;

import java.util.BitSet;

public class BitSetDemo {
    public static void main(String args[]){
        BitSet bitSet1=new BitSet(16);
        BitSet bitSet2=new BitSet(16);

        for (int i = 0; i < 16; i++) {
            if ((i%2)==0)
                bitSet1.set(i);
            if ((i%5)!=0)
                bitSet2.set(i);
        }
        System.out.println("Initial pattern in bitset1:");
        System.out.println(bitSet1);
        System.out.println("\nInitial pattern in bitset2:");
        System.out.println(bitSet2);

        bitSet1.and(bitSet2);
        System.out.println("\nbitset2 AND bitset1:");
        System.out.println(bitSet2);

        bitSet2.or(bitSet1);
        System.out.println("\nbitset2 OR bitset1:");
        System.out.println(bitSet2);

        bitSet2.xor(bitSet1);
        System.out.println("\nbitset2 XOR bitset1:");
        System.out.println(bitSet2);
    }
}
