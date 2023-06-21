package cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01;


import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class S05T01N01MohamedAliBilalApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N01MohamedAliBilalApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(Environment environment){
		return args-> {

		};
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();

	}

}
