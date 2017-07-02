/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.cigna.roman.calculator.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import th.co.cigna.roman.calculator.CalculatorApplication;
import th.co.cigna.roman.calculator.service.RomanCalculator;

/**
 *
 * @author darongpon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CalculatorApplication.class)
public class ConveterTest {
    private static final Logger log = LoggerFactory.getLogger(ConveterTest.class);
    @Autowired
    RomanCalculator romanCalculator;
    
    @Test
    public void should_sum1(){
        String output = romanCalculator.sum("XX","II");
        log.info("output1:"+output);
    }
    
    @Test
    public void should_sum2(){
        String output = romanCalculator.sum("II","II");
        log.info("output2:"+output);
    }
    
    @Test
    public void should_sum3(){
        String output = romanCalculator.sum("XIV","LX");
        log.info("output3:"+output);
    }
    
    @Test
    public void should_sum4(){
        String output = romanCalculator.sum("V","V");
        log.info("output4:"+output);
    }
    
    @Test
    public void should_sum5(){
        String output = romanCalculator.sum("IV","V");
        log.info("output5:"+output);
    }
    
    @Test
    public void should_file() throws IOException{
        InputStream targetStream = getClass().getClassLoader().getResourceAsStream("test/test.txt");
        String output = romanCalculator.sum(targetStream);
        log.info("file:"+output);
    }
    
}
