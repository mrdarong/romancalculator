/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.cigna.roman.calculator.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author darongpon
 */
@Service
public class RomanCalculator {
    
    private static final Logger log = LoggerFactory.getLogger(RomanCalculator.class);
    
    public String sum(String input1, String input2){
        String input = input1 + input2;
        String fForm = transformToFourCharForm(input);
        String output = reArrange(fForm);
        String rForm = reduceForm(output);
        String tForm = transformToTwoCharForm(rForm);
        return tForm;
    }
    
    private String transformToFourCharForm(String romanInput){
        return romanInput.replace("IV", "IIII")
                .replace("IX", "VIIII")
                .replace("XL", "XXXX")
                .replace("CD", "LXXXX")
                .replace("CD", "CCCC")
                .replace("CM", "DCCCC");
    }
    
    private String transformToTwoCharForm(String romanInput){
        return romanInput.replace("DCCCC","CM")
                .replace("CCCC","CD")
                .replace("LXXXX","CD")
                .replace("XXXX","XL")
                .replace("VIIII","IX")
                .replace("IIII","IV");
    }
    
    private String reArrange(String romanInput){
        romanInput.toUpperCase();
        HashMap<Character,Integer> romanToValue = new HashMap<Character,Integer>();
        romanToValue.put('I', 1);
        romanToValue.put('V', 5);
        romanToValue.put('X', 10);
        romanToValue.put('L', 50);
        romanToValue.put('C', 100);
        romanToValue.put('D', 500);
        romanToValue.put('M', 1000);
        HashMap<Integer,Character> valueToRoman = new HashMap<Integer,Character>();
        valueToRoman.put(1,'I');
        valueToRoman.put(5,'V');
        valueToRoman.put(10,'X');
        valueToRoman.put(50,'L');
        valueToRoman.put(100,'C');
        valueToRoman.put(500,'D');
        valueToRoman.put(1000,'M');
        String romanReturn = "";
        List<Integer> returnList = new ArrayList<Integer>();
        
        for(Character inputChar : romanInput.toCharArray()){
            Integer intValue = romanToValue.get(inputChar);
            returnList.add(intValue);
        }
        
        Object[] returnArr = returnList.toArray();
        Arrays.sort(returnArr,Collections.reverseOrder());
        
        for(Object returnInt : returnArr){
            Character returnChar = valueToRoman.get((Integer)returnInt);
            romanReturn += returnChar;
        }
        return romanReturn;
    }
    
    private String reduceForm(String romanInput){
        return romanInput.replace("VV","X")
                .replace("LL","C")
                .replace("DD","M");
    }
}
