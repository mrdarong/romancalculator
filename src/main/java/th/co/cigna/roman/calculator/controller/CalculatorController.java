/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.cigna.roman.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.co.cigna.roman.calculator.service.RomanCalculator;

/**
 *
 * @author darongpon
 */
@RestController
public class CalculatorController {
    
    @Autowired
    RomanCalculator romanCalculator;
    
    @RequestMapping(method = RequestMethod.GET, value = "/romansum")
    public String romansum(@RequestParam("input1") String input1, @RequestParam("input2") String input2) throws Exception {
        String output = romanCalculator.sum(input1,input2);
        return output;
    }
}
