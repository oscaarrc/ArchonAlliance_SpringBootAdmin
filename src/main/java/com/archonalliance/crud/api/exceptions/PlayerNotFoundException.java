package com.archonalliance.crud.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Este jugador no existe")
public class PlayerNotFoundException extends RuntimeException {
}
