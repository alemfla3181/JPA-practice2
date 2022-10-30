package com.jpa.jpa02;

import com.jpa.jpa02.entity.CrudEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class Jpa02ApplicationTests {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void InsertTest(){
        String name = "이동욱";
        int age = 35;

        String url = "http://localhost:" + port + "/insert?name=" + name +"&age=" +age;

        ResponseEntity<CrudEntity> responseEntity = restTemplate.getForEntity(url,CrudEntity.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    void ReadTest(){
        String url = "http://localhost:" + port + "/test/search";

        ResponseEntity<CrudEntity> responseEntity = restTemplate.getForEntity(url, CrudEntity.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

}
