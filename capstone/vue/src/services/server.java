import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@RestController


public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
}

public class Application implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
  }

  @GetMapping("/s3Url")
  public CompletableFuture<S3UrlResponse> s3Url() {
    return generateUploadURL().thenApply(url -> new S3UrlResponse(url));
  }

  private static class S3UrlResponse {
    private final String url;

    S3UrlResponse(String url) {
      this.url = url;
    }

    public String getUrl() {
      return url;
    }
  }

// The following is the original Express version of the Spring Boot stuff above

// import express from 'express'
// import { generateUploadURL } from './s3.js'

// const app = express()

// app.use(express.static('front'))

// app.get('/s3Url', async (req, res) => {
//   const url = await generateUploadURL()
//   res.send({url})
// })
// // ^^ way to generate and get secure URL from AWS

// app.listen(8080, () => console.log("listening on port 8080"))