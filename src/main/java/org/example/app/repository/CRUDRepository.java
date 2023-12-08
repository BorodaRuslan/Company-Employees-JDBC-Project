package org.example.app.repository;

public interface CRUDRepository<T> {
    T create();
    T readAll();
    T update();
    T delete();
}
