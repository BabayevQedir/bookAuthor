package az.author.book.dao.model.dto;

import lombok.Value;

@Value
public class ErrorDto<E extends Throwable>{
    int errorCode;
    String message;
    Class<E> classType;
}
