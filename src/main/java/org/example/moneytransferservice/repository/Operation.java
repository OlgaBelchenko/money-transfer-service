package org.example.moneytransferservice.repository;

import lombok.Getter;

@Getter
public record Operation(long id, String code) {

    public boolean isConfirmed(long id, String code) {
        return this.id == id && this.code.equals(code);
    }
}
