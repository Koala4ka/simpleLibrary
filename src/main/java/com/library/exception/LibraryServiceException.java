package com.library.exception;

public class LibraryServiceException extends RuntimeException{
        public LibraryServiceException(String message)
        {
            super(message+"Record with provided id is not found");
        }

}
