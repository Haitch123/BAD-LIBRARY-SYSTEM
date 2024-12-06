package Librarycatalog.classes;

public class PasswordException extends RuntimeException{
   public PasswordException() {
        super("Password Must Contain AtLeast 8 Characters And Must Include Uppercase, Lowercase And Special Character");
    }
}

