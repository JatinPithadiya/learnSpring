package com.learn.spring.learnspringframework;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.learn.spring.learnspringframework.enterprise.example.MyWebController;
import com.learn.spring.learnspringframework.game.GameRunner;
import com.learn.spring.learnspringframework.game.MarioGame;
import com.learn.spring.learnspringframework.game.PacmanGame;
import com.learn.spring.learnspringframework.game.SuperContraGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		//System.out.println("Started");

		//MarioGame mario = new MarioGame();
		//SuperContraGame contraGame = new SuperContraGame();
		//PacmanGame pacmanGame = new PacmanGame();
		//GameRunner gameRunner = new GameRunner(pacmanGame);
		GameRunner gameRunner = context.getBean(GameRunner.class);
		gameRunner.run();

		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBussinessService());
	}

}
