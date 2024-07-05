package bg.softuni.perfumesworld.init;

import bg.softuni.perfumesworld.model.entity.Category;
import bg.softuni.perfumesworld.model.enumeration.CategoryNameEnum;
import bg.softuni.perfumesworld.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitCategory implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public InitCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(this.categoryRepository.count() > 0){
            return;
        }

        List<Category> categories = new ArrayList<>();

        for (CategoryNameEnum value : CategoryNameEnum.values()) {
            Category category = new Category();
            category.setCategoryName(CategoryNameEnum.valueOf(value.toString()));

            categories.add(category);
        }

        categoryRepository.saveAll(categories);
    }
}
