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
        for(int index = 0;index<=sentence.length();index++){
            if(index >= charDivider.length){
                mangledWord = new char[index - startIndex];
                stopIndex = index;
                int wordSize = stopIndex-startIndex;
                for(int letter = startIndex; letter<stopIndex; letter++){
                    mangledWord[letter - startIndex] = charDivider[letter];
                }
                int[] chosen = new int[wordSize];
                for (int x = 0;x<wordSize;x++){
                    chosen[x] = -1;
                }
                int ltrCount = 0;
                while(ltrCount<wordSize){
                    int randomNumber = mangler.nextInt(wordSize);
                    for (int a = 0; a<wordSize; a++){
                        if(randomNumber==chosen[a]){
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
            if(charDivider[index]==' '){
                mangledWord = new char[index-startIndex];
                stopIndex = index;
                int wordSize = stopIndex-startIndex;
                for(int letter = startIndex; letter<stopIndex; letter++){
                    mangledWord[letter-startIndex] = charDivider[letter];
                }
                int[] chosen = new int[wordSize];
                for (int x = 0;x<wordSize;x++){
                    chosen[x] = -1;
                }
                int ltrCount = 0;
                while(ltrCount<wordSize){
                    int randomNumber = mangler.nextInt(wordSize);
                    for (int a = 0; a<wordSize; a++){
                        if(randomNumber==chosen[a]){
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
        Scanner input = new Scanner(System.in);
        String sentence;
        System.out.println("Input sentence to be mangled.");
        sentence=input.nextLine();
        mixer(sentence);
    }
}
