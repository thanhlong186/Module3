package service.impl;

import model.Category;
import repository.ICategoryRepository;
import repository.impl.CategoryRepository;
import service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private ICategoryRepository iCategoryRepository = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }
}
