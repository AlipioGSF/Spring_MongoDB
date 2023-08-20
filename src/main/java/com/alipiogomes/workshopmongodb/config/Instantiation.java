package com.alipiogomes.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alipiogomes.workshopmongodb.domain.Post;
import com.alipiogomes.workshopmongodb.domain.User;
import com.alipiogomes.workshopmongodb.dto.AuthorDTO;
import com.alipiogomes.workshopmongodb.repositories.PostRepository;
import com.alipiogomes.workshopmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User alipio = new User(null, "Alipio", "alipio@gmail.com");
		User leo = new User(null, "Leo", "leo@gmail.com");
		User gabs = new User(null, "Gabs", "gabs@gmail.com");

		userRepository.saveAll(Arrays.asList(alipio, leo, gabs));
		
		Post post1 = new Post(null, sdf.parse("20/05/2023"), "Title Post Alipio", "Body post 1", new AuthorDTO(alipio));
		Post post2 = new Post(null, sdf.parse("21/07/2023"), "Title Post2 Alipio", "Body post 2", new AuthorDTO(alipio));
		Post post3 = new Post(null, sdf.parse("14/06/2023"), "Title Post Gabs", "Body post 3", new AuthorDTO(gabs));
		
		postRepository.saveAll(Arrays.asList(post1,post2,post3));
		
		alipio.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(alipio);
	}
	
}
