package team.csjr.moviesys;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan({ "team.csjr.moviesys.mapper"})
@EnableSwagger2
public class MoviesysApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesysApplication.class, args);
	}

}

