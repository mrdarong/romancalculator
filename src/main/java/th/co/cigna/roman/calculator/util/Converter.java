/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.cigna.roman.calculator.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author darongpon
 */
public class Converter {
    public String RomanToDigit(String romanNumber){
        BigDecimal total = new BigDecimal(BigInteger.ZERO);
        final BigDecimal I = new BigDecimal(1);
        final BigDecimal V = new BigDecimal(5);
        final BigDecimal X = new BigDecimal(10);
        final BigDecimal L = new BigDecimal(50);
        final BigDecimal C = new BigDecimal(100);
        final BigDecimal D = new BigDecimal(500);
        final BigDecimal M = new BigDecimal(1000);
        
        final BigDecimal IV = new BigDecimal(4);
        final BigDecimal IX = new BigDecimal(9);
        final BigDecimal XL = new BigDecimal(40);
        final BigDecimal XC = new BigDecimal(90);
        final BigDecimal CD = new BigDecimal(400);
        final BigDecimal CM = new BigDecimal(900);
        
        
        
        
        if(romanNumber.contains("I")){
            romanNumber.replaceFirst("I", "");
        }else{
            
        }
        
        return romanNumber.replaceFirst("CM", "");
    }
    public String DigitToRoman(String digit){
        return null;
    }
}
