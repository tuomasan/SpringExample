package view;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@SpringBootApplication
@ComponentScan({"controller"})
public class SampleController {
	public static void main(String[] args) {
		SpringApplication.run(SampleController.class, args);
	}
}
