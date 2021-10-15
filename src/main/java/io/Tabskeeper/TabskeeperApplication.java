package io.Tabskeeper;

import io.Tabskeeper.model.Note;
import io.Tabskeeper.repository.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class TabskeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(TabskeeperApplication.class, args);
	}
	/**
	 * This method runs once when the application starts up
	 *
	 * @param noteRepository
	 * @return
	 */
	@Bean
	public CommandLineRunner runAtStartOfApplicationContext(NoteRepository noteRepository) {
		return (args) -> {
			Iterable<Note> iter = noteRepository.findAll();

			if (!iter.iterator().hasNext()) {
				Note note = new Note();
				note.setBody("Jaron");
				noteRepository.save(note);
			}
		};
	}
	@Bean

	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		corsConfiguration.setAllowedHeaders(Arrays.asList(
				"Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept",
				"X-Requested-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"
		));
		corsConfiguration.setExposedHeaders(Arrays.asList(
				"Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept",
				"X-Requested-With", "Access-Control-Request-Method",
				"Access-Control-Request-Headers"
		));
		corsConfiguration.setAllowedMethods(Arrays.asList(
				"GET","POST","PUT","DELETE","OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource =
				new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
