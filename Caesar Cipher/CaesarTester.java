/*
 * Name:  Rui Yan
 * Login: cs8bwaka 
 * Date:  January 12, 2016
 * File:  CaesarTester.java
 * Sources of Help: textbook: Intro to java programming
 *
 * Tests Caesar.java using basic strings and rotation values. 
 *
 */


/*
 * Name:    CaesarTester
 * Purpose: To test Caesar.java for correct output.
 */
public class CaesarTester {
  
  /*
   * Name:       main
   * Purpose:    To call methods in Caesar and test them
   * Parameters: String[] args - command line arguments that are unused
   * Return:     void
   */
  public static void main(String[] args) {
    
    /** The main method. THIS IS WHERE YOU SHOULD ADD MORE TESTS
      * FOR encrypt and decrypt methods AND ANY OTHER METHOD
      * THAT YOU CREATE. BE SURE TO TEST YOUR CODE THOROUGHLY
      **/
    
    //The Caesar Cipher Tests
    int failCases = 0;
    
    //Test 1
    String message1 = "Cse8b: Programming in Java, Part 2";
    String encryptedAnswer = "Tjv8s: Gifxirddzex ze Armr, Grik 2";
    String encrypted1 = Caesar.encrypt(message1, 17);
    
    if (!encryptedAnswer.equals(encrypted1)) {
      System.out.println("Test 1 Failed(encryption)");
      System.out.println("Given message to encrypt is: " + message1);
      System.out.println("Your Answer is: " + encrypted1);
      System.out.println("The correct answer is: " + encryptedAnswer);
      failCases++;
    } else {
      System.out.println("Test 1 Passed!\n");
    }
    
    //Test 2
    String encrypted2 = "Byffi yhwlsjncih qilfx";
    String messageAnswer = "Hello encryption world";
    String message2 = Caesar.decrypt(encrypted2, -58);
    
    if (!messageAnswer.equals(message2)) {
      System.out.println("Test 2 Failed(decryption)");
      System.out.println("Given message to decrypt is: " + encrypted2);
      System.out.println("Your Answer is: " + message2);
      System.out.println("The correct answer is: " + messageAnswer);
      failCases++;
    } else {
      System.out.println("Test 2 Passed!\n");
    }
    
    //Test 9
    String message9 ="Vegeta, what does the scouter say about his power "
       + " level? It's over nine thousand!!!";
    String encryptedAnswer1 = "Sbdbqx, texq albp qeb pzlrqbo pxv xylrq efp "
       + "mltbo  ibsbi? Fq'p lsbo kfkb qelrpxka!!!";
    String encrypted9 = Caesar.encrypt(message9,2147483647);
    
    if (!encryptedAnswer1.equals(encrypted9)) {
      System.out.println("Test 9 Failed(encryption)");
      System.out.println("Given message to encrypt is: " + message9);
      System.out.println("Your Answer is: " + encrypted9);
      System.out.println("The correct answer is: " + encryptedAnswer1);
      failCases++;
    } else {
      System.out.println("Test 9 Passed!\n");
    }
   
    //Test 10
    String encrypted10 = "Sbdbqx, texq albp qeb pzlrqbo pxv xylrq efp "
       + "mltbo  ibsbi? Fq'p lsbo kfkb qelrpxka!!!";
    String messageAnswer1 = "Vegeta, what does the scouter say about his power "
       + " level? It's over nine thousand!!!";
    String message10 = Caesar.decrypt(encrypted10,2147483647);
    
    if (!messageAnswer1.equals(message10)) {
      System.out.println("Test 10 Failed(decryption)");
      System.out.println("Given message to decrypt is: " + encrypted10);
      System.out.println("Your Answer is: " + message10);
      System.out.println("The correct answer is: " + messageAnswer1);
      failCases++;
    } else {
      System.out.println("Test 10 Passed!\n");
    }

    //Messages that print whether tests were successful or not
    if (failCases == 0) {
      System.out.println("All Tests Passed!");
    } else {
      System.out.println("Number of Failed Test Cases : " + failCases);
    } 
  }  
}
