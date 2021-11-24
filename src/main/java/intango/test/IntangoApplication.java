package intango.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import intango.test.exceptions.VoteException;
import intango.test.service.ColorVoteService;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class IntangoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(IntangoApplication.class, args);
		
		
		ColorVote colorvote1 = new ColorVote(9,"brown",0);
		ColorVote colorvote2 = new ColorVote(10,"orange",0);
		
		ColorVoteService cs = ctx.getBean(ColorVoteService.class);
		
		try {
			cs.addColorVote(colorvote1);
		} catch (VoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			System.out.println(cs.getColorVotes());
		} catch (VoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("================================");
		try {
			cs.voteFor(1);
		} catch (VoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("================================");
		try {
			cs.addColorVote(colorvote2);
		} catch (VoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(cs.getColorVotes());
		} catch (VoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
