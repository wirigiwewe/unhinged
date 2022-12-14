package com.example.project.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ControllerUtils {
    static Map<String, String> getErrors(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );
        return bindingResult.getFieldErrors().stream().collect(collector);
    }
 /*  if (bindingResult.hasErrors()) {
        Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

        model.mergeAttributes(errorsMap);
        model.addAttribute("user", user);
    }*/
}