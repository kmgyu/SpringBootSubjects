package com.mnu.software_engineering_241016.controller;

import com.mnu.software_engineering_241016.dto.CalDTO;
import com.mnu.software_engineering_241016.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class CalController {

    private final OperationService operationService;

    @GetMapping("calculation")
    public String calc(Model mode){
        return "calculation.html";
    }

    @GetMapping("/operation")
    public String operation(CalDTO calObj, Model model){
        int sumVal = operationService.operation(calObj);

        model.addAttribute("firstNo", calObj.getFirstNo());
        model.addAttribute("secondNo", calObj.getSecondNo());
        model.addAttribute("sumVal", sumVal);
        return "article.html";
    }
}
