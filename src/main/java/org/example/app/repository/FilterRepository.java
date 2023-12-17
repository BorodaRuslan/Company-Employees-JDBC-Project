package org.example.app.repository;



import java.util.List;

public interface FilterRepository <T>{

    // ToDO: Надо модернизировать интерфейс добавить на вход List<String>
    // ToDO: Для большей гибкости приложения!
    // ToDo: Это даст возможность делать фильтрацию по нескольким значениям одновременно!
    List<T> filterByCity(List<String> values);
    List<T> filterByPositions(List<String> values);
    List<T> filterByGender(List<String> values);
    List<T> filterBySalary(List<Double> values);

}
