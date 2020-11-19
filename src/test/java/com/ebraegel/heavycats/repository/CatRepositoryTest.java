package com.ebraegel.heavycats.repository;


import com.ebraegel.heavycats.HeavycatsApplication;
import com.ebraegel.heavycats.jpa.repository.CatRepository;
import com.ebraegel.heavycats.model.Cat;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HeavycatsApplication.class})
public class CatRepositoryTest {

    @Autowired
    private CatRepository repository;

    Cat cat1;
    Cat cat2;
    List<Cat> cats;

//    @Test
//    public void whenDeleteByIdFromRepository_thenDeletingShouldBeSuccessful() {
//        repository.deleteById(cat1.getId());
//        assertThat(repository.count()).isEqualTo(1);
//    }
//
//    @Test
//    public void whenDeleteAllFromRepository_thenRepositoryShouldBeEmpty() {
//        repository.deleteAll();
//        assertThat(repository.count()).isEqualTo(0);
//    }
}