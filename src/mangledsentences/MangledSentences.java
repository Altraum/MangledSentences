package mangledsentences;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Basil
 */
public class MangledSentences {

    /**
     * @param args the command line arguments
     */
    
    public static void mixer(String sentence){
        Random mangler = new Random();
        int stopIndex;
        int startIndex = 0;
        char[] charDivider;
        char[] mangledWord;
        charDivider = new char[sentence.length()];
        for(int index = 0;index<=sentence.length();index++){//Each run adds one letter of the String sentence to charDivider
            if(index >= charDivider.length){//If you come to the end of the String, mix up the last word
                mangledWord = new char[index - startIndex];
                stopIndex = index;
                int wordSize = stopIndex-startIndex;
                for(int letter = startIndex; letter<stopIndex; letter++){//Each run adds one letter of the word from charDivider into it's own char Array called mangledWord
                    mangledWord[letter - startIndex] = charDivider[letter];
                }
                int[] chosen = new int[wordSize];
                for (int x = 0;x<wordSize;x++){//Initialize the char Array, chosen, with -1's
                    chosen[x] = -1;
                }
                int ltrCount = 0;
                while(ltrCount<wordSize){//Until the number of letters printed matches the number of letter in the word, pick a random index and make sure it hasn't been used yet
                    int randomNumber = mangler.nextInt(wordSize);
                    for (int a = 0; a<wordSize; a++){//Each run searches the chosen array to see if it's index matches any already used
                        if(randomNumber==chosen[a]){//If the index has already been chosen, start at the beginning of the array and use another random index
                            a=-1;
                            randomNumber = mangler.nextInt(wordSize);
                        }
                    }
                    System.out.print(mangledWord[randomNumber]);
                    chosen[ltrCount]= randomNumber;
                    ltrCount++;
                }
                break;
            }
            charDivider[index] = sentence.charAt(index);
            if(charDivider[index]==' '){//If you come to a space, mix up the word preceding it
                mangledWord = new char[index-startIndex];
                stopIndex = index;
                int wordSize = stopIndex-startIndex;
                for(int letter = startIndex; letter<stopIndex; letter++){//Each run adds one letter of the word form charDivider into it's own char Array called mangledWord
                    mangledWord[letter-startIndex] = charDivider[letter];
                }
                int[] chosen = new int[wordSize];
                for (int x = 0;x<wordSize;x++){//Initialize the char Array, chosen, with -1's
                    chosen[x] = -1;
                }
                int ltrCount = 0;
                while(ltrCount<wordSize){//Until the number of letters printed matches the number of letters in the word, pick a random index and make sure it hasn't been used yet
                    int randomNumber = mangler.nextInt(wordSize);
                    for (int a = 0; a<wordSize; a++){//Each run searches the chosen array to see if it's index matches any already used
                        if(randomNumber==chosen[a]){//If the index has already been chosen, start at the begining of the array and use another random index
                            a=-1;
                            randomNumber = mangler.nextInt(wordSize);
                        }
                    }
                    System.out.print(mangledWord[randomNumber]);
                    chosen[ltrCount]= randomNumber;
                    ltrCount++;
                }
                startIndex=stopIndex+1;
                System.out.print(" ");
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Input sentence to be mangled.");
        Scanner input = new Scanner(System.in);
        String sentence;
        sentence=input.nextLine();
        mixer(sentence);
    }
}
