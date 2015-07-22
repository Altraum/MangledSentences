/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    
    
    public static void main(String[] args) {
        Random mangler = new Random();
        Scanner input = new Scanner(System.in);
        int stopIndex;
        int startIndex = 0;
        char[] charDivider;
        char[] mangledWord;
        String sentence;
        System.out.println("Input sentence to be mangled.");
        sentence=input.nextLine();
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
}
