package com.sales;

import com.sales.initializer.Postgres;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("dev")
@SpringBootTest()
@ContextConfiguration(initializers = {
        Postgres.Initilizer.class
})
@Transactional
public class SalesAreaTests {

    @BeforeAll
    static void init() {
        Postgres.container.start();
    }

}
