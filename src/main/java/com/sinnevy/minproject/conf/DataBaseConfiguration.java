package com.sinnevy.minproject.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.sinnevy.**.dao"})
public class DataBaseConfiguration {
}
