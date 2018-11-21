/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.sql.controller;
/**
 *
 * @author aca17mss
 */
public class SQLValidation {
    
    public String generalValidation(String input){
        
        String output = "";
        
        for(int i = 0; i < input.length(); i++){
            output += checkChar(input.charAt(i));
        }
        
        return output;
    }
    
    private char checkChar (char c){
        
        int i = (int)c;
        
        if((i>64 && i<91) || (i>96 && i<123) || (i>47 && i<58) || i == 32) return c;
        else{
            System.out.println("Illegal characters used, only english alphabet letters and numbers allowed. Special characters not allowed.");
            return ' ';
        }
        
    }
    
}


