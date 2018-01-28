 *  Name: Rui Yan
 *  Login: cs8bwaka
 *  Date: January 12, 2016
 *  File: README


PROGRAM DESCRIPTION
-----------------------------------------------------------
* FunWithIntArray.java
Programs in this java file can be used to do the following things:
1. print an array of integers.
2. copy an array of integers.
3. find the maximum/minimum integer in an array of integers and print it.
4. sort the integer, which is in an array of integers, from small to large. 
---------------------------
* Caesar.java
Programs in this java file implement a rotational cipher, which can be used
to do the following things:

1. You can input a plaintext(a string) and a number of rotation(integer, not 
to be 0, 26 or the multiples of 26). The program will encrypt the plaintext 
by rotating its uppercase letters and lowercase letters in an alphabetical 
direction and seperately. Then,it will output the encrypted text.

2. You can input a encrypted text(a string) and a number of rotation(integer).
The program will decrypt the string by applying the rotation in an 
anti-alphabetical direction. Then, it will output the decrypted string.   

Note: this program will not change the non-alphabetic characters such as 
numbers.They will remain the same all the time.
-----------------------------------------------------------
SHORT RESPONSE
-----------------------------------------------------------
Here are the bugs found in FunWithIntArrays.java and a brief descrition of why
bugs were wrong
1. Compile Error - invalid method declaration; return type required
Incorrect: public static findMax(int[] array) 
Fix: public static int findMax(int[] array)
Explanation: the method returns an integer max so we need to declare the return
type as int

2. Runtime Error - Array out of Bounds
Incorrect: for (int i = 0; i <= array.length; i++)
Fix:  for (int i = 0; i < array.length; i++)
Explanation: the index should be less than array.length

3. Compile Error - cannot find symbol
Incorrect: min = array[0];
Fix: int min = array[0];
Explanation: Need to declare the primitive data type of variable min

4.Compile Error - incomparable types: int and <null>
Incorrect: public static int[] arrayCopy(int array)
Fix:  public static int[] arrayCopy(int[] array) 
Explanation: the type of parameter array is int[] rather than int

5. Logic Error - do not copy the element in the array as we expected
Incorrect:  result[i++] = array[i]; 
Fix:  result[i] = array[i];
Explanation: When copy an array, the index of array is equal to the index of
the copy array. We do not need to write i++ again.

6. Logic Error - if statement is wrong
Incorrect: if (array != null)
Fix: if (array == null)
Explanation: According to psa instruction, we should test if array is null. If 
it is null, it will return nothing.

7. Logic Error - do not make copy
Incorrect: int[] result = new int[array.length]
Fix: int[] result = arrayCopy(array);
Explanation: we should make a copy of the original array so that when we
sort the array, the original one will not be modified

8.Logic Error - swapping is wrong
Incorrct: 
   if (array[j] > array[j + 1]) {
     int temp = array[j];
     array[j + 1] = array[j];
     array[j] = temp;
    }
   }
  }
  return array; 
Fix: if (result[j] > result[j+1]) {
     int temp = result[j];
     result[j] = result[j+1];
     result[j+1] = temp;
    }
   }
  }
  return result;
Explanation: First, because we want to change the elements in the result array 
but not the original array, we should change all "array" to" result". Second, 
the original if statement cannot sort the integers in array from small to big. 
The revised one can do so.  
