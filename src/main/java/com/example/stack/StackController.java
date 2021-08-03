package com.example.stack;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StackController {

    private StackUsingArray stackUsingArray;

    @PostMapping("/create")
    public void createStack(@RequestParam Integer size) {
        stackUsingArray = StackUsingArray.getInstance(size);
    }

    @PostMapping("/push/{element}")
    public ResponseEntity push(@PathVariable Integer element) {
        try {
            stackUsingArray.push(element);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (NullPointerException ex) {
            return new ResponseEntity("Please create stack before operations", HttpStatus.BAD_REQUEST);
        }
        catch (StackOverFlowException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/pop")
    public ResponseEntity pop() {
        try {
            return new ResponseEntity(stackUsingArray.pop(), HttpStatus.OK);
        }
        catch (NullPointerException ex) {
            return new ResponseEntity("Please create stack before operations", HttpStatus.BAD_REQUEST);
        }
        catch (StackUnderFlowException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/peek")
    public ResponseEntity peek() {
        try {
            return new ResponseEntity(stackUsingArray.peek(), HttpStatus.OK);
        }
        catch (NullPointerException ex) {
            return new ResponseEntity("Please create stack before operations", HttpStatus.BAD_REQUEST);
        }
        catch (StackUnderFlowException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/size")
    public int size() {
        return stackUsingArray.size();
    }

    @GetMapping("/empty")
    public boolean empty() {
        return stackUsingArray.isEmpty();
    }

}
