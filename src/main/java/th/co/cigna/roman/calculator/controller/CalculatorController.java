/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.cigna.roman.calculator.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.co.cigna.roman.calculator.service.RomanCalculator;

/**
 *
 * @author darongpon
 */
@Controller
public class CalculatorController {
    
    @Autowired
    RomanCalculator romanCalculator;
    
    @RequestMapping(method = RequestMethod.GET, value = "/romansum")
    public String romansum(@RequestParam("input1") String input1, @RequestParam("input2") String input2) throws Exception {
        String output = romanCalculator.sum(input1,input2);
        return output;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/uploadText")
    public String uploadTabplan(@RequestParam("file") MultipartFile file) throws Exception {
        String output = romanCalculator.sum(file.getInputStream());
        return output;
    }
    
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws IOException {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }


        String output = romanCalculator.sum(file.getInputStream());

        redirectAttributes.addFlashAttribute("message",
                "Roman calculation is \n" + output  );

        

        return "redirect:/uploadStatus";
    }
    
    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }


}
