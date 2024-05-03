package com.mbti.config.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
    // 비동기 요청을 위한 InvalidDataException Handler
    @ExceptionHandler(value = { InvalidDataException.class })
    public Object handleException(InvalidDataException ex, WebRequest request) {
    	System.out.println("ㅎㅇ ");
        if (isAjax(request)) {
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("errorMessage", ex.getMessage());
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }

    // 비동기 요청을 위한 Exception Handler
    @ExceptionHandler(value = { Exception.class })
    public Object handleException(Exception ex, WebRequest request) {
    	System.out.println("비동기인가?: "+isAjax(request));
        if (isAjax(request)) {
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("errorMessage", ex.getMessage());
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }

    // AJAX 요청인지 판단하는 메소드
    private boolean isAjax(WebRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    // 내부 에러 클래스 정의
    static class ApiError {
        private HttpStatus status;
        private String message;

        public ApiError(HttpStatus status, String message) {
            this.status = status;
            this.message = message;
        }

        // getter and setter 생략
    }
}



//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(InvalidDataException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponse handleInvalidDataException(InvalidDataException ex) {
//        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
//    }
//
//    // 다른 예외 처리기
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErrorResponse handleException(Exception ex) {
//        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error");
//    }
//}
//
//class ErrorResponse {
//    private int status;
//    private String message;
//
//    public ErrorResponse(int status, String message) {
//        this.status = status;
//        this.message = message;
//    }
//
//    // Getters and Setters
//}

