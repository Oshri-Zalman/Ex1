
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex1Test {
        @Test
        void computeNumberTest() { // test if 2 different numbers are converting good with the functions "number2int" and "int2Number", and in the end check if there values are the same.
            String s2 = "1011b2";
            int v = Ex1.number2int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() { // test if the function "isNumber" working good, check if numbers in the test working good with the format.
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }

    @Test
    void int2NumberTest() { // test if the function "int2Number" working good, we put num (in decimal value) and the base that we want to convert and see if the result is ok.
        assertEquals("0b2", Ex1.int2Number(0, 2));
        assertEquals("1b2", Ex1.int2Number(1, 2));
        assertEquals("1100100b2", Ex1.int2Number(100, 2));
        assertEquals("123b8", Ex1.int2Number(83, 8));
        assertEquals("100bA", Ex1.int2Number(100, 10));
        assertEquals("C8bG", Ex1.int2Number(200, 16));
        assertEquals("1FbG", Ex1.int2Number(31, 16));
        assertEquals("", Ex1.int2Number(-10, 10));
        assertEquals("", Ex1.int2Number(100, 20));
        assertEquals("110111101110b2", Ex1.int2Number(3566, 2));
        assertEquals("8bA", Ex1.int2Number(8, 10));
        assertEquals("1000000b2", Ex1.int2Number(64, 2));
        assertEquals("1b2", Ex1.int2Number(1, 2));
        assertEquals("F9bG", Ex1.int2Number(249, 16));
        assertEquals("0bG", Ex1.int2Number(0, 16));
    }


    @Test
        void maxIndexTest() { // test if the function "maxIndex" is working good if it ok the result will be the max index in the array.
            String[] arr1 = {"101b2", "15b10", "FFbG", "7b10"};
            assertEquals(2, Ex1.maxIndex(arr1));

            String[] arr2 = {"1111b2", "15b10", "F0bG", "1000b2"};
            assertEquals(2, Ex1.maxIndex(arr2));

            String[] arr3 = {"111111b2"};
            assertEquals(0, Ex1.maxIndex(arr3));

            String[] arr4 = {"000101b2", "0015b10", "00F0bG"};
            assertEquals(2, Ex1.maxIndex(arr4));

            String[] arr5 = {"", "invalid", "10b2", "FFbG"};
            assertEquals(3, Ex1.maxIndex(arr5));

            String[] arr6 = {"1111b2", "F0bG", "15b10"};
            assertEquals(1, Ex1.maxIndex(arr6));

            String[] arr8 = {"101010101010b2", "FFFFbG", "100000b10"};
            assertEquals(1, Ex1.maxIndex(arr8));
        }

        @Test
    void equalsTest() { // test the "equals" function, put 2 numbers and check if there value similar or not.

            assertTrue(Ex1.equals("111102b2", "111102b2"));
            assertTrue(Ex1.equals("312102b4", "312102b4"));
            assertTrue(Ex1.equals("FbG", "FbG"));
            assertTrue(Ex1.equals("11110b2", "30bA"));
            assertFalse(Ex1.equals("111102b5", "111102b2"));
            assertFalse(Ex1.equals("EEbG", "EEbF"));
            assertTrue(Ex1.equals("0b4", "0b9"));
            assertTrue(Ex1.equals("", ""));
            assertTrue(Ex1.equals("1000111000001b2", "4545bA"));

        }
    }



