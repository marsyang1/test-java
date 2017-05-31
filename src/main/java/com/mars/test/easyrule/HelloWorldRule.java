package com.mars.test.easyrule;


import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;

/**
 * Created by USER on 2017/5/24.
 */
@Rule(name = "Hello World rule",
        description = "Say Hello to duke's friends only")
public class HelloWorldRule {

    /**
     * The user input which represents the data
     * that the rule will operate on.
     */
    private String input;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if
        //the user's response is yes (duke friend)
        return input.equalsIgnoreCase("yes");
    }

    @Action
    public void sayHelloToDukeFriend() throws Exception {
        //When rule conditions are satisfied,
        //prints 'Hello duke's friend!' to the console
        System.out.println("Hello duke's friend!");
    }

    public void setInput(String input) {
        this.input = input;
    }

}