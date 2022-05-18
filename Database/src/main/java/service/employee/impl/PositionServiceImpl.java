package service.employee.impl;

import model.Position;
import repository.employee.IPositionRepository;
import repository.employee.impl.PositionRepository;
import service.employee.IPositionService;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private IPositionRepository iPositionRepository = new PositionRepository();
    @Override
    public List<Position> findAllPosition() {
        return iPositionRepository.findAllPosition();
    }
}
