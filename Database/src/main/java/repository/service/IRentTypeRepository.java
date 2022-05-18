package repository.service;

import model.RentType;

import java.util.List;

public interface IRentTypeRepository {
    List<RentType> findRentAll();
}
