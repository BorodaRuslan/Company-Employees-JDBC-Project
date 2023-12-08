package org.example.app.repository;



import java.util.List;

public interface FilterRepository <T>{
    List<T> filterByCity(String value);
    List<T> filterByPositions(String value);
    List<T> filterByGender(String value);
    List<T> filterBySalary(double value);

}
