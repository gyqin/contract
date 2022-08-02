package com.example.contract;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class ContractApplicationTests {

  @Test
  void contextLoads() {
    Stream<String> a = Stream.of("a", "b", "c");
  }

}
